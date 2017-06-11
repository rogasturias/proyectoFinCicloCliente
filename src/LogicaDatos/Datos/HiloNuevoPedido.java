/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDatos.Datos;

import caguela.Posicion;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author rogas
 */
public class HiloNuevoPedido extends Thread{
     

    public HiloNuevoPedido() {
        System.out.println("*************************lanzado el hilo de nuevo Pedido");
        System.out.println("*************************sobre el pedido : "+Datos.pedidoNuevo.getId());
    }

    @Override
    public void run() {
        // Syncro obtener todos los vendedores
        synchronized(this){
            
            Datos.pedidoNuevo.setActivo(true);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                DatatypeFactory datatypeFactory = null;
                    try {
                        datatypeFactory = DatatypeFactory.newInstance();
                    } catch (DatatypeConfigurationException ex) {
                            Logger.getLogger(HiloNuevoPedido.class.getName()).log(Level.SEVERE, null, ex);
                    }
                XMLGregorianCalendar now = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
            Datos.pedidoNuevo.setFecha(now);
            
            int id = MetodosWeb.MetodosWeb.guardaPedido(Datos.pedidoNuevo);
            Datos.pedidoNuevo.setId(id);
            for( Posicion pos :Datos.posicionesNuevoPedido){
                if(pos.getCantidad() != 0){
                        pos.setPedido(Datos.pedidoNuevo);
                        id = MetodosWeb.MetodosWeb.guardarPosicion(pos);
                        pos.setId(id);
                        Datos.posicionesPendientesComprador.add(pos);
                                
                    }                
                }           
            }
            
            
            MetodosWeb.MetodosWeb.actualizaPedido(Datos.pedidoNuevo);
            Datos.pedidosClienteComoComprador.add(Datos.pedidoNuevo);
                        
            
        
                
    }
      
    
    
    
}
