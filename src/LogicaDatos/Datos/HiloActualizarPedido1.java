/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDatos.Datos;

import Email.HiloEnviarMail;
import Grafica.MetodosEstaticosDialogos;
import caguela.Pedido;
import java.awt.Frame;

/**
 *
 * @author rogas
 */
public class HiloActualizarPedido1 extends Thread{
     private Pedido pedido;
     private Frame frame;

    public HiloActualizarPedido1(Frame frame, Pedido pedido) {
        System.out.println("*************************lanzado el hilo de actualizar Pedido");
        this.pedido=pedido;
        this.frame=frame;
    }

    @Override
    public void run() {
        // Syncro obtener todos los vendedores
        synchronized(this){
            
            boolean result = MetodosWeb.MetodosWeb.actualizaPedido(pedido);
            
            String mensaje= "No se han podido guardar los datos del pedido "+pedido.getId();
            if(result){
                 mensaje=" Se han guardado los datos del pedido "+pedido.getId();
                 
            }
            MetodosEstaticosDialogos.avisoDialogo(frame, "Aceptar", mensaje);
            if(pedido.isRecibido()){
                new HiloEnviarMail("rogasturias@gmail.com", " se ha recibio el pedido "+pedido.getId(), "se ha recibido el pedido "+pedido.getId(),pedido.getVendedor().getId()).start();
            }           
            }
                        
            MetodosWeb.MetodosWeb.actualizaPedido(Datos.pedidoNuevo);
            Datos.pedidosClienteComoComprador.add(Datos.pedidoNuevo);                        
            
          
    }
      
    
    
    
}
