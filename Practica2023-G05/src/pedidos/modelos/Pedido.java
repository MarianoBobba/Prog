/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private ArrayList<ProductoDelPedido> pdp;

    public Pedido(LocalDateTime fechaYHora, int numero, Cliente cliente, ArrayList<ProductoDelPedido> pdp) {
        this.fechaYHora = fechaYHora;
        this.numero = numero;
        this.cliente = cliente;
        this.pdp = pdp;
    }

    public void mostrar() {
        System.out.println("Nro:" + numero);
        System.out.println(fechaYHora);
        System.out.println("Cliente:" + cliente.verApellido() + cliente.verNombre());

        for (ProductoDelPedido p : pdp) {
            p.mostrar();
            System.out.println();
        }
        System.out.println();
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

    public ArrayList<ProductoDelPedido> verPdp() {
        return pdp;
    }

    public void asignarPdp(ArrayList<ProductoDelPedido> pdp) {
        this.pdp = pdp;
    }
}
