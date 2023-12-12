
package usuarios.modelos;

import javax.swing.DefaultComboBoxModel;

public class ModeloComboPerfiles extends DefaultComboBoxModel{
   
    public ModeloComboPerfiles() { 
        for (Perfil perfil : Perfil.values()) {
            this.addElement(perfil); 
        }
    }
    
    /**
     * Devuelve el perfil seleccionado
    */
    public Perfil obtenerPerfil() { 
        return (Perfil)this.getSelectedItem();
    }
    
    /**
     * Selecciona el perfil seleccionado
     * @param categoria categoría
    */
    public void seleccionarPerfil(Perfil perfil) {
        this.setSelectedItem(perfil);
    }
}
