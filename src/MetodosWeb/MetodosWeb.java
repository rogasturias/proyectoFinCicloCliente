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

    
    
    
    
    
    public static Cliente login(java.lang.String usuario, java.lang.String clave) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.login(usuario, clave);
    }

    

    public static boolean actualizaCliente(caguela.Cliente cliente) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.actualizaCliente(cliente);
    }

    public static int guardaCliente(caguela.Cliente cliente) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.guardaCliente(cliente);
    }

    public static int guardaDireccion(caguela.Direccion direccion) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.guardaDireccion(direccion);
    }

    public static int guardarUsuario(caguela.Usuario usuario) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.guardarUsuario(usuario);
    }

    public static java.util.List<java.lang.Object> productosCompradosHabitualmente(caguela.Cliente cliente, boolean activo, boolean recibido) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.productosCompradosHabitualmente(cliente, activo, recibido);
    }

    public static java.util.List<java.lang.Object> pedidosCliente(caguela.Cliente cliente) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.pedidosCliente(cliente);
    }

    public static java.util.List<java.lang.Object> pedidosVendedor(caguela.Cliente cliente) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.pedidosVendedor(cliente);
    }

    public static java.util.List<java.lang.Object> todosVendedores() {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.todosVendedores();
    }

    public static java.util.List<java.lang.Object> productosGamaVendedor(caguela.Cliente cliente) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.productosGamaVendedor(cliente);
    }

    public static boolean actualizaProducto(caguela.Producto producto) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.actualizaProducto(producto);
    }

    

    

    public static boolean actualizaTipoEnvase(caguela.TipoEnvase tipoEnvase) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.actualizaTipoEnvase(tipoEnvase);
    }

    

    public static int guardaProducto(caguela.Producto producto) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.guardaProducto(producto);
    }

    public static int guardaTipoEnvase(caguela.TipoEnvase tipoEnvase) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.guardaTipoEnvase(tipoEnvase);
    }

    public static boolean actualizaPedido(caguela.Pedido pedido) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.actualizaPedido(pedido);
    }

    public static int guardaPedido(caguela.Pedido pedido) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.guardaPedido(pedido);
    }

    public static java.util.List<java.lang.Object> posicionesPendientesVendedor(caguela.Cliente clliente, boolean vendedor) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.posicionesPendientesVendedor(clliente, vendedor);
    }

    public static boolean actualizaPosicion(caguela.Posicion posicion) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.actualizaPosicion(posicion);
    }

    public static int guardarPosicion(caguela.Posicion posicion) {
        caguela.CaGuela_Service service = new caguela.CaGuela_Service();
        caguela.CaGuela port = service.getCaGuelaPort();
        return port.guardarPosicion(posicion);
    }

    

    
   

    

   
    

    

    
    
    
    
    
    
    
}
