
package usuarios.modelos;

public enum Perfil {
    CLIENTE ("CLIENTE"),
    EMPLEADO ("EMPLEADO"),
    ENCARGADO ("ENCARGADO");
    
    private String valor;
    
    private Perfil (String valor){
        this.valor = valor;
    }
    
    
    @Override
    public String toString() {
        return this.valor;
    }
}
