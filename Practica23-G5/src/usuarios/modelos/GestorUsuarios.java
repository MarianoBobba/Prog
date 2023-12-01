/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;
import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import usuarios.modelos.Usuario;

/**
 *
 * @author estudiante
 */

public class GestorUsuarios implements IGestorUsuarios{
    
    private static GestorUsuarios gestor;

    public static IGestorUsuarios instanciar() {
        return new GestorUsuarios();
    }
    
    private ArrayList<Usuario> usuarios = new ArrayList<>();
//    private static final String EXITO = "Se creo/modifico el usuario con exito.";
//    private static final String NOMBRE = "Nombre invalido. No se creo/modifico el usuario.";
//    private static final String APELLIDO = "Apellido invalido. No se creo/modifico el usuario.";
//    private static final String CLAVE = "Clave invalida. No se creo/modifico el usuario.";
//    private static final String CORREO = "Correo invalido. No se creo/modifico el usuario.";
//    private static final String REPETIDO = "Usuario ya existente. No se creo/modifico el usuario.";
//    private static final String INEXISTENTE = "Usuario no existente. No se creo/modifico el usuario.";
//    private static final String PERFIL = "Perfil invalido. No se creo/modifico el usuario.";
//    private static final String CLAVE_REPETIDA = "Las claves no coinciden. No se creo/modifico el usuario.";
//    private static final String BORRAR = "No se pudo borrar el usuario.";
     
    private GestorUsuarios() {
        
    }
     
    public static GestorUsuarios crear() {
        if (gestor == null)
        gestor = new GestorUsuarios();
        return gestor;
    }
    
    public String crearUsuario(String correo, String clave, String apellido, String nombre, String claveRepetida, Perfil perfil) {
        
        Usuario U1;
        if (clave == null || clave.isEmpty ())
            return CLAVE;
        else if (apellido == null || apellido.isEmpty ())
            return APELLIDO;
        else if (nombre == null || nombre.isEmpty ())
            return NOMBRE;
        else if (correo == null || correo.isEmpty () || !correo.contains("@"))
            return CORREO;
        else if (clave != claveRepetida)
            return CLAVE_REPETIDA;
        if (null == perfil) 
            return PERFIL;
        else switch (perfil) {
            case CLIENTE:
                {
                    U1 = new Cliente (correo, clave, apellido, nombre, claveRepetida, perfil);
                    break;
                }
            case EMPLEADO:
                {
                    U1 = new Empleado (correo, clave, apellido, nombre, claveRepetida, perfil);
                    break;
                }
            case ENCARGADO:
                {
                    U1 = new Encargado (correo, clave, apellido, nombre, claveRepetida, perfil);
                    break;
                }
            default:
                return PERFIL;
        }
        if (!usuarios.contains(U1)){
            usuarios.add(U1);
            return EXITO;
        }
        else 
            return REPETIDO;
      
    }
    
    public List<Usuario> verUsuarios() {
        Collections.sort(usuarios, Comparator.comparing(Usuario::verApellido).thenComparing(Usuario::verNombre));
        return usuarios;
    }
    
    public List<Usuario> buscarUsuarios(String apellido) {
        ArrayList<Usuario> usuariosEncontrados = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            if (usuario.verApellido().toLowerCase().contains(apellido.toLowerCase())) {
                usuariosEncontrados.add(usuario);
            }
        }
        
        Collections.sort(usuariosEncontrados, Comparator.comparing(Usuario::verApellido).thenComparing(Usuario::verNombre));
        return usuariosEncontrados;
    }
    
    public boolean existeEsteUsuario(Usuario usuario) {
        return usuarios.contains(usuario);
    }
    
    public Usuario obtenerUsuario(String correo) {
        for (Usuario usuario : usuarios) {
            if (usuario.verCorreo() == correo) {
                return usuario;
            } else {
            }
        }
        return null;
    }

    public String borrarUsuario(Usuario usuario) {
        if(usuario == null){
            return INEXISTENTE;
        }
        for (Usuario u : usuarios) {
                if (u == usuario && usuario.verPerfil() != Perfil.CLIENTE) {
                    usuarios.remove(usuario);
                    return EXITO;
                }
                else if (u == usuario && usuario.verPerfil() == Perfil.CLIENTE && ((Cliente) usuario).verPedidos().isEmpty()) {
                    usuarios.remove(usuario);
                    return EXITO;
                }
                else 
                    return BORRAR;
            }
        return BORRAR;

    }
    
}
