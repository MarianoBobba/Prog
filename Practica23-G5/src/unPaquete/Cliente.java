/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unPaquete;

/**
 *
 * @author Usuario
 */
public class Cliente {
    //Atributos
    String nombre;
    String apellido;
    String correo;
    String clave;
    
    public void mostrar () {
        System.out.println("El nombre del cliente es:"+ nombre + apellido + "Su correo:"+ correo + "Su contraseña:"+ clave);
    }
}
