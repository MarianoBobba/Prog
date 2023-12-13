/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import java.util.Objects;

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
    public Producto(int codigo, String descripcion, Categoria categoria, Estado estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
        this.categoria = categoria;
    }
    
    //Metodos
    public void mostrar () {
        System.out.println("Codigo: " + codigo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Precio: " + precio);
        System.out.println("Categoria: "+ categoria + "\t" + "Estado: " + estado);
        //System.out.println("El codigo del producto es: "+ codigo +"Su descripcion: "+ descripcion + "Su precio: "+ precio +"Su estado: "+ estado +"Su categoria: "+ categoria);
    }
    
    public String toCSV() {
        return codigo + "," + descripcion + "," + categoria + "," + estado + "," + precio;
    }
     
    public static Producto convertirDesdeCSV(String csv) {
        String[] datos = csv.split(",");
        if (datos.length != 5) {
            return null;
        }
        return null;
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(codigo, producto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
