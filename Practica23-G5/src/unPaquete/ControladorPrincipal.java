/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unPaquete;
import java.util.ArrayList;
/**
 *
 * @author Usuario
 */
public class ControladorPrincipal {
    public static void main(String[] args) {
        
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<Encargado> listaEncargados = new ArrayList<>();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        
        Cliente c1 = new Cliente ();
        Cliente c2 = new Cliente ();
        Cliente c3 = new Cliente ();
        Empleado e1 = new Empleado ();
        Empleado e2 = new Empleado ();
        Empleado e3 = new Empleado ();
        Encargado g1 = new Encargado ();
        Encargado g2 = new Encargado ();
        Encargado g3 = new Encargado ();
        Producto p1 = new Producto ();
        Producto p2 = new Producto ();
        Producto p3 = new Producto ();
        
        c1.nombre = "Mariano";
        c1.apellido = "Bobba";
        c1.correo = "mfbobba@gmail.com";
        c1.clave = "1234";
        
        c2.nombre = "Octavio";
        c2.apellido = "Bobba";
        c2.correo = "otibobba@gmail.com";
        c2.clave = "1234";
        
        c3.nombre = "Luis";
        c3.apellido = "Bobba";
        c3.correo = "luisfbobba@gmail.com";
        c3.clave = "1234";
        
        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);
        
        e1.nombre = "Marini";
        e1.apellido = "Belicari";
        e1.correo = "marinibelicari@gmail.com";
        e1.clave = "1234";
        
        e2.nombre = "Daniel";
        e2.apellido = "Belicari";
        e2.correo = "danibelicari@gmail.com";
        e2.clave = "1234";
        
        e3.nombre = "Nieves";
        e3.apellido = "Castillo";
        e3.correo = "gurgoc@gmail.com";
        e3.clave = "1234";
        
        listaEmpleados.add(e1);
        listaEmpleados.add(e2);
        listaEmpleados.add(e3);
        
        g1.nombre = "Norma";
        g1.apellido = "Fierro";
        g1.correo = "normafierro@gmail.com";
        g1.clave = "1234";
        
        g2.nombre = "Felix";
        g2.apellido = "Bobba";
        g2.correo = "felixdbobba@gmail.com";
        g2.clave = "1234";
        
        g3.nombre = "Mora";
        g3.apellido = "Bobba";
        g3.correo = "pichibobba@gmail.com";
        g3.clave = "1234";
        
        listaEncargados.add(g1);
        listaEncargados.add(g2);
        listaEncargados.add(g3);
        
        p1.nombre = "Pedido 1";
        p1.descripcion = "Tripas rellenas";
        p1.precio = 1500f;
        p1.estado = "Disponible";
        p1.categoria = "Plato principal";
        
        p2.nombre = "Pedido 2";
        p2.descripcion = "Humita en chala";
        p2.precio = 1000f;
        p2.estado = "No Disponible";
        p2.categoria = "Entrada";
        
        p3.nombre = "Pedido 3";
        p3.descripcion = "Tiramisu";
        p3.precio = 850f;
        p3.estado = "Disponible";
        p3.categoria = "Postre";
        
        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        
            for(Cliente c : listaClientes) {
                c.mostrar();
        }
            for(Empleado e : listaEmpleados) {
                e.mostrar();
        }
            for(Encargado g : listaEncargados) {
                g.mostrar();
        }
            for(Producto p : listaProductos) {
                p.mostrar();
        }
         
        c1.clave = "JAVA";
        e1.clave = "Programacion orientada a objetos";
        p3.estado = "No disponible";
        
            for(Cliente c : listaClientes) {
                c.mostrar();
        }
            for(Empleado e : listaEmpleados) {
                e.mostrar();
        }
            for(Encargado g : listaEncargados) {
                g.mostrar();
        }
            for(Producto p : listaProductos) {
                p.mostrar();
        }
        
    }
}
