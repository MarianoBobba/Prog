/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos.modelos;

import javax.swing.DefaultComboBoxModel;


public class ModeloComboCategorias extends DefaultComboBoxModel {
    
    /**
     * Constructor
    */
    public ModeloComboCategorias() { 
        for (Categoria categoria : Categoria.values()) {
            this.addElement(categoria); 
        }
    }
    
    public Categoria obtenerCategoria() { 
        return (Categoria)this.getSelectedItem();
    }
    

    public void seleccionarCategoria(Categoria categoria) {
        this.setSelectedItem(categoria);
    }
}
