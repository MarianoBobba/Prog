/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import pedidos.modelos.Pedido;

/**
 *
 * @author Usuario
 */
public class Usuario {
    //Atributos
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;
    private String claveRepetida;
    private Perfil perfil;

    //Contructor
    public Usuario(String correo, String clave, String apellido, String nombre, String claveRepetida, Perfil perfil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
        this.claveRepetida = claveRepetida;
        this.perfil = perfil;
    }
    
    //Metodos
    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pedido> verPedidos() {
        List<Pedido> pedidos = null;
        return pedidos;
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
    
    public Perfil verPerfil() {
        return perfil;
    }

    public void asignarPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
    public String verClaveRepetida() {
        return claveRepetida;
    }

    public void asignarClaveRepetida(String claveRepetida) {
        this.claveRepetida = claveRepetida;
    }
    
    public void mostrar (){
        System.out.println(apellido + "," + nombre);
        System.out.println("Correo: " + correo);
        //System.out.println("El usuario es:"+ nombre + apellido + "Su correo es:" + correo + "Su clave es:" + clave);
    }
    
    
    public String toCSV() {
        return correo + "," + apellido + "," + nombre + "," + clave + "," + claveRepetida + "," + perfil;
    }
     
    public static Usuario convertirDesdeCSV(String csv) {
        String[] datos = csv.split(",");
        if (datos.length != 5) {
            return null;
        }
        return null;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass().getSuperclass() != o.getClass().getSuperclass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(correo, usuario.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correo);
    }


}

