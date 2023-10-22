/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author Usuario
 */
public enum Categoria {
    ENTRADA ("ENTRADA"),
    PLATO_PRINCIPAL ("PLATO PRINCIPAL"),
    POSTRE ("POSTRE");
    
    private String valor;

    private Categoria(String valor) {
        this.valor = valor;
    }
    
    public String toString (){
        return this.valor;
    }
}
