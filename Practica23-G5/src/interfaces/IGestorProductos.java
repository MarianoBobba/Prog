/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.ArrayList;
import java.util.List;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.Producto;

/**
 *
 * @author estudiante
 */
public interface IGestorProductos {
    
    public static final String EXITO = "Se creo/modifico el producto con exito.";
    public static final String CODIGO = "Codigo invalido. No se creo/modifico el producto.";
    public static final String DESCRIPCION = "Descripcion invalida. No se creo/modifico el producto.";
    public static final String PRECIO = "Precio invalido. No se creo/modifico el producto.";
    public static final String CATEGORIA = "Categoria invalida. No se creo/modifico el producto.";
    public static final String ESTADO = "Estado invalido. No se creo/modifico el producto.";
    public static final String REPETIDO = "Producto ya existente. No se creo/modifico el producto.";
    public static final String INEXISTENTE = "Producto no existente. No se creo/modifico el producto.";
    
    public String crearProducto(int codigo, String descripcion, float precio,Categoria categoria, Estado estado);
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado);
    public List<Producto> menu();
    public List<Producto> buscarProductos(String descripcion);
    public boolean existeEsteProducto(Producto producto);
    public List<Producto> verProductosPorCategoria(Categoria categoria);
    public Producto obtenerProducto(int codigo);
    public String borrarProducto(Producto producto);
    
}
