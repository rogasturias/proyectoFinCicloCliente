/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDatos.Datos;

import Grafica.Nuevo_pedido;
import Grafica.Principal_login;
import Grafica.Principal_nuevoUser;
import Grafica.Revisar_Pedido_Comprador;
import Grafica.Vender_Productos;
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
public class Datos {
    
    
    // constantes
    public final static String[] OPCIONES_COMPRADOR = {"Nuevo Pedido","Revisar Pedidos","Salir"};                       
    public final static String[] OPCIONES_VENDEDOR = {"Gestionar Productos","Revisar Pedidos","Salir"};
    
    // datos de aplicacion BBDD 
      /////////////////////////////// AL INICIAR   /////////////////////
    // todos los vendedores de alta.    
    public static ArrayList<Cliente> todosVendedores;
    
    
    /////////////////////////////// AL SELECCIONAR UN CLIENTE  /////////////////////
    // el CLIENTE
    public static Cliente CLIENTE;
    // su rol
    public static boolean rolVender;
    //productos habituales comprados de varios vendedores
    public static List <Producto> productosHabituales;
    // pedidos pendientes del comprador, con varios vendedores
    public static ArrayList <Pedido> pedidosClienteComoComprador;
    // pedidos de un CLIENTE VENDEDOR pendientes.
    public static ArrayList <Pedido> pedidosClienteComoVendedor;
    // gama de productos de un CLIENTE VENDEDOR
    public static ArrayList <Producto> productosGamaPropiaVendedor;
    
    public static ArrayList<Posicion> posicionesPendientesVendedor;
    public static ArrayList<Posicion> posicionesPendientesComprador;
    
    


/////////////////////////////// AL SELECCIONAR UN VENDEDOR  /////////////////////
    // todos los vendedores de alta.  
    public static Cliente VENDEDOR;
    public static ArrayList<Producto> productosParaVender;
    
    public static ArrayList <Producto> productosClienteVendedor;
    
    public static Pedido pedidoNuevo;
    public static List<Posicion> posicionesNuevoPedido;
    
    
    
    
    
    
  
    

}
