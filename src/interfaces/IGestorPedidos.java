/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author estudiante
 */
public interface IGestorPedidos {
    
    public static final String EXITO = "Se creo/modifico el pedido con exito.";
    public static final String CLIENTE = "Cliente invalido. No se creo/modifico el pedido.";
    public static final String PDP = "Producto del pedido invalido. No se creo/modifico el pedido.";
    public static final String FECHAYHORA = "Fecha u hora invalidas. No se creo/modifico el pedido.";
    public static final String NUMERO = "Numero invalido. No se creo/modifico el pedido.";
    public static final String REPETIDO = "Pedido ya existente. No se creo/modifico el pedido.";
    public static final String INEXISTENTE = "Pedido no existente. No se creo/modifico el pedido.";
    
    public String crearPedido(int numero, LocalDateTime fechaYHora, List<ProductoDelPedido> pdp, Cliente cliente);
    public String cambiarEstado (Pedido pedidoAModificar);
    public List<Pedido> verPedidos();
    public boolean hayPedidosConEsteCliente(Cliente cliente);
    public boolean hayPedidosConEsteProducto(Producto producto);
    public String cancelarPedido(Pedido pedido);
    public boolean existeEstePedido(Pedido pedido);
    public Pedido obtenerPedido(int numero);
    
}
