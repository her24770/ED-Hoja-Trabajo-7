import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreeTest {
    private BinaryTree<Producto> arbolPorSKU;
    private BinaryTree<Producto> arbolPorNombre;
    private Map<String, Integer> tallas;

    @Before
    public void setUp() {
        arbolPorSKU = new BinaryTree<>();
        arbolPorNombre = new BinaryTree<>(new ComparadorPorNombre());
        tallas = new HashMap<>();
        tallas.put("S", 10);
        tallas.put("M", 5);
    }

    // Pruebas para insert()
    @Test
    public void testInsert_ProductoValido_SeAgregaCorrectamente() {
        Producto producto = new Producto("001", "Camiseta", "Algodón", tallas);
        arbolPorSKU.insert(producto);
        arbolPorNombre.insert(producto);
        
        assertNotNull(arbolPorSKU.buscarPorSKU("001"));
        assertNotNull(arbolPorNombre.buscarPorNombre("Camiseta"));
    }

    

    // Pruebas para buscarPorNombre()
    @Test
    public void testBuscarPorNombre_ProductoExistente_RetornaProducto() {
        Producto producto = new Producto("005", "Bufanda", "Lana", tallas);
        arbolPorNombre.insert(producto);
        
        Producto resultado = arbolPorNombre.buscarPorNombre("Bufanda");
        assertNotNull(resultado);
        assertEquals("005", resultado.getSku());
    }

    @Test
    public void testBuscarPorNombre_ProductoNoExistente_RetornaNull() {
        Producto producto = new Producto("006", "Cinturón", "Cuero", tallas);
        arbolPorNombre.insert(producto);
        
        assertNull(arbolPorNombre.buscarPorNombre("Sombrero"));
    }

    @Test
    public void testBuscarPorNombre_BusquedaCaseInsensitive() {
        Producto producto = new Producto("007", "Abrigo", "Invierno", tallas);
        arbolPorNombre.insert(producto);
        
        assertNotNull(arbolPorNombre.buscarPorNombre("ABRIGO"));
        assertNotNull(arbolPorNombre.buscarPorNombre("abrigo"));
    }

    // Pruebas para buscarPorSKU()
    @Test
    public void testBuscarPorSKU_Existente_RetornaProducto() {
        Producto producto = new Producto("010", "Short", "Deportivo", tallas);
        arbolPorSKU.insert(producto);
        
        Producto resultado = arbolPorSKU.buscarPorSKU("010");
        assertNotNull(resultado);
        assertEquals("Short", resultado.getNombre());
    }

    @Test
    public void testBuscarPorSKU_NoExistente_RetornaNull() {
        Producto producto = new Producto("020", "Medias", "Algodón", tallas);
        arbolPorSKU.insert(producto);
        
        assertNull(arbolPorSKU.buscarPorSKU("999"));
    }

    @Test
    public void testBuscarPorSKU_ArbolVacio_RetornaNull() {
        BinaryTree<Producto> arbolVacio = new BinaryTree<>();
        assertNull(arbolVacio.buscarPorSKU("001"));
    }

    @Test
    public void testBuscarPorSKU_MultiplesProductos_EncuentraCorrectamente() {
        Producto p1 = new Producto("100", "Producto1", "Desc1", tallas);
        Producto p2 = new Producto("200", "Producto2", "Desc2", tallas);
        Producto p3 = new Producto("050", "Producto3", "Desc3", tallas);
        
        arbolPorSKU.insert(p1);
        arbolPorSKU.insert(p2);
        arbolPorSKU.insert(p3);
        
        assertEquals("Producto1", arbolPorSKU.buscarPorSKU("100").getNombre());
        assertEquals("Producto3", arbolPorSKU.buscarPorSKU("050").getNombre());
    }
}