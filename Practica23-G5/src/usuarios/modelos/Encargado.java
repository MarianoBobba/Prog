/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 *
 * @author Usuario
 */
    public class Encargado extends Usuario{
      //Constructor
          public Encargado (String correo, String clave, String apellido, String nombre, String claveRepetida, Perfil perfil) {    
        super(correo, clave, apellido, nombre, claveRepetida, perfil);
    }

}
