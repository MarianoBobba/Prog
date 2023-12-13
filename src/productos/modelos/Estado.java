/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author Usuario
 */
public enum Estado {
    DISPONIBLE("DISPONIBLE"),
    NO_DISPONIBLE("NO DISPONIBLE");
    
    private String valor;

    private Estado(String valor) {
        this.valor = valor;
    }
    
    public String toString (){
        return this.valor;
    }
}
