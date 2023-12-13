/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package pedidos.modelos;


public enum Estado {
    
    CREADO("CREADO"),
    SOLICITADO("SOLICITADO"),
    PROCESANDO ("PROCESANDO"),
    ENTREGADO ("ENTREGADO");
    
    private String valor;

    private Estado(String valor) {
        this.valor = valor;
    }
    
    public String toString (){
        return this.valor;
    }
}
