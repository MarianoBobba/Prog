/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author Usuario
 */
public class Producto {
    private int codigo;
    private String descripcion;
    private float precio;
    private Estado estado;
    private Categoria categoria;
    
    //Constructor
    public Producto(int codigo, String descripcion, float precio, Estado estado, Categoria categoria) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
        this.categoria = categoria;
    }
    
    //Metodos
    public void mostrar () {
        System.out.println("El codigo del producto es: "+ codigo +"Su descripcion: "+ descripcion + "Su precio: "+ precio +"Su estado: "+ estado +"Su categoria: "+ categoria);
    }
    
    public String toString () {
        return descripcion;
    }

    public int verCodigo() {
        return codigo;
    }

    public void asignarCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String verDescripcion() {
        return descripcion;
    }

    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float verPrecio() {
        return precio;
    }

    public void asignarPrecio(float precio) {
        this.precio = precio;
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }

    public Categoria verCategoria() {
        return categoria;
    }

    public void asignarCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
