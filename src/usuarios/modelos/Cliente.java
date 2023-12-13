/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;


import pedidos.modelos.Pedido;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Cliente extends Usuario{
    
     //Atributos
    private List<Pedido> pedidos = new ArrayList<>() ;
    //Constructor
    public Cliente(String correo, String clave, String apellido, String nombre, String claveRepetida, Perfil perfil) {    
        super(correo, clave, apellido, nombre, claveRepetida, perfil);
    }

    //Metodos
    public List<Pedido> verPedidos() {
        return pedidos;
    }

    public void asignarPedidos(List<Pedido> pedidos) {
        this.pedidos = (ArrayList<Pedido>) pedidos;
    }
    
    
     public void agregarPedido(Pedido pedido) {
      
        if (!pedidos.contains(pedido)) {
            pedidos.add(pedido);
            System.out.println("Pedido agregado correctamente.");
        } else {
            System.out.println("El pedido ya fue añadido anteriormente.");
        }
    }
    
      public void cancelarPedido(Pedido pedido) {
        if (pedidos.isEmpty()) {
            System.out.println("La lista de pedidos está vacía.");
            return;
        }

        if (pedidos.contains(pedido)) {
            pedidos.remove(pedido);
            System.out.println("Pedido cancelado y eliminado correctamente.");
        } else {
            System.out.println("El pedido no se encontraba en la lista.");
        }
    }
    }
    
