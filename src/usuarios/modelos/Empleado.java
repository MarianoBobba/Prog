/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author Usuario
 */
public class Empleado extends Usuario{
    
    
    //Constructor
      public Empleado(String correo, String clave, String apellido, String nombre, String claveRepetida, Perfil perfil) {    
        super(correo, clave, apellido, nombre, claveRepetida, perfil);
    }
    
}
