
package principal.controladores;

import interfaces.IControladorPrincipal;
import interfaces.IControladorUsuarios;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;
import usuarios.controladores.ControladorUsuarios;


public class ControladorVentanaPrincipal implements IControladorPrincipal {

    private VentanaPrincipal ventana;
    private static ControladorVentanaPrincipal controlador;
    
    //Funcion main
    public static void main(String[] args) {
        IControladorPrincipal cp = ControladorVentanaPrincipal.instanciar();
        VentanaPrincipal ventana  = new VentanaPrincipal(cp);
    }

    private ControladorVentanaPrincipal() {
        this.ventana = new VentanaPrincipal(this);
        this.ventana.setTitle(TITULO);   
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }

    public static ControladorVentanaPrincipal instanciar() {
        if (controlador == null) {
            controlador = new ControladorVentanaPrincipal();
        }
        return controlador;
        //Crea una unica instancia de esta clase
    }

    @Override
    public void btnUsuariosClic(ActionEvent evt) {      
        IControladorUsuarios controladorUsuarios = new ControladorUsuarios(ventana);
        //Crea una instancia de la Ventana Usuarios
    }

    @Override
    public void btnProductosClic(ActionEvent evt) {  
        //No se implementa para este parcial
    }

    @Override
    public void btnPedidosClic(ActionEvent evt) {   
        //No se implementa para este parcial
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {

        int respuesta = JOptionPane.showOptionDialog(null, "¿Desea salir?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, null);
        //Se usa OptionPane para cerrar la ventana en caso de confirmacion 
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(respuesta);
        }
    }

}
