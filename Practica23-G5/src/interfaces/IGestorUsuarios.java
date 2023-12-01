/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.ArrayList;
import java.util.List;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;

/**
 *
 * @author estudiante
 */
public interface IGestorUsuarios {
    
    public static final String EXITO = "Se creo/modifico el usuario con exito.";
    public static final String NOMBRE = "Nombre invalido. No se creo/modifico el usuario.";
    public static final String APELLIDO = "Apellido invalido. No se creo/modifico el usuario.";
    public static final String CLAVE = "Clave invalida. No se creo/modifico el usuario.";
    public static final String CORREO = "Correo invalido. No se creo/modifico el usuario.";
    public static final String REPETIDO = "Usuario ya existente. No se creo/modifico el usuario.";
    public static final String INEXISTENTE = "Usuario no existente. No se creo/modifico el usuario.";
    public static final String PERFIL = "Perfil invalido. No se creo/modifico el usuario.";
    public static final String CLAVE_REPETIDA = "Las claves no coinciden. No se creo/modifico el usuario.";
    public static final String BORRAR = "No se pudo borrar el usuario.";
    
    public String crearUsuario(String correo, String clave, String apellido, String nombre, String claveRepetida, Perfil perfil);
    public List<Usuario> verUsuarios();
    public List<Usuario> buscarUsuarios(String apellido);
    public boolean existeEsteUsuario(Usuario usuario);
    public Usuario obtenerUsuario(String correo);
    public String borrarUsuario(Usuario usuario);
    
}
