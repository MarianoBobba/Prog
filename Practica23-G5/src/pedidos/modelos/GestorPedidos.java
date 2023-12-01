/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import interfaces.IGestorPedidos;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;


/**
 *
 * @author estudiante
 */
public class GestorPedidos implements IGestorPedidos{
    
    private static GestorPedidos gestor;
    private ArrayList<Pedido> pedidos = new ArrayList<>();
//    private static final String EXITO = "Se creo/modifico el pedido con exito.";
//    private static final String CLIENTE = "Cliente invalido. No se creo/modifico el pedido.";
//    private static final String PDP = "Producto del pedido invalido. No se creo/modifico el pedido.";
//    private static final String FECHAYHORA = "Fecha u hora invalidas. No se creo/modifico el pedido.";
//    private static final String NUMERO = "Numero invalido. No se creo/modifico el pedido.";
//    private static final String REPETIDO = "Pedido ya existente. No se creo/modifico el pedido.";
//    private static final String INEXISTENTE = "Pedido no existente. No se creo/modifico el pedido.";
    
    private GestorPedidos() {
        
    }
    
    public static GestorPedidos crear() {
        if (gestor == null)
        gestor = new GestorPedidos();
        return gestor;
    }
    
    public static IGestorPedidos instanciar() {
        return new GestorPedidos();
    }
    
    
    public String crearPedido(int numero, LocalDateTime fechaYHora, List<ProductoDelPedido> pdp, Cliente cliente) {
        
        Pedido P1 = new Pedido (numero, fechaYHora, pdp, cliente);
        
        if (fechaYHora == null)
            return FECHAYHORA;
        else if (numero <= 0)
            return NUMERO;
        else if (pdp == null || pdp.isEmpty())
            return PDP;
        else if (cliente == null)
            return CLIENTE;
        else if (!pedidos.contains(P1)){
            pedidos.add(P1);
            cliente.agregarPedido(P1);
            return EXITO;
        }
        else 
            return REPETIDO;
    }
    
    public String cambiarEstado (Pedido pedidoAModificar) {
        
        if (pedidoAModificar == null)
            return INEXISTENTE;
        else if (pedidoAModificar.verEstado() == Estado.CREADO){
            pedidoAModificar.asignarEstado(Estado.PROCESANDO);
        }
        else if (pedidoAModificar.verEstado() == Estado.PROCESANDO){
            pedidoAModificar.asignarEstado(Estado.ENTREGADO);
        }
        else if (pedidoAModificar.verEstado() == Estado.ENTREGADO){
            pedidoAModificar.asignarEstado(Estado.ENTREGADO);
        }
            return null;
    }
    
    public List<Pedido> verPedidos() {
        
        Collections.sort(pedidos, Comparator.comparing(Pedido::verFechaYHora));
        return pedidos;
    }
    
    public boolean hayPedidosConEsteCliente(Cliente cliente) {
        int cont = 0;
        for (Pedido pedido : pedidos) {
            if (pedido.verCliente() == (cliente)) {
                cont++;
            }
        }
        return cont != 0;
    }
    
    public boolean hayPedidosConEsteProducto(Producto producto) {
        int cont = 0;
        for (Pedido pedido : pedidos) {
            if (pedido.verPdp().contains(producto))
                cont++;
        }
        return cont != 0;
    }
    
    public boolean existeEstePedido(Pedido pedido) {
        return pedidos.contains(pedido);
    }
    
    public Pedido obtenerPedido(int numero) {
        for (Pedido pedido : pedidos) {
            if (pedido.verNumero() == numero) {
                return pedido;
            } else {
            }
        }
        return null;
    }

     public String cancelarPedido(Pedido pedido) {
        if(pedido == null){
            return INEXISTENTE;
        }
        
        if (pedidos.contains(pedido) && pedido.verEstado() == Estado.CREADO ){
                pedido.verCliente().cancelarPedido(pedido);
                return EXITO;
        }
        return INEXISTENTE;
    }

    
}

