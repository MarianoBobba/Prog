package productos.modelos;

import interfaces.IGestorPedidos;
import interfaces.IGestorProductos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pedidos.modelos.GestorPedidos;


public class GestorProductos implements IGestorProductos {

    private final String NombreDelArchivo = "ArchivoProductos.txt";
    BufferedWriter bw = null;
    BufferedReader br = null;
    String linea;
    private List<Producto> productos = new ArrayList<>();
    
    private static GestorProductos gestor;
    

    private GestorProductos() {
        this.leer(NombreDelArchivo);
    }

    public static GestorProductos instanciar() {
        if (gestor == null) {
            gestor = new GestorProductos();
        }
        return gestor;
    }

    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {

        if (codigo <= 0) {
            return ERROR_CODIGO;
        }
        if (descripcion == null || descripcion.isEmpty()) {
            return ERROR_DESCRIPCION;
        }
        if (precio <= 0) {
            return ERROR_PRECIO;
        }
        if (categoria == null) {
            return ERROR_CATEGORIA;
        }
        if (estado == null) {
            return ERROR_ESTADO;
        } else {
            Producto unProducto = new Producto(codigo, descripcion, categoria, estado, precio);

            if (!productos.contains(unProducto)) {
                productos.add(unProducto);
                this.escribir();
                return EXITO;
            } else {
                return PRODUCTOS_DUPLICADOS;
            }

        }

    }

    @Override
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        Producto productoAuxilar = null;

        if (!productos.contains(productoAModificar)) {
            return PRODUCTO_INEXISTENTE;
        } else {

            if (productoAModificar == null) {
                /*cuando no esta asignada la referencia a un objeto*/
                return PRODUCTO_INEXISTENTE;
            }
            if (descripcion == null || descripcion.isEmpty()) {
                return ERROR_DESCRIPCION;
            }
            if (precio <= 0) {
                return ERROR_PRECIO;
            }
            if (categoria == null) {
                return ERROR_CATEGORIA;
            }
            if (estado == null) {
                return ERROR_ESTADO;
            }

            for (Producto p : productos) {
                if (p.equals(productoAModificar)) {
                    productoAuxilar = p;
                }
            }
            if (productoAuxilar == null) {
                return PRODUCTO_INEXISTENTE; 
            }

            productoAuxilar.asignarCategoria(categoria);
            productoAuxilar.asignarDescripcion(descripcion);
            productoAuxilar.asignarEstado(estado);
            productoAuxilar.asignarPrecio(precio);

            this.escribir();

            return EXITO;
        }
    }

    @Override
    public List<Producto> menu() {
        //Operador Lambda
        Collections.sort(this.productos, (p1, p2) -> {
            if (p1.verCategoria().compareTo(p2.verCategoria()) == 0) {
                return p1.verDescripcion().compareTo(p2.verDescripcion());
            } else {
                return p1.verCategoria().compareTo(p2.verCategoria());
            }
        });
        return productos;
    }

    @Override
    public List<Producto> buscarProductos(String descripcion) {
        List<Producto> productosBuscados = new ArrayList<>();

        if (descripcion != null) {

            for (Producto p : productos) {
                if ((p.verDescripcion().toLowerCase()).contains(descripcion.toLowerCase())) {
                    productosBuscados.add(p);
                    this.escribir();
                }
            }

        }

        Collections.sort(productosBuscados, (pb1, pb2) -> {
            if (pb1.verCategoria().compareTo(pb2.verCategoria()) == 0) {
                return pb1.verDescripcion().compareTo(pb2.verDescripcion());
            } else {
                return pb1.verCategoria().compareTo(pb2.verCategoria());
            }
        });

        return productosBuscados;
    }

    @Override
    public boolean existeEsteProducto(Producto producto) {

        if (producto == null) {
            return false;
        }

        return (productos.contains(producto));
    }

    @Override
    public List<Producto> verProductosPorCategoria(Categoria categoria) {

        List<Producto> productosBuscados = new ArrayList<>();

        for (Producto p : productos) {
            if (p.verCategoria().equals(categoria)) {
                productosBuscados.add(p);
            }
        }

        Collections.sort(productosBuscados);
        return productosBuscados;
    }

    @Override
    public Producto obtenerProducto(Integer codigo) {

        for (Producto p : productos) {
            if (p.verCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    @Override
    public String borrarProducto(Producto producto) {

        if (producto == null) {
            return PRODUCTO_INEXISTENTE;
        }

        IGestorPedidos gPedidos = GestorPedidos.instanciar();

        if (productos.contains(producto) && !gPedidos.hayPedidosConEsteProducto(producto)) {
            productos.remove(producto);
            this.escribir();
            return EXITO_BORRADO;

        }

        return PRODUCTO_INEXISTENTE;
    }

    private void escribir() {
        File f = new File(NombreDelArchivo);

        try {
            FileWriter fw = new FileWriter(f);
            bw = new BufferedWriter(fw);

            for (Producto p : this.productos) {
                linea = (p.verDescripcion() + "," + p.verCategoria() + "," + p.verCodigo() + "," + p.verPrecio() + "," + p.verEstado());
                bw.write(linea);
                bw.newLine();
            }
            bw.close();

        } catch (FileNotFoundException fnf) {
            
        }
        catch (IOException ioe) {
            
        }

    }

    private void leer(String NombreDelArchivo) {
        File f = new File(NombreDelArchivo);

        try {
            FileReader fr = new FileReader(f);
            br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {
                String[] vector = linea.split(",");
                String descripcion = vector[0];
                Categoria categoria = Categoria.valueOf(vector[1].toUpperCase()); // Convertir a enumeración
                int codigo = Integer.parseInt(vector[2]);
                float precio = Float.parseFloat(vector[3]);
                Estado estado = Estado.valueOf(vector[4].toUpperCase());    // Convertir a enumeración

                this.crearProducto(codigo, descripcion, precio, categoria, estado);
            }
            br.close();
            }

         catch (FileNotFoundException fnf) {
            
        } catch (IOException ioe) {
            
        }
    }
}
