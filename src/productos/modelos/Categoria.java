
package productos.modelos;

public enum Categoria {
    
    ENTRADA ("ENTRADA"), 
    PLATO_PRINCIPAL ("PLATO_PRINCIPAL"), 
    POSTRE ("POSTRE");
    
    private String valor;

    private Categoria (String valor){
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return this.valor;
    }


}
