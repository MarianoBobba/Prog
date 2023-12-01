/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
public enum Perfil {
    CLIENTE ("CLIENTE"),
    ENCARGADO ("ENCARGADO"),
    EMPLEADO ("EMPLEADO");
    
    private String valor;

    private Perfil (String valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString (){
        return this.valor;
    }
}
