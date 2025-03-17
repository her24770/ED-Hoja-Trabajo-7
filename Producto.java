import java.util.Map;

public class Producto implements Comparable<Producto> {
    private String sku; // Código único del producto
    private String nombre; // Nombre del producto
    private String descripcion; // Descripción del producto
    private Map<String, Integer> tallasDisponibles; // Tallas y cantidades disponibles

    // Constructor
    public Producto(String sku, String nombre, String descripcion, Map<String, Integer> tallasDisponibles) {
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tallasDisponibles = tallasDisponibles;
    }

    // Getters y setters
    public String getSku() {
        return sku;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Map<String, Integer> getTallasDisponibles() {
        return tallasDisponibles;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTallasDisponibles(Map<String, Integer> tallasDisponibles) {
        this.tallasDisponibles = tallasDisponibles;
    }

    @Override
    public String toString() {
        return "SKU: " + sku + ", Nombre: " + nombre + ", Descripción: " + descripcion + ", Tallas: " + tallasDisponibles;
    }

    // Implementación del método compareTo para comparar productos por SKU
    @Override
    public int compareTo(Producto otro) {
        return this.sku.compareTo(otro.sku);
    }
}