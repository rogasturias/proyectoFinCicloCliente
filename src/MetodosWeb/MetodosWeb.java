/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetodosWeb;

import caguela.Cliente;

/**
 * clase que recoge los metodos necesarios del web service para ser utilizados.
 * @author rogas
 */
public class MetodosWeb {

    
    
    
    /**
    * Metodo que comprueba mediante usuario y clave si un usuario está registrado
    * devolviendo el Cliente de este usuario y clave
    */
    
    public static Cliente login(java.lang.String usuario, java.lang.String clave) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.login(usuario, clave);
    }

    
    /**
    *Metodo que actualiza el estado de un cliente, devolviendo true o false
    */
    public static boolean actualizaCliente(caguela.Cliente cliente) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.actualizaCliente(cliente);
    }

    /**
    *Metodo que guarda un nuevo cliente, devolviendo el id asignado
    */
    public static int guardaCliente(caguela.Cliente cliente) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.guardaCliente(cliente);
    }

    /**
    *Metodo que guarda una direccion, devolvendo el id asignado
    */
    
    public static int guardaDireccion(caguela.Direccion direccion) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.guardaDireccion(direccion);
    }

     /**
    *Metodo que guarda un usuario, devolvendo el id asignado
    */
    public static int guardarUsuario(caguela.Usuario usuario) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.guardarUsuario(usuario);
    }
    
    /**
    *Metodo que devuelve un list de productos, comprados habitualmente por un cliente
    */

    public static java.util.List<java.lang.Object> productosCompradosHabitualmente(caguela.Cliente cliente, boolean activo, boolean recibido) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.productosCompradosHabitualmente(cliente, activo, recibido);
    }

    /**
    *Metodo que devuelve un list de pedidos pendientes de un cliente
    */
    
    public static java.util.List<java.lang.Object> pedidosCliente(caguela.Cliente cliente) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.pedidosCliente(cliente);
    }

    /**
    *Metodo que devuelve un list de pedidos pendientes de un vendedor
    */
    public static java.util.List<java.lang.Object> pedidosVendedor(caguela.Cliente cliente) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.pedidosVendedor(cliente);
    }

    /**
    *Metodo que devuelve un list de clientes, que son vendedores.
    */
    public static java.util.List<java.lang.Object> todosVendedores() {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.todosVendedores();
    }
    /**
    *Metodo que devuelve un list de los productos de un vendedor
    */  

    public static java.util.List<java.lang.Object> productosGamaVendedor(caguela.Cliente cliente) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.productosGamaVendedor(cliente);
    }

    /**
    *Metodo que actualiza un producto que ha sido modificado, devolviendo true o false 
    * si la accion se realizó
    */    
    public static boolean actualizaProducto(caguela.Producto producto) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.actualizaProducto(producto);
    }

    
    /**
    *Metodo que actualiza un TipoEnvase que ha sido modificado, devolviendo true o false 
    * si la accion se realizó
    */
    

    public static boolean actualizaTipoEnvase(caguela.TipoEnvase tipoEnvase) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.actualizaTipoEnvase(tipoEnvase);
    }

    /**
    * Metodo que guarda un producto, devolvendo el id asignado
    */

    public static int guardaProducto(caguela.Producto producto) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.guardaProducto(producto);
    }
    
    /**
    * Metodo que guarda un TipoEnvase, devolvendo el id asignado
    */
    public static int guardaTipoEnvase(caguela.TipoEnvase tipoEnvase) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.guardaTipoEnvase(tipoEnvase);
    }

     /**
    * Metodo que actualiza un pedido, devolvendo true o false si la accion se realizó
    */
    public static boolean actualizaPedido(caguela.Pedido pedido) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.actualizaPedido(pedido);
    }

    /**
    * Metodo que guarda un Pedido, devolvendo el id asignado
    */    

    public static int guardaPedido(caguela.Pedido pedido) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.guardaPedido(pedido);
    }

    /**
    * Metodo que devuelve todas las posiciones de un vendedor, de pedidos pendientes.
    */
    public static java.util.List<java.lang.Object> posicionesPendientesVendedor(caguela.Cliente clliente, boolean vendedor) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.posicionesPendientesVendedor(clliente, vendedor);
    }
    
    /**
    * Metodo que actualiza una Posicion, devolvendo true o false si la accion se realizó
    */
    
    public static boolean actualizaPosicion(caguela.Posicion posicion) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.actualizaPosicion(posicion);
    }
    
     /**
    * Metodo que guarda una Posicion, devolvendo el id asignado
    */ 
    
    public static int guardarPosicion(caguela.Posicion posicion) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.guardarPosicion(posicion);
    }

    

    
   

    

   
    

    

    
    
    
    
    
    
    
}
