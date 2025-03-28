/**
 * Clase para delimiter el orden de los productos por nombre usando un comparador.
 */
import java.util.Comparator;

public class ComparadorPorNombre implements Comparator<Producto> {
    @Override
    public int compare(Producto p1, Producto p2) {
        return p1.getNombre().compareTo(p2.getNombre());
    }
}