/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import usuarios.modelos.Cliente;


/**
 *
 * @author Usuario
 */
public class Pedido {
    private LocalDateTime fechaYHora;
    private int numero;
    private Cliente cliente;
    private Estado estado;
    private List<ProductoDelPedido> pdp;

    public Pedido(int numero, LocalDateTime fechaYHora, List<ProductoDelPedido> pdp, Cliente cliente) {
        this.fechaYHora = fechaYHora;
        this.numero = numero;
        this.cliente = cliente;
        this.estado = Estado.CREADO;
        this.pdp = pdp;
    }
      public void mostrar() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter h = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("Nro:" + numero);
        System.out.println("Fecha:" + fechaYHora.format(f) + "\t" + "Hora: " + fechaYHora.format(h));
        System.out.println("Cliente:" + cliente.verApellido() + "," + cliente.verNombre());
        System.out.println("Estado:" + estado);
        for (ProductoDelPedido p : pdp) {
            p.mostrar();
            System.out.println();
        }
        System.out.println();
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(numero, pedido.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    public LocalDateTime verFechaYHora() {
        return fechaYHora;
    }

    public void asignarFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public int verNumero() {
        return numero;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public Cliente verCliente() {
        return cliente;
    }

    public void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }

    public List<ProductoDelPedido> verPdp() {
        return pdp;
    }

    public void asignarPdp(List<ProductoDelPedido> pdp) {
        this.pdp = pdp;
    }
}
