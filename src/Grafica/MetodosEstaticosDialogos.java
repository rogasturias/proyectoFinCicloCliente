/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;


import Grafica.Dialogos.DialogoAcercaDE;
import Grafica.Dialogos.DialogoComboBox;
import Grafica.Dialogos.DialogoAlerta;
import Grafica.Dialogos.DialogoComboEligeVendedor;
import Grafica.Dialogos.DialogoPedido;
import Grafica.Dialogos.DialogoProducto;
import Grafica.Dialogos.DialogoProductoAdd;
import caguela.Pedido;
import caguela.Posicion;
import caguela.Producto;
import java.awt.Frame;
import javax.swing.DefaultComboBoxModel;

/**
 * Clase que recoge Metodos para gestionar la GUI del usuario y los dialogos.
 * @author rogas
 */
public class MetodosEstaticosDialogos {
    
    /**
     * Metodo que abre un dialogo para recoger si aceptamos o cancelamos un
     * mensaje pasamos por paramentro el mensaje, y los textos de los botones.
     *
     * @param textoBoton1
     * @param textoBoton2
     * @param textoAviso
     * @return
     */
    public static boolean avisoDialogo(Frame panel, String textoBoton1, String textoBoton2, String textoAviso) {
       DialogoAlerta dialogo = new DialogoAlerta(panel, true);
        dialogo.botonAceptar.setText(textoBoton1);
        dialogo.botonCancelar.setText(textoBoton2);
        dialogo.EtiquetaAviso.setText(textoAviso);
        dialogo.setVisible(true);
        boolean resultado = dialogo.resultado;
        dialogo.dispose();
        return resultado;        
    }
    /**
     * Metodo que abre un dialogo para informarnos de un
     * mensaje pasamos por paramentro el mensaje, y el texto de los botones.
     * @param panel
     * @param textoBoton1
     * @param textoAviso
     * @return 
     */
    public static boolean avisoDialogo(Frame panel, String textoBoton1, String textoAviso) {
       DialogoAlerta dialogo = new DialogoAlerta(panel, true);
        dialogo.botonAceptar.setText(textoBoton1);
        dialogo.botonCancelar.setText("");
        dialogo.botonCancelar.setEnabled(false);
        dialogo.EtiquetaAviso.setText(textoAviso);
        dialogo.setVisible(true);
        boolean resultado = dialogo.resultado;
        dialogo.dispose();
        return resultado;        
    }

    /**
     * Metodo que abre un dialogo para recoger nuestra seleccion de un listado
     * mediante un combo pasamos los textos de los botones y un array de datos
     * String[], devolviendo el index de la opcion elegida en caso de cancelar o
     * de no elegir devuelve index=-1
     *
     * @param textoBoton1
     * @param textoBoton2
     * @param datos
     * @return
     */
     public static int eligeCombo(Frame panel, String textoBotonAcepta, String textoBotonCancelar, String[] datosArray) {
        DialogoComboBox dialogo = new DialogoComboBox(panel, true);
        dialogo.botonAceptar.setText(textoBotonAcepta);
        dialogo.botonCancelar.setText(textoBotonCancelar);
        
        dialogo.comboDialogo.removeAllItems();
        
        DefaultComboBoxModel  <String> combo = new DefaultComboBoxModel();
        combo.addElement("seleccione");
        for (String dato : datosArray) {
            combo.addElement(dato);
        }
        dialogo.comboDialogo.setModel(combo);
         
        dialogo.comboDialogo.setSelectedIndex(0);
       
        dialogo.setVisible(true);
        int index;
        boolean resultado = dialogo.resultado;
        if (dialogo.resultado) {
            index = dialogo.index;
            index--;
        } else {
            index = -1;
        }
        dialogo.dispose();
        return index;  
      
    }
     /**
      * Metodo que llama a la pantalla de dialogo Elige vendedor, y nos retorna el id del vendedor
      * @param panel
      * @return 
      */
    public static int dialogoComboEligeVendedor(Frame panel){
        DialogoComboEligeVendedor dialogo = new DialogoComboEligeVendedor(panel, true);
        dialogo.setVisible(true);
        if(dialogo.resultado){
        return dialogo.index;
        }
        else return 0;
    }
     
        
    
    
    /**
     * Meetodo que pasado un Frame panel principal abre un dialogo modal y procesa un objeto
     * nos devolvera un objeto si ha sido modificado o creado,y un null si hemos cancelado
     * @param panel
     * @return 
     */
 public static Producto dialogoProducto(Frame panel, Producto producto){
      // abrimos un dialogo producto
      DialogoProducto dialogoProducto = new DialogoProducto(panel,producto,true);
      
      // visualizo el dialogo
      dialogoProducto.setVisible(true);
      
        // ahora esperaremos por ser modal a que termine el dialogo, cuando pulsen en boton del dialogo, recuperamos
        // recogemos el producto del dialogo, y el result de los botones.
        Producto productoResultado = dialogoProducto.getProducto();
        System.out.println("****************************** producto resultado "+productoResultado.getNombre());
        boolean result = dialogoProducto.resultado;
        // ahora podemos destruir el objeto dialogo
        dialogoProducto.dispose();
      
        // en funcion del result aceptar/cancelar devuelvo el producto o null
        if(result){
            return productoResultado;
        }
        else{
            return null;
        }
      
      
  }  

 /**
  * Metodo que llama a la pantalla dialogo de add producto, y retorna una posicion
  * con la cantidad y el producto elegido, asociado al pedido actual
  * @param panel
  * @param producto
  * @return 
  */
 public static Posicion dialogoProductoAdd(Frame panel, Producto producto){
      // abrimos un dialogo producto
      DialogoProductoAdd dialogoProducto = new DialogoProductoAdd(panel,producto,true);
      
      // visualizo el dialogo
      dialogoProducto.setVisible(true);
      
        // ahora esperaremos por ser modal a que termine el dialogo, cuando pulsen en boton del dialogo, recuperamos
        // recogemos el producto del dialogo, y el result de los botones.
        Producto productoResultado = dialogoProducto.producto;
        int cantidad = dialogoProducto.cantidad;
        Posicion nuevaPosicion =dialogoProducto.nuevaPosicion;
        boolean result = dialogoProducto.resultado;
        System.out.println("****************************** producto resultado "+productoResultado.getNombre()+", "+cantidad+"-"+result);
        
        // ahora podemos destruir el objeto dialogo
        dialogoProducto.dispose();
      
        // en funcion del result aceptar/cancelar devuelvo el producto o null
        if(result){
            
            return nuevaPosicion;
        }
        else{
            return null;
        }
      
      
  }  
 
 
  /**
   * Metodo que pasado un frame panel principal abre un dialogo modal y proceso un objeto pedido
   * nos devolvera un objeto si ha sido modificado o creado, y un null si hemos cancelado
   * @param panel
   * @param objetoPedido
   * @return 
   */
  public static Pedido dialogoPedido(Frame panel, Pedido pedido, boolean vendedor){
      // abrimos un dialogo pedido
      DialogoPedido dialogoPedido = new DialogoPedido(panel, true, pedido,vendedor);
       System.out.println("*******************************abriendo pedido como vendedor "+vendedor);    
      if(vendedor){
          dialogoPedido.checkAceptar.setEnabled(true);
          dialogoPedido.checkEnviar.setEnabled(true);
          dialogoPedido.checkRecibir.setEnabled(false);
      }
      else{
          dialogoPedido.checkAceptar.setEnabled(false);
          dialogoPedido.checkEnviar.setEnabled(false);
          dialogoPedido.checkRecibir.setEnabled(true);
      }
      
      // cargo el pedido en el dialogo
      System.out.println("************************** cargando pedido del vende "+pedido.getVendedor().getNombre()+"/"+pedido.getComprador().getNombre());
      dialogoPedido.setPedido(pedido);
      // visualizo el dialogo
      dialogoPedido.setVisible(true);
      
        // ahora esperaremos por ser modal a que termine el dialogo, cuando pulsen en boton del dialogo, recuperamos
        // recogemos el producto del dialogo, y el result de los botones.
        Pedido pedidoResultado = dialogoPedido.getPedido();
        boolean result = dialogoPedido.resultado;
        // ahora podemos destruir el objeto dialogo
        dialogoPedido.dispose();
      
        // en funcion del result aceptar/cancelar devuelvo el producto o null
        if(result){
            return pedidoResultado;
        }
        else{
            return null;
        }
     
      
  }  
    /**
     * Metodo que rellena la pantalla dialogo de Acerca de
     * @param panel
     * @return 
     */
    
     public static boolean acercaDe(Frame panel) {
        String texto="Esta aplicacion ha sido diseñada para crear un canal de ventas "
                + "compartidos para pequeños productores y consumidores de productos "
                + "artesanos y naturales.\n" +
                    "\n"+
                "El objetivo es fomentar y difundir los principios de:\n" +
                    "\n"+                
                    "Calidad\n" +
                    "Ecologia\n" +
                    "Slow Food\n" +
                    "\n" +
                                
                "Ha sido desarrollada como trabajo de fin de Ciclo DAM del IES Juan Jose Calvo Miguel,"
                + " por :"+"\n" +"\nRoberto Gutierrez Galiano "+"\nen el curso 2016-2017."+
                "\n\n Gracias a todos los que han hecho posible este proyecto.";
        DialogoAcercaDE dialogo = new DialogoAcercaDE(panel, true);
        dialogo.botonAceptar.setText("Aceptar");
        dialogo.botonCancelar.setText("");
        dialogo.EtiquetaAviso.setText(texto);
        dialogo.setVisible(true);
        boolean resultado = dialogo.resultado;
        dialogo.dispose();
        return resultado;
    }
    

}
