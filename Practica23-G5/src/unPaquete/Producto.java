/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unPaquete;

/**
 *
 * @author Usuario
 */
public class Producto {
    //Atributos
    String nombre;
    String descripcion;
    float precio;
    String estado;
    String categoria;
    
    public void mostrar () {
        System.out.println("El nombre del producto es:"+ nombre +"Su descripcion:"+ descripcion + "Su precio:"+ precio +"Su estado:"+ estado +"Su categoria:"+ categoria);
    }
}
