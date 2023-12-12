package usuarios.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.ModeloTablaUsuarios;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaAMUsuario;
import usuarios.vistas.VentanaUsuarios;

public class ControladorAMUsuario implements IControladorAMUsuario {

    IGestorUsuarios gu = GestorUsuarios.instanciar();
    ModeloTablaUsuarios mtu = new ModeloTablaUsuarios();
    private VentanaAMUsuario ventana;
    private Usuario UsuarioAModificar; //Es el usuario que se manda como parametro en caso de que se presione el boton modificar
    private int indicador; //Indica si se llama la ventana para modificar o para agregar un usuario
    

    private static ControladorAMUsuario controlador;

    //Llamada para agregar un usuario nuevo
    public ControladorAMUsuario(VentanaUsuarios ventanaPadre) {
        this.ventana = new VentanaAMUsuario(ventanaPadre, this);
        this.ventana.setTitle(TITULO_NUEVO);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setModal(true);
        this.ventana.setVisible(true);
        this.indicador = 0;
    }
    
    //Llamada para modificar un usuario
    public ControladorAMUsuario(VentanaUsuarios ventanaPadre, Usuario usuario) {
        this.UsuarioAModificar = usuario;
        this.ventana = new VentanaAMUsuario(ventanaPadre, this);
        this.ventana.setTitle(TITULO_MODIFICAR);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setModal(true);
        this.indicador = 1;
        this.ventana.getTxtApellido().setText(usuario.verApellido());
        this.ventana.getTxtNombre().setText(usuario.verNombre());
        this.ventana.getClave().setText(usuario.verClave());
        this.ventana.getClaveRepetida().setText(usuario.verClave());
        this.ventana.getComboPerfiles().setSelectedItem(usuario.verPerfil());
        this.ventana.getTxtCorreo().setText(usuario.verCorreo());
        this.ventana.getTxtCorreo().setEnabled(false);
        this.ventana.setVisible(true);
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        //Cierra la ventana
        this.ventana.dispose();
    }
    
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        // Lee todos los datos escritos en textField
        String correo = this.ventana.getTxtCorreo().getText().trim();
        String apellido = this.ventana.getTxtApellido().getText().trim();
        String nombre = this.ventana.getTxtNombre().getText().trim();
        char[] claveVec = this.ventana.getClave().getPassword();
        String clave = new String(claveVec);
        char[] claveRepVec = this.ventana.getClaveRepetida().getPassword();
        String claveRep = new String(claveRepVec);
        Perfil perfil = Perfil.valueOf(this.ventana.getComboPerfiles().getSelectedItem().toString());
        //Si el indicador esta en 0, significa que debe guardar un usuario nuevo
        if (indicador == 0) {
            System.out.println(this.gu.crearUsuario(correo, apellido, nombre, perfil, clave, claveRep));
        //Si el indicador esta en 1, significa que debe guardar un usuario modificado    
        } else {
            System.out.println(this.gu.modificarUsuario(UsuarioAModificar, correo, apellido, nombre, perfil, clave, claveRep));
            }
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
    }

    @Override
    public void txtCorreoPresionarTecla(KeyEvent evt) {
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
    }

    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {
    }
}
