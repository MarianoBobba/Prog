package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaUsuarios extends AbstractTableModel {

    private IGestorUsuarios gu = GestorUsuarios.instanciar();
    private List<String> nombreColumnas = new ArrayList<>();
    private List<Usuario> usuarios;

    public ModeloTablaUsuarios() {
        this.nombreColumnas.add("Apellidos");
        this.nombreColumnas.add("Nombres");
        this.nombreColumnas.add("Perfil");
        this.nombreColumnas.add ("Correo");
        this.usuarios = gu.verUsuarios();
    }
    
    public ModeloTablaUsuarios(String apellido) {
        this.nombreColumnas.add("Apellidos");
        this.nombreColumnas.add("Nombres");
        this.nombreColumnas.add("Perfil");
        this.nombreColumnas.add ("Correo");
        this.usuarios = gu.buscarUsuarios(apellido);
    }

    @Override
    public int getRowCount() {
        return this.usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {

        Usuario u = this.usuarios.get(fila);
        switch (columna) {
            case 0:
                return u.verApellido();
            case 1:
                return u.verNombre();
            case 2:
                return u.verPerfil();
            default:
                return u.verCorreo();
        }
    }
   

    @Override
    public String getColumnName(int columna) {
        return this.nombreColumnas.get(columna);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
    public Usuario verUsuarioSeleccionado(int selectedRow){
        return usuarios.get(selectedRow);
    }
}
