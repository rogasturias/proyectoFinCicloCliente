/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDatos.Datos;

import caguela.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rogas
 */
public class HiloTodosVendedores extends Thread {
    ArrayList <Cliente> vendedores;

    public HiloTodosVendedores() {
        System.out.println("*************************lanzado el hilo de todos vendedores");
    }

    @Override
    public void run() {
        // Syncro obtener todos los vendedores
        synchronized(this){
            Datos.todosVendedores= new ArrayList<>();
            List<Object> respuesta = MetodosWeb.MetodosWeb.todosVendedores();
            System.out.println("********************* total de vendedores "+respuesta.size());
            for (Object object : respuesta) {
                Cliente cli = (Cliente)object;
                Datos.todosVendedores.add(cli);
            }
        }
        
        
    }
    
    
    
}
