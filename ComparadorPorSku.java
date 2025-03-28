import java.util.Comparator;

public class ComparadorPorSku implements Comparator<Producto> {
    @Override
    public int compare(Producto p1, Producto p2) {
        return p1.getSku().compareTo(p2.getSku());
    }
}