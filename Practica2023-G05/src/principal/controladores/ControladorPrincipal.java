/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import java.time.LocalDateTime;
import java.util.ArrayList;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;
import productos.modelos.Estado;
import productos.modelos.Categoria;
/**
 *
 * @author Usuario
 */
public class ControladorPrincipal {
      public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Encargado> encargados = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        
        Cliente unCliente1 = new Cliente("NombreCliente1", "ApellidoCliente1", "cliente@bar.com", "claveCliente1");        
        Cliente unCliente2 = new Cliente("NombreCliente2", "ApellidoCliente2", "cliente2@bar.com", "claveCliente2");       
        Cliente unCliente3 = new Cliente("NombreCliente3", "ApellidoCliente3", "cliente3@bar.com", "claveCliente3");
        
        clientes.add(unCliente1);
        clientes.add(unCliente2);
        clientes.add(unCliente3);
        
        System.out.println("Clientes");
        System.out.println("========");
        for(Cliente c : clientes) {
            c.mostrar();
            System.out.println();
        }
        System.out.println();        
        
        Empleado unEmpleado1 = new Empleado("NombreEmpleado1", "ApellidoEmpleado1", "empleado1@bar.com", "ClaveEmpleado1");        
        Empleado unEmpleado2 = new Empleado("NombreEmpleado2", "ApellidoEmpleado2", "empleado2@bar.com", "ClaveEmpleado2");        
        Empleado unEmpleado3 = new Empleado("NombreEmpleado3", "ApellidoEmpleado3", "empleado3@bar.com", "ClaveEmpleado3");
                
        empleados.add(unEmpleado1);
        empleados.add(unEmpleado2);
        empleados.add(unEmpleado3);
        
        System.out.println("Empleados");
        System.out.println("=========");
        for(Empleado e : empleados) {
            e.mostrar();
            System.out.println();
        }
        System.out.println();
        
        Encargado unEncargado1 = new Encargado("NombreEncargado1", "ApellidoEncargado1", "encargado1@bar.com", "ClaveEncargado1");
        Encargado unEncargado2 = new Encargado("NombreEncargado2", "ApellidoEncargado2", "encargado2@bar.com", "ClaveEncargado2");
        Encargado unEncargado3 = new Encargado("NombreEncargado3", "ApellidoEncargado3", "encargado3@bar.com", "ClaveEncargado3");

        encargados.add(unEncargado1);
        encargados.add(unEncargado2);
        encargados.add(unEncargado3);
        
        System.out.println("Encargados");
        System.out.println("==========");
        for(Encargado e : encargados) {
            e.mostrar();
            System.out.println();
        }
        System.out.println();
        
        Producto unProducto1 = new Producto(1, "Producto1", 1.0f, Estado.DISPONIBLE, Categoria.ENTRADA);        
        Producto unProducto2 = new Producto(2, "Producto2", 2.0f, Estado.DISPONIBLE, Categoria.PLATO_PRINCIPAL);
        Producto unProducto3 = new Producto(3, "Producto3", 3.0f, Estado.NO_DISPONIBLE, Categoria.POSTRE);
        
        productos.add(unProducto1);
        productos.add(unProducto2);
        productos.add(unProducto3);
        
        System.out.println("Productos");
        System.out.println("=========");
        for(Producto p : productos) {
            p.mostrar();
            System.out.println();
        }
        System.out.println();
        
        
        unCliente1.asignarCorreo("cliente10@bar.com");
        System.out.println("Clientes");
        System.out.println("========");
        for(Cliente c : clientes) {
            c.mostrar();
            System.out.println();
        }
        System.out.println();
        
        ArrayList<ProductoDelPedido> pdp1 = new ArrayList<>();
        pdp1.add(new ProductoDelPedido(1,unProducto1));
        pdp1.add(new ProductoDelPedido(2, unProducto2));
        Pedido unPedido1 = new Pedido(LocalDateTime.now(), 1, unCliente1, pdp1);        
        
        ArrayList<ProductoDelPedido> pdp2 = new ArrayList<>();
        pdp2.add(new ProductoDelPedido(10,unProducto1));
        pdp2.add(new ProductoDelPedido(20, unProducto2));
        Pedido unPedido2 = new Pedido(LocalDateTime.now(), 2, unCliente2, pdp2);        
        
        ArrayList<ProductoDelPedido> pdp3 = new ArrayList<>();
        pdp3.add(new ProductoDelPedido(100, unProducto1));
        pdp3.add(new ProductoDelPedido(200, unProducto2));
        Pedido unPedido3 = new Pedido(LocalDateTime.now(), 3, unCliente3, pdp3);        
        
        pedidos.add(unPedido1);
        pedidos.add(unPedido2);
        pedidos.add(unPedido3);
        
        System.out.println("Pedidos");
        System.out.println("=======");
        for(Pedido p : pedidos) {
            p.mostrar();
            System.out.println();
        }
        System.out.println();
    }
    
}
