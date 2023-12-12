
package pedidos.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import usuarios.modelos.Cliente;


public class Pedido implements Comparable<Pedido>{
    private Integer numero;
    private LocalDateTime fechaYHora;
    private Estado estado;
    private Cliente cliente;
    private List<ProductoDelPedido> unProductoDelPedido;

    public Pedido(int numero, LocalDateTime fechaYHora, List<ProductoDelPedido> lista, Cliente cliente) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.unProductoDelPedido = lista;
        this.cliente = cliente; 
        this.estado = Estado.CREADO;
    }

    @Override
    public String toString() {
        return "Pedido{" + "numero=" + numero + ", fechaYHora=" + fechaYHora + ", estado=" + estado + ", cliente=" + cliente + '}';
    }
    

    public Cliente verCliente() {
        return cliente;
    }

    public void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int verNumero() {
        return numero;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }

    public void asignarFecha(LocalDate fecha){
        this.fechaYHora = this.fechaYHora;
    }
    
    public LocalDate verFecha() {
        LocalDate fecha = this.fechaYHora.toLocalDate();
        return fecha;
    }
    
    public void asignarHora(LocalTime hora){
        this.fechaYHora = this.fechaYHora;
    }
    
    public LocalTime verHora() {
        LocalTime hora = this.fechaYHora.toLocalTime();
        return hora;
    }

    public List<ProductoDelPedido> verUnProductoDelPedido() {
        return unProductoDelPedido;
    }

    public void asignarUnProductoDelPedido(ArrayList<ProductoDelPedido> unProductoDelPedido) {
        this.unProductoDelPedido = unProductoDelPedido;
    }
    
   
    public void mostrar(){
    
        System.out.println("\nNumero: " + this.numero + "\nFecha: " + this.fechaYHora.toLocalDate() + "\t\t\t\tHora: " + this.fechaYHora.toLocalTime() + "\nCliente: " + this.cliente.verApellido() + ", " + this.cliente.verNombre() + "\nEstado: " + this.estado);
        System.out.println("        Producto            Cantidad\n");
        System.out.println("        ============================\n");
        
        
        for (ProductoDelPedido p : unProductoDelPedido){
            System.out.println("        " + p.toString() + "      " + p.cantidad + "\n");
        }

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.numero;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Pedido other = (Pedido) obj;
        return this.numero == other.numero;
    }

    @Override
    public int compareTo(Pedido p) {
        return (this.numero.compareTo(p.numero)*-1);
    }

  
}

