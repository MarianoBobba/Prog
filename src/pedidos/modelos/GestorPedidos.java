
package pedidos.modelos;

import interfaces.IGestorPedidos;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static pedidos.modelos.Estado.ENTREGADO;
import static pedidos.modelos.Estado.PROCESANDO;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;


public class GestorPedidos implements IGestorPedidos{

    private List<Pedido> pedidos = new ArrayList<>();
    private static int numeroDelPedido = 1;

    private static GestorPedidos gestor;

    private GestorPedidos() {
    }

    public static GestorPedidos instanciar() {
        if (gestor == null) {
            gestor = new GestorPedidos();
        }
        return gestor;
    }

    @Override
    public String crearPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente) {

        if (fecha == null) {
            return ERROR_FECHA;
        }
        if (hora == null) {
            return ERROR_HORA;
        }
        if (cliente == null) {
            return ERROR_CLIENTE;
        }
        if (productosDelPedido == null) {
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        } else {
            LocalDateTime fechaYHora = LocalDateTime.of(fecha, hora);
            Pedido unPedido = new Pedido(numeroDelPedido, fechaYHora, productosDelPedido, cliente);
            numeroDelPedido++;
                if (!pedidos.contains(unPedido)) {
                    pedidos.add(unPedido);
                } else {
                    return PEDIDOS_DUPLICADOS;
                }
            cliente.agregarPedido(unPedido);
            return EXITO;
        }
    }

    @Override
    public String cambiarEstado(Pedido pedidoAModificar) {
        if(pedidoAModificar == null){
            return PEDIDO_INEXISTENTE;
        }
        if (pedidoAModificar.verFecha() == null) {
            return ERROR_FECHA;
        }
        if (pedidoAModificar.verHora() == null) {
            return ERROR_HORA;
        }
        if (pedidoAModificar.verCliente() == null) {
            return ERROR_CLIENTE;
        }
        if (pedidoAModificar.verUnProductoDelPedido() == null) {
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        } else {
            switch (pedidoAModificar.verEstado()) {
                case CREADO:
                    pedidoAModificar.asignarEstado(PROCESANDO);
                    break;
                case PROCESANDO:
                    pedidoAModificar.asignarEstado(ENTREGADO);
                    break;
            }
            return EXITO;
        }
    }

    @Override
    public List<Pedido> verPedidos() {
        Collections.sort(pedidos);
        return pedidos;
    }

    @Override
    public boolean hayPedidosConEsteCliente(Cliente cliente) {
        if (cliente.verPedidos().isEmpty() || cliente.verPedidos() == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean hayPedidosConEsteProducto(Producto producto) {

        if(producto == null)
            return false;

        ProductoDelPedido prod = new ProductoDelPedido(producto, 0);

        for (Pedido p : pedidos) {
            if ((p.verUnProductoDelPedido()).contains(prod)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean existeEstePedido(Pedido pedido) {
        
        if(pedido == null)
            return false;
        
        for (Pedido p : pedidos) {
            if (p.verNumero() == pedido.verNumero()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Pedido obtenerPedido(Integer numero) {
   
        for (Pedido p : pedidos) {
            if (p.verNumero() == numero) {
                return p;
            }
        }
        return null;

    }
    
    
    
    @Override
    public String cancelarPedido(Pedido pedido){
    
        if(pedido == null)
            return PEDIDO_INEXISTENTE; 
        
        for(Pedido p : pedidos){
            if(p.equals(pedido) && pedido.verEstado() == Estado.CREADO){
                pedido.verCliente().cancelarPedido(pedido);
                return EXITO;
            }
        }
        
        return ERROR_CANCELAR; 
    
    
    }
    
    
    
    

}
