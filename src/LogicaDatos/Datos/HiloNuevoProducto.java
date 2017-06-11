/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDatos.Datos;

import caguela.Producto;
import caguela.TipoEnvase;
import java.awt.Frame;

/**
 *
 * @author rogas
 */
public class HiloNuevoProducto extends Thread {
    Producto producto;
    boolean resultado;
    Frame frame;
    
    public HiloNuevoProducto(Frame frame, Producto producto) {
        this.producto = producto;
        this.frame = frame;
    }

    @Override
    public void run() {
            TipoEnvase nuevoTipoEnvase = producto.getTipoEnvase();
            int result1 = MetodosWeb.MetodosWeb.guardaTipoEnvase(nuevoTipoEnvase);
            nuevoTipoEnvase.setId(result1);            
            int result = MetodosWeb.MetodosWeb.guardaProducto(producto);
            producto.setId(result);
            Datos.productosGamaPropiaVendedor.add(producto); 
    }
    
    
    
}
