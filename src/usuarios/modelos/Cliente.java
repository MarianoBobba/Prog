package usuarios.modelos;

import java.util.ArrayList;
import java.util.List;

import pedidos.modelos.Pedido;


public class Cliente extends Usuario {
    
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(String correo, String clave, String apellido, String nombre, Perfil perfil) {
        super(correo, clave, apellido, nombre,perfil);
    }
    
    @Override
    public List<Pedido> verPedidos(){  
        return pedidos;

    }
    
    public void agregarPedido(Pedido unPedido){

        if(!pedidos.contains (unPedido))
        {
            pedidos.add(unPedido);
        }
        else {
            
            for (Pedido p : pedidos){
                if(unPedido.equals(p))  
                    p = unPedido;
            }
        }

    }
    
    public void cancelarPedido(Pedido unPedido){
        
        if(pedidos.contains (unPedido)) {
          pedidos.remove(pedidos.indexOf(unPedido));
        }
    }
  
}
