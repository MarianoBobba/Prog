/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;


import pedidos.modelos.Pedido;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Cliente {
     //Atributos
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;
    private ArrayList<Pedido> pedidos;
    
    //Constructor
    public Cliente(String nombre, String apellido, String correo, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
    }
    
    //Metodos
    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String verApellido() {
        return apellido;
    }

    public void asignarApellido(String apellido) {
        this.apellido = apellido;
    }

    public String verCorreo() {
        return correo;
    }

    public void asignarCorreo(String correo) {
        this.correo = correo;
    }

    public String verClave() {
        return clave;
    }

    public void asignarClave(String clave) {
        this.clave = clave;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    
    public void mostrar (){
        System.out.println("El cliente es:"+ nombre + apellido + "Su correo es:" + correo + "Su clave es:" + clave);
    }
    
}
