package LogicaDatos.DTO;


import caguela.Cliente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rogas
 */
public class ClienteLocal extends Cliente {

    @Override
    public String toString() {
        return "{nombre:"+super.nombre+"apellido: "+super.apellidos+", descripcion"+super.descripcion+"}";
    }

    
    
    
    
}
