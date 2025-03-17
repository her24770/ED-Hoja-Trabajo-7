import java.util.HashMap;
import java.util.Map;

public class Main {

    // Árboles para almacenar los productos ordenados por SKU y por nombre
    

    public static void main(String[] args) {
        BinaryTree<Producto> arbolPorSKU= new BinaryTree<>();
        BinaryTree<Producto> arbolPorNombre= new BinaryTree<>();

        // Crear algunos productos
        Map<String, Integer> tallas1 = new HashMap<>();
        tallas1.put("XS", 10);
        tallas1.put("S", 15);
        tallas1.put("M", 20);
        Producto producto1 = new Producto("123", "Jersey deportivo", "Playera de tela con absorción de sudor", tallas1);

        Map<String, Integer> tallas2 = new HashMap<>();
        tallas2.put("S", 5);
        tallas2.put("M", 10);
        tallas2.put("L", 8);
        Producto producto2 = new Producto("456", "Chumpa impermeable", "Chumpa ligera de nylon para ejercicio en exterior", tallas2);

        // Agregar productos al inventario
        arbolPorNombre.insert(producto2);
        arbolPorNombre.insert(producto1);
        arbolPorSKU.insert(producto2);
        arbolPorSKU.insert(producto1);

        // Buscar un producto por SKU
        Producto encontradoPorSKU = buscarPorSKU("123");
        if (encontradoPorSKU != null) {
            System.out.println("Producto encontrado por SKU: " + encontradoPorSKU);
        } else {
            System.out.println("Producto no encontrado por SKU.");
        }

        // Buscar un producto por nombre
        Producto encontradoPorNombre = buscarPorNombre("Chumpa impermeable");
        if (encontradoPorNombre != null) {
            System.out.println("Producto encontrado por nombre: " + encontradoPorNombre);
        } else {
            System.out.println("Producto no encontrado por nombre.");
        }

        // Listar todos los productos ordenados por SKU
        System.out.println("\nProductos ordenados por SKU:");
        arbolPorSKU.inOrderTraversal();

        // Listar todos los productos ordenados por nombre
        System.out.println("\nProductos ordenados por nombre:");
        arbolPorNombre.inOrderTraversal();
    }

    
    /* 
    // Método para buscar un producto por SKU
    public static Producto buscarPorSKU(String sku) {
        return buscarEnArbol(arbolPorSKU, sku, true);
    }

    // Método para buscar un producto por nombre
    public static Producto buscarPorNombre(String nombre) {
        return buscarEnArbol(arbolPorNombre, nombre, false);
    }

    // Método auxiliar para buscar en un árbol
    private static Producto buscarEnArbol(BinaryTree<Producto> arbol, String clave, boolean porSKU) {
        if (arbol.isEmpty()) {
            return null;
        }

        Producto producto = arbol.getValue();
        String valorClave = porSKU ? producto.getSku() : producto.getNombre();

        if (valorClave.equals(clave)) {
            return producto;
        } else if (clave.compareTo(valorClave) < 0) {
            return buscarEnArbol(arbol.getLeft(), clave, porSKU);
        } else {
            return buscarEnArbol(arbol.getRight(), clave, porSKU);
        }
    }*/

}