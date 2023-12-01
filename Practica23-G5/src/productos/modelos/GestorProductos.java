/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;
import interfaces.IGestorProductos;
import productos.modelos.Producto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author Usuario
 */
public class GestorProductos implements IGestorProductos {
    
    private static GestorProductos gestor;

    public static IGestorProductos instanciar() {
        return new GestorProductos();
    }
    private ArrayList<Producto> productos = new ArrayList<>(); 
//    private static final String EXITO = "Se creo/modifico el producto con exito.";
//    private static final String CODIGO = "Codigo invalido. No se creo/modifico el producto.";
//    private static final String DESCRIPCION = "Descripcion invalida. No se creo/modifico el producto.";
//    private static final String PRECIO = "Precio invalido. No se creo/modifico el producto.";
//    private static final String CATEGORIA = "Categoria invalida. No se creo/modifico el producto.";
//    private static final String ESTADO = "Estado invalido. No se creo/modifico el producto.";
//    private static final String REPETIDO = "Producto ya existente. No se creo/modifico el producto.";
//    private static final String INEXISTENTE = "Producto no existente. No se creo/modifico el producto.";
        
    private GestorProductos() {
        
    }
    
    public static GestorProductos crear() {
        if (gestor == null)
        gestor = new GestorProductos();
        return gestor;
    }
    
    public String crearProducto(int codigo, String descripcion, float precio,Categoria categoria, Estado estado) {
        
        Producto P1 = new Producto (codigo, descripcion, categoria, estado, precio);
        
        if (codigo <= 0)
            return CODIGO;
        if (descripcion == null || descripcion.isEmpty ())
            return DESCRIPCION;
        else if (precio <= 0)
            return PRECIO;
        else if (categoria == null)
            return CATEGORIA;
        else if (estado == null)
            return ESTADO;
        else if (!productos.contains(P1)){
            productos.add(P1);
            return EXITO;
        }
        else 
            return REPETIDO;
    }
    
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        
        if (productoAModificar == null)
            return INEXISTENTE;
        else if (codigo <= 0)
            return CODIGO;
        else if (descripcion == null || descripcion.isEmpty ())
            return DESCRIPCION;
        else if (precio <= 0)
            return PRECIO;
        else if (categoria == null)
            return CATEGORIA;
        else if (estado == null)
            return ESTADO;
        else {
        productoAModificar.asignarCodigo (codigo);
        productoAModificar.asignarDescripcion (descripcion);
        productoAModificar.asignarPrecio (precio);
        productoAModificar.asignarCategoria (categoria);
        productoAModificar.asignarEstado (estado);
        return EXITO;
        }
      }  
        public List<Producto> menu() {
        Collections.sort(productos, Comparator.comparing(Producto::verCategoria).thenComparing(Producto::verDescripcion));
        return productos;
    }

    public List<Producto> buscarProductos(String descripcion) {
        ArrayList<Producto> productosEncontrados = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.verDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                productosEncontrados.add(producto);
            }
        }
        Collections.sort(productosEncontrados, Comparator.comparing(Producto::verCategoria).thenComparing(Producto::verDescripcion));
        return productosEncontrados;
    }
    
    public boolean existeEsteProducto(Producto producto) {
        return productos.contains(producto);
    }
    
    public List<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> productosPorCategoria = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.verCategoria() == categoria) {
                productosPorCategoria.add(producto);
            }
        }
        Collections.sort(productosPorCategoria, Comparator.comparing(Producto::verDescripcion));
        return productosPorCategoria;
    }
    
    public Producto obtenerProducto(int codigo) {
        for (Producto producto : productos) {
            if (producto.verCodigo() == codigo) {
                return producto;
            } else {
            }
        }
        return null;
    }

    public String borrarProducto(Producto producto){
        GestorPedidos gP = GestorPedidos.crear();
        if(producto == null){
            return INEXISTENTE;
        }
        if(productos.contains(producto)){
                if(gP.hayPedidosConEsteProducto(producto)) {
                    return "\n\nNo se puede borrar este producto porque hay pedidos con el mismo";
                    
                } else {
                    productos.remove(producto);
                    return EXITO;
                }        
        }
        return INEXISTENTE;
    }
    
}