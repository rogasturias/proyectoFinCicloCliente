/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;

import LogicaDatos.Datos.Datos;
import LogicaDatos.Datos.HiloSeleccionVendedor;
import caguela.Pedido;
import java.awt.Frame;
import java.util.ArrayList;

/**
 *clase que gestiona los hilos en caso de que se escoga un elegir opciones o 
 * volver desde alguna menu
 * @author rogas
 */
public class HiloElegirOpcciones extends Thread {

    Frame origen;

    public HiloElegirOpcciones(Frame frame) {
        this.origen = frame;

    }

    @Override
    public void run() {

            int resultado;
            if(Datos.CLIENTE.isVendedor()){
            Datos.rolVender= MetodosEstaticosDialogos.avisoDialogo(origen, "Vender", "Comprar", "¿Que deseas hacer?");
            }       
        
            if (Datos.rolVender) {
                resultado = MetodosEstaticosDialogos.eligeCombo(origen, "Aceptar", "Cancelar", Datos.OPCIONES_VENDEDOR);
                System.out.println("********************************* ha elegido : " + Datos.OPCIONES_VENDEDOR[resultado]);
                switch (resultado) {
                    case 0:
                        
                        Grafica.Frames.Dialogo_vender_Productos = new Vender_Productos();
                        
                        Grafica.Frames.Dialogo_vender_Productos.setVisible(true);
                        origen.dispose();
                        break;
                    // en este caso coinciden, pero en el futuro podria ser pantalla distinta.        
                    case 1:
                        
                            Grafica.Frames.Dialogo_vender_Productos = new Vender_Productos();
                        
                        Grafica.Frames.Dialogo_vender_Productos.setVisible(true);
                        origen.dispose();
                        break;

                    case 2:
                        boolean confirm = MetodosEstaticosDialogos.avisoDialogo(origen, "Salir", "Cancelar", "Deseas abandonar la applicacion?");
                        if (confirm) {
                            origen.dispose();
                            System.exit(0);
                            
                        }
                        break;
                }

            } else {
                resultado = MetodosEstaticosDialogos.eligeCombo(origen, "Aceptar", "Cancelar", Datos.OPCIONES_COMPRADOR);
                System.out.println("*********************************" + Datos.OPCIONES_VENDEDOR[resultado]);
                switch (resultado) {
                    case 0:

                        int opcion = MetodosEstaticosDialogos.dialogoComboEligeVendedor(origen);
                        System.out.println("/////////////////////////////// has optado por elegir " + opcion);

                        if (opcion >= 0) {

                            Datos.VENDEDOR = Datos.todosVendedores.get(opcion);
                            System.out.println("ha elegido como vendedor para su pedido a " + Datos.VENDEDOR.getNombre());
                            Datos.pedidoNuevo = new Pedido();
                            Datos.posicionesNuevoPedido = new ArrayList<>();
                            Datos.pedidoNuevo.setComprador(Datos.CLIENTE);
                            Datos.pedidoNuevo.setVendedor(Datos.VENDEDOR);
                            
                            
                            new HiloSeleccionVendedor(Datos.VENDEDOR).start();
                            
                            Grafica.Frames.DialogoNuevoPedido = new Nuevo_pedido();
                            
                            Grafica.Frames.DialogoNuevoPedido.setVisible(true);
                            origen.dispose();
                        }
                        break;

                    case 1:
                        
                            Grafica.Frames.Dialogo_revisar_Pedido_Comprador = new Revisar_Pedido_Comprador();
                        
                        Grafica.Frames.Dialogo_revisar_Pedido_Comprador.setVisible(true);
                        origen.dispose();
                        break;
                    case 2:
                        boolean result2 = MetodosEstaticosDialogos.avisoDialogo(origen, "Salir", "Cancelar", "Deseas abandonar la applicacion? " );
                        if (result2) {
                            origen.dispose();
                            System.exit(0);

                        }
                        break;
                }
            }
        

    }

}
