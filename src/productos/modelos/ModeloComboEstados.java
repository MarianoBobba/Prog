/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos.modelos;

import javax.swing.DefaultComboBoxModel;


public class ModeloComboEstados extends DefaultComboBoxModel {

    public ModeloComboEstados() { 
        for (Estado estado : Estado.values()) {
            this.addElement(estado); 
        }
    }
    

    public Estado obtenerEstado() { 
        return (Estado)this.getSelectedItem();
    }
    

    public void seleccionarEstado(Estado estado) {
        this.setSelectedItem(estado);
    }
}
