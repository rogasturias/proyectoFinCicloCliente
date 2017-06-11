/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDatos.Datos;

import caguela.Cliente;
import caguela.Pedido;
import caguela.Posicion;
import caguela.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rogas
 */
public class HiloSeleccionCliente extends Thread {

    Cliente cliente;

    public HiloSeleccionCliente(Cliente cliente) {
        this.cliente = cliente;
        Datos.CLIENTE = cliente;
        System.out.println("***********************lanzado hilo cliente");
    }

    @Override
    public void run() {
        // Syncro cargar los datos de CLIENTE
        // 1 Productos comprados habitualmente, que ya han sido recibidos
        List<Object> respuesta = MetodosWeb.MetodosWeb.productosCompradosHabitualmente(cliente, true, true);
        synchronized (this) {
            Datos.productosHabituales = new ArrayList<>();
            for (Object object : respuesta) {
                Producto p = (Producto) object;
                Datos.productosHabituales.add(p);
            }
            System.out.println("*********** total productos habituales " + respuesta.size());
        }

        // 2 Pedidos pendientes.... segun estado( podran ser como comprador o VENDEDOR)
        respuesta = MetodosWeb.MetodosWeb.pedidosCliente(cliente);
        Datos.pedidosClienteComoComprador = new ArrayList<>();
        synchronized (this) {
            if (!Datos.rolVender) {
                for (Object object : respuesta) {
                    Pedido p = (Pedido) object;
                    Datos.pedidosClienteComoComprador.add(p);
                }
                System.out.println("*********** total pedidos pendientes como comprador " + respuesta.size());
            }

        }
        Datos.pedidosClienteComoVendedor = new ArrayList<>();
        synchronized (this) {
            if (Datos.rolVender) {
                respuesta = MetodosWeb.MetodosWeb.pedidosVendedor(cliente);
                for (Object object : respuesta) {
                    Pedido p = (Pedido) object;
                    Datos.pedidosClienteComoVendedor.add(p);
                }
                System.out.println("*********** total pedidos pendientes como vendedor " + respuesta.size());
            }
        }
        // 3 si es VENDEDOR, vendiendo, todos los productos que vende, para gestionar;
        Datos.productosGamaPropiaVendedor = new ArrayList<>();
        synchronized (this) {
            if (Datos.rolVender) {
                respuesta = MetodosWeb.MetodosWeb.productosGamaVendedor(cliente);
                for (Object object : respuesta) {
                    Producto p = (Producto) object;
                    Datos.productosGamaPropiaVendedor.add(p);
                }
                System.out.println("*********** total productos en gama como vendedor " + respuesta.size());
            }
        }

        synchronized (this) {
            // todas las posiciones de pedidos pendientes
            Datos.posicionesPendientesVendedor = new ArrayList<>();
            if (Datos.rolVender) {
                respuesta = MetodosWeb.MetodosWeb.posicionesPendientesVendedor(cliente,true);
                for (Object object : respuesta) {
                    Posicion p = (Posicion) object;
                    Datos.posicionesPendientesVendedor.add(p);
                }
                System.out.println("*********** total posiciones pendientes en pedidodos como vendedor " + respuesta.size());

            }
        }
        
        synchronized (this) {
            // todas las posiciones de pedidos pendientes
            Datos.posicionesPendientesComprador = new ArrayList<>();
           
            respuesta = MetodosWeb.MetodosWeb.posicionesPendientesVendedor(cliente,false);
                for (Object object : respuesta) {
                    Posicion p = (Posicion) object;
                    Datos.posicionesPendientesComprador.add(p);
                }
                System.out.println("*********** total posiciones pendientes en pedidodos como comprador " + respuesta.size());

            
        }
        

    }

}
