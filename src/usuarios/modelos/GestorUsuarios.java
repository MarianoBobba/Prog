package usuarios.modelos;

import interfaces.IGestorUsuarios;
import static interfaces.IGestorUsuarios.REPETIDO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import static usuarios.modelos.Perfil.CLIENTE;
import static usuarios.modelos.Perfil.EMPLEADO;
import static usuarios.modelos.Perfil.ENCARGADO;


public class GestorUsuarios implements IGestorUsuarios {

    private final String ARCHIVO = "ArchivoUsuarios.txt";
    BufferedWriter bw = null;
    BufferedReader br = null;
    String linea;

    private List<Usuario> usuarios = new ArrayList<>();

    private static GestorUsuarios gestor;

    private GestorUsuarios() {
        this.cargarDatosDesdeArchivo(ARCHIVO);
    }

    public static GestorUsuarios instanciar() {
        if (gestor == null) {
            gestor = new GestorUsuarios();
        }
        return gestor;
    }

    @Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {

        if (correo == null || !correo.contains("@")) {
            return CORREO;
        }
        if (apellido == null || apellido.isEmpty()) {
            return APELLIDO;
        }
        if (nombre == null || nombre.isEmpty()) {
            return NOMBRE;
        }
        if (clave == null || clave.isEmpty()) {
            return CLAVE;
        }
        if (claveRepetida == null || claveRepetida.isEmpty() || !claveRepetida.equals(clave)) {
            return CLAVE;
        } else {
            switch (perfil) {
                case CLIENTE:
                    Usuario unCliente = new Cliente(correo, clave, apellido, nombre, claveRepetida, perfil);
                    if (!usuarios.contains(unCliente)) {
                        usuarios.add(unCliente);
                        this.guardarDatosEnArchivo();
                    } else {
                        return REPETIDO;
                    }
                    break;
                case EMPLEADO:
                    Usuario unEmpleado = new Empleado(correo, clave, apellido, nombre, claveRepetida, perfil);
                    if (!usuarios.contains(unEmpleado)) {
                        usuarios.add(unEmpleado);
                        this.guardarDatosEnArchivo();
                    } else {
                        return REPETIDO;
                    }
                    break;
                case ENCARGADO:
                    Usuario unEncargado = new Encargado(correo, clave, apellido, nombre, claveRepetida, perfil);
                    if (!usuarios.contains(unEncargado)) {
                        usuarios.add(unEncargado);
                        this.guardarDatosEnArchivo();
                    } else {
                        return REPETIDO;
                    }
                    break;
            }            
            return EXITO;
        }
    }
    
    @Override
    public String modificarUsuario(Usuario usuarioAModificar, String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        Usuario usuario = null;

        if (perfil == null) {
            return PERFIL;
        }
        if (correo == null || !correo.contains("@")) {
            return CORREO;
        }
        if (apellido == null || apellido.isEmpty()) {
            return APELLIDO;
        }
        if (nombre == null || nombre.isEmpty()) {
            return NOMBRE;
        }
        if (clave == null || clave.isEmpty()) {
            return CLAVE;
        }
        if (claveRepetida == null || claveRepetida.isEmpty() || !claveRepetida.equals(clave)) {
            return CLAVE;
        } else {

            for (Usuario u : usuarios) {
                if (u.equals(usuarioAModificar)) {
                    usuario = u;
                }
            }
            if (usuario == null) {
                return INEXISTENTE;
            }
            usuario.asignarApellido(apellido);
            usuario.asignarNombre(nombre);
            usuario.asignarClave(clave);
            this.guardarDatosEnArchivo();
            return EXITO;
        }
    }

    @Override
    public List<Usuario> verUsuarios() {
        return usuarios;
    }

    @Override
    public List<Usuario> buscarUsuarios(String apellido) {
        List<Usuario> usuariosBuscados = new ArrayList<>();
        if (apellido != null) {

            for (Usuario u : usuarios) {
                if ((u.verApellido().toLowerCase()).contains(apellido.toLowerCase())) {
                    usuariosBuscados.add(u);
                }
            }
        }
        Collections.sort(usuariosBuscados, (u1, u2) -> {
            if (u1.verApellido().compareTo(u2.verApellido()) == 0) {
                return u1.verNombre().compareTo(u2.verNombre());
            } else {
                return u1.verApellido().compareTo(u2.verApellido());
            }
        });
        return usuariosBuscados;
    }

    @Override
    public boolean existeEsteUsuario(Usuario usuario) {
        int bandera = 0;

        if (usuario == null) {
            return false;
        }
        for (Usuario p : usuarios) {
            if (p.equals(usuario)) {
                bandera = 1;
            }
        }
        if (bandera == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Usuario obtenerUsuario(String correo) {
        for (Usuario u : usuarios) {
            if ((u.verCorreo()).equals(correo)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public String borrarUsuario(Usuario usuario) {

        if (usuario == null) {
            return INEXISTENTE;
        }

        switch (usuario.verPerfil()) {
            case CLIENTE:
                for (Usuario u : usuarios) {
                    if (u.equals(usuario) && (usuario.verPedidos().isEmpty() || usuario.verPedidos() == null)) {
                        usuarios.remove(u);
                        this.guardarDatosEnArchivo();
                        return EXITO;
                    }

                }
            break;
    
            case EMPLEADO:
                for (Usuario u : usuarios) {
                    if (u.equals(usuario)) {
                        usuarios.remove(u);
                        this.guardarDatosEnArchivo();
                        return EXITO;
                    }

                }
            break;
    
            case ENCARGADO:
                for (Usuario u : usuarios) {
                    if (u.equals(usuario)) {
                        usuarios.remove(u);
                        this.guardarDatosEnArchivo();
                        return EXITO;
                    }

                }
            break;
        
        }

        return " ";
    }

    private void guardarDatosEnArchivo() {
        File f = new File(ARCHIVO);

        try {
            FileWriter fw = new FileWriter(f);
            bw = new BufferedWriter(fw);

            for (Usuario u : this.usuarios) {
                linea = (u.verCorreo() + ","  + u.verApellido() + "," + u.verNombre() + "," + u.verPerfil() + "," + u.verClave());
                bw.write(linea);
                bw.newLine();
            } 
            bw.close();
        } catch (FileNotFoundException fnf) {
            System.out.println("Archivo no existente.");            
        }
        catch (IOException ioe) {   
        }

    }

    private void cargarDatosDesdeArchivo(String ARCHIVO) {
        File f = new File(ARCHIVO);

        try {
            FileReader fr = new FileReader(f);
            br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {
                String[] vector = linea.split(",");
                String correo = vector[0];
                String apellido = vector[1];
                String nombre = vector[2];
                Perfil perfil = Perfil.valueOf(vector[3].toUpperCase());
                String clave = vector[4];
                this.crearUsuario(correo, apellido, nombre, perfil, clave, clave);  
            }
            br.close();
            }

         catch (FileNotFoundException fnf) {
            System.out.println("Archivo no existente.");
        } catch (IOException ioe) {
            
        }
    }

    
}
