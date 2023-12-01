/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Usuario
 */
public class ModeloComboPerfil extends DefaultComboBoxModel {
/**
 *
 * @author root
 */
    
    /**
     * Constructor
    */
    public ModeloComboPerfil() { 
        for (Perfil perfil : Perfil.values()) {
            this.addElement(perfil); 
        }
    }
    
    /**
     * Devuelve el perfil seleccionado
     * @return Perfil  - perfil seleccionado
    */
    public Perfil obtenerCategoria() { 
        return (Perfil)this.getSelectedItem();
    }
    
    /**
     * Selecciona el Perfil especificado
     * @param perfil perfil
    */
    public void seleccionarPerfil(Perfil perfil) {
        this.setSelectedItem(perfil);
    }
}

