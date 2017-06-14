/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDatos.Datos;

import Grafica.MetodosEstaticosDialogos;
import caguela.Producto;
import java.awt.Frame;

/**
 *
 * @author rogas
 */
public class HiloActualizarProducto extends Thread {
    private Producto producto;
    private boolean resultado;
    private Frame frame;
    
    public HiloActualizarProducto(Frame frame, Producto producto) {
        this.producto = producto;
        this.frame = frame;
    }

    @Override
    public void run() {
        
            boolean result = MetodosWeb.MetodosWeb.actualizaProducto(producto);
            boolean result2= MetodosWeb.MetodosWeb.actualizaTipoEnvase(producto.getTipoEnvase());
            
            String mensaje = "No se han podido actualizar todos los datos, intentelo mas tarde,gracias";
            if(result & result2){
                mensaje="Se han actualizado los datos del producto";
            }
            
            MetodosEstaticosDialogos.avisoDialogo(frame, "Aceptar", mensaje); 
    
    }
    
    
    
}
