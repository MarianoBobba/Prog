
package productos.modelos;


public class Producto implements Comparable<Producto>{
    private int codigo;
    private float precio;
    private String descripcion;
    private Categoria categoria;
    private Estado estado;

    public Producto(int codigo, String descripcion, Categoria categoria, Estado estado ,float precio) {
        this.codigo = codigo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
    }
    

    public int verCodigo() {
        return codigo;
    }

    public void asignarCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float verPrecio() {
        return precio;
    }

    public void asignarPrecio(float precio) {
        this.precio = precio;
    }

    public String verDescripcion() {
        return descripcion;
    }

    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria verCategoria() {
        return categoria;
    }

    public void asignarCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return this.codigo == other.codigo;
    }
    
    @Override
    public String toString() {
    return "Producto{" + "descripcion=" + descripcion + '}';
    }

    public void mostrar(){
        System.out.println("El producto: "+ descripcion +  "\n" + estado.toString() + "\n" + precio + "\n" + categoria + "\n" + codigo + "\n" );
        
    }

    @Override
    public int compareTo(Producto p) {
        
        return this.descripcion.compareTo(p.descripcion);
    }
    

}
