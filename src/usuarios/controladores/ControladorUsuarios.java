package usuarios.controladores;

import usuarios.controladores.ControladorAMUsuario;
import interfaces.IControladorAMUsuario;
import interfaces.IControladorUsuarios;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import principal.vistas.VentanaPrincipal;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.ModeloTablaUsuarios;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaUsuarios;

public class ControladorUsuarios implements IControladorUsuarios {

    private VentanaPrincipal ventana;
    private VentanaUsuarios ventanaUsuario = new VentanaUsuarios(ventana, this);
    private final IGestorUsuarios gu = GestorUsuarios.instanciar();

    public ControladorUsuarios(VentanaPrincipal ventana) {
        this.ventanaUsuario.setModal(true);
        this.ventanaUsuario.setTitle(TITULO);
        this.ventanaUsuario.setLocationRelativeTo(null);
        this.ventanaUsuario.getTablaUsuarios().setModel(new ModeloTablaUsuarios());
        this.ventanaUsuario.getTablaUsuarios().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.ventanaUsuario.getTablaUsuarios().getTableHeader().setReorderingAllowed(false);
        this.ventanaUsuario.getTablaUsuarios().getTableHeader().setResizingAllowed(false);
        this.ventanaUsuario.setVisible(true);
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        //Llama a la ventana AMUsuario para agregar un usuario nuevo
        IControladorAMUsuario controladorAMUsuario = new ControladorAMUsuario(this.ventanaUsuario);
        this.ventanaUsuario.getTablaUsuarios().setModel(new ModeloTablaUsuarios());
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        //Llama a la ventana AMUsuario para modificar el usuario de la fila seleccionada
        if (this.ventanaUsuario.getTablaUsuarios().getSelectedRow() != -1) {
            Usuario usuario = gu.verUsuarios().get(this.ventanaUsuario.getTablaUsuarios().getSelectedRow());
            IControladorAMUsuario controladorAMUsuario = new ControladorAMUsuario(this.ventanaUsuario, usuario);
        }
    }
    
    @Override
    public void btnBorrarClic(ActionEvent evt) {
        //Borra el usuario de la fila seleccionada
        int filaSeleccionada = this.ventanaUsuario.getTablaUsuarios().getSelectedRow();
        if (filaSeleccionada != -1) {
            Usuario usuario = ( (ModeloTablaUsuarios) this.ventanaUsuario.getTablaUsuarios().getModel()).verUsuarioSeleccionado(filaSeleccionada);
            int respuesta = JOptionPane.showOptionDialog(null, CONFIRMACION, null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, null);
            if (respuesta == JOptionPane.YES_OPTION) {
                gu.borrarUsuario(usuario);
                System.out.println(gu.borrarUsuario(usuario));
            }
            this.ventanaUsuario.getTablaUsuarios().setModel(new ModeloTablaUsuarios());
        }
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        //Refresca la tabla cada vez que la ventana gana el foco
         this.ventanaUsuario.getTablaUsuarios().setModel(new ModeloTablaUsuarios());
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventanaUsuario.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        //Actualiza la tabla segun la busqueda
        String apellido = this.ventanaUsuario.getTxtApellido().getText();
        this.ventanaUsuario.getTablaUsuarios().setModel(new ModeloTablaUsuarios(apellido));

    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {

    }
    
}
