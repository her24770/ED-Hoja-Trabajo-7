/*
 *Clase Producto como objeto guardado en Maps o listas
 */
import java.util.Map;

public class Producto implements Comparable<Producto> {
    private String sku; // Código único del producto
    private String nombre; // Nombre del producto
    private String descripcion; // Descripción del producto
    private Map<String, Integer> tallasDisponibles; // Tallas y cantidades disponibles

    // Constructor
    /**
     * @param sku
     * @param nombre
     * @param descripcion
     * @param tallasDisponibles
     */
    public Producto(String sku, String nombre, String descripcion, Map<String, Integer> tallasDisponibles) {
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tallasDisponibles = tallasDisponibles;
    }

    // Getters y setters
    /**
     * @return
     */
    public String getSku() {
        return sku;
    }

    /**
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return
     */
    public Map<String, Integer> getTallasDisponibles() {
        return tallasDisponibles;
    }

    /**
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @param tallasDisponibles
     */
    public void setTallasDisponibles(Map<String, Integer> tallasDisponibles) {
        this.tallasDisponibles = tallasDisponibles;
    }

    @Override
    public String toString() {
        return "SKU: " + sku + ", Nombre: " + nombre + ", Descripción: " + descripcion + ", Tallas: " + tallasDisponibles;
    }

    // Implementación de Comparable<Producto> (por defecto, comparar por SKU)
    @Override
    public int compareTo(Producto other) {
        return this.sku.compareTo(other.sku);
    }
}