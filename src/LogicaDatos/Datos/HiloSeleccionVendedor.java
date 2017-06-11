/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDatos.Datos;

import caguela.Cliente;
import caguela.Pedido;
import caguela.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rogas
 */
public class HiloSeleccionVendedor extends Thread {

    Cliente vendedor;

    public HiloSeleccionVendedor(Cliente vendedor) {
        this.vendedor = vendedor;
        Datos.VENDEDOR = vendedor;
        System.out.println("**********************lanzado el hilo vendedor selecionado "+vendedor.getNombre());
    }

    @Override
    public void run() {
        List<Object> respuesta = MetodosWeb.MetodosWeb.productosGamaVendedor(vendedor);
        System.out.println("****************** el vendedor elegido tiene productos "+respuesta.size());
        synchronized (this) {
            Datos.pedidoNuevo = new Pedido();
            Datos.pedidoNuevo.setActivo(true);
            Datos.pedidoNuevo.setComprador(Datos.CLIENTE);
            Datos.pedidoNuevo.setVendedor(Datos.VENDEDOR);
            Datos.posicionesNuevoPedido = new ArrayList<>();
            
            System.out.println("****************************** creado un nuevo pedido para hacer una compra");
            
            Datos.productosParaVender = new ArrayList<>();
            for (Object pro : respuesta) {
                Datos.productosParaVender.add((Producto) pro);
            }
            
            Datos.productosClienteVendedor = new ArrayList<>();
            for (Producto pro : Datos.productosHabituales) {

                if (pro.getVendedor().equals(vendedor)) {
                    Datos.productosClienteVendedor.add(pro);
                }
            }
            
            Datos.posicionesNuevoPedido= new ArrayList<>();
        }
        
        
        

    }

}
