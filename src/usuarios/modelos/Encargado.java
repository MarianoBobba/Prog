
package usuarios.modelos;

import java.util.List;
import pedidos.modelos.Pedido;

public class Encargado extends Usuario {

    public Encargado(String correo, String clave, String apellido, String nombre, Perfil perfil) {
        super(correo, clave, apellido, nombre,  perfil);
    }
    
    
    @Override
    public List<Pedido> verPedidos(){
        return verPedidos();   
    }
    
    
}
