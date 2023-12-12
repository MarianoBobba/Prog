/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;


public interface IGestorUsuarios {
    
    public static final String EXITO = "Usuario creado/modificado con exito";
    public static final String CORREO = "El correo del usuario es incorrecto";
    public static final String APELLIDO = "El apellido del usuario es incorrecto";
    public static final String NOMBRE = "El nombre del usuario es incorrecto";
    public static final String CLAVE = "La clave especificada no es valida";
    public static final String CLAVES = "Las claves especificadas no coinciden o son incorrectas";
    public static final String PERFIL = "El perfil del usuario es incorrecto";
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo";
    public static final String USUARIO_INEXISTENTE = "No existe el usuario especificado"; 
    public static final String ERROR_BORRAR_USUARIO = "El usuario no se pudo borrar, ya que el mismo realizo pedidos";
    
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida);
    public List<Usuario> verUsuarios();
    public List<Usuario> buscarUsuarios(String apellido);
    public String borrarUsuario(Usuario usuario);
    public boolean existeEsteUsuario(Usuario usuario);
    public Usuario obtenerUsuario(String correo);
    public String modificarUsuario(Usuario usuarioAModificar, String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida);
}
