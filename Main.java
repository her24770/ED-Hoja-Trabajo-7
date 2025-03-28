import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static BinaryTree<Producto> arbolPorSKU = new BinaryTree<>();
    private static BinaryTree<Producto> arbolPorNombre = new BinaryTree<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        cargarDatosEjemplo(); // Opcional: carga datos iniciales
        
        while (true) {
            System.out.println("\n--- MENÚ DE INVENTARIO ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Editar producto");
            System.out.println("3. Buscar por SKU");
            System.out.println("4. Buscar por nombre");
            System.out.println("5. Listar todos los productos (por SKU)");
            System.out.println("6. Listar todos los productos (por nombre)");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    editarProducto();
                    break;
                case 3:
                    buscarPorSKU();
                    break;
                case 4:
                    buscarPorNombre();
                    break;
                case 5:
                    listarPorSKU();
                    break;
                case 6:
                    listarPorNombre();
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void cargarDatosEjemplo() {
        Map<String, Integer> tallas = new HashMap<>();
        tallas.put("S", 10);
        tallas.put("M", 5);
        Producto p1 = new Producto("243", "camiseta", "Algodón orgánico", tallas);
        Producto p2 = new Producto("23", "aaaa", "Algodón orgánico", tallas);
        Producto p3= new Producto("723", "rrrrrr", "Algodón orgánico", tallas);
        Producto p4=new Producto("423", "eeee", "Algodón orgánico", tallas);
        arbolPorSKU.insert(p1);
        arbolPorNombre.insert(p1);
        arbolPorSKU.insert(p2);
        arbolPorNombre.insert(p2);
        arbolPorSKU.insert(p3);
        arbolPorNombre.insert(p3);
        arbolPorSKU.insert(p4);
        arbolPorNombre.insert(p4);
    }

    private static void agregarProducto() {
        System.out.println("\n--- AGREGAR PRODUCTO ---");
        System.out.print("SKU: ");
        String sku = scanner.nextLine();
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        
        Map<String, Integer> tallas = new HashMap<>();
        System.out.println("Ingrese tallas (ejemplo: S,5 M,10). Termine con 'fin':");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("fin")) break;
            
            String[] partes = input.split(",");
            if (partes.length == 2) {
                tallas.put(partes[0].trim(), Integer.parseInt(partes[1].trim()));
            }
        }
        
        Producto nuevo = new Producto(sku, nombre, descripcion, tallas);
        arbolPorSKU.insert(nuevo);
        arbolPorNombre.insert(nuevo);
        System.out.println("✔ Producto agregado exitosamente");
    }

    private static void editarProducto() {
        System.out.println("\n--- EDITAR PRODUCTO ---");
        System.out.print("Ingrese SKU del producto a editar: ");
        String sku = scanner.nextLine();
        
        Producto encontrado = arbolPorSKU.buscar(sku, p -> p.getSku());
        if (encontrado == null) {
            System.out.println("❌ Producto no encontrado");
            return;
        }
        
        System.out.println("Producto actual: " + encontrado);
        System.out.println("\n¿Qué desea editar?");
        System.out.println("1. Descripción");
        System.out.println("2. Tallas disponibles");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        if (opcion == 1) {
            System.out.print("Nueva descripción: ");
            encontrado.setDescripcion(scanner.nextLine());
            System.out.println("✔ Descripción actualizada");
        } else if (opcion == 2) {
            Map<String, Integer> nuevasTallas = new HashMap<>();
            System.out.println("Ingrese nuevas tallas (formato: S,5 M,10). Termine con 'fin':");
            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("fin")) break;
                
                String[] partes = input.split(",");
                if (partes.length == 2) {
                    nuevasTallas.put(partes[0].trim(), Integer.parseInt(partes[1].trim()));
                }
            }
            encontrado.setTallasDisponibles(nuevasTallas);
            System.out.println("✔ Tallas actualizadas");
        }
    }

    private static void buscarPorSKU() {
        System.out.println("\n--- BUSCAR POR SKU ---");
        System.out.print("Ingrese SKU: ");
        String sku = scanner.nextLine();
        
        Producto encontrado = arbolPorSKU.buscar(sku, p -> p.getSku());
        if (encontrado != null) {
            System.out.println("Producto encontrado:\n" + encontrado);
        } else {
            System.out.println("❌ Producto no encontrado");
        }
    }

    private static void buscarPorNombre() {
        System.out.println("\n--- BUSCAR POR NOMBRE ---");
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        
        Producto encontrado = arbolPorNombre.buscar(nombre, p -> p.getNombre());
        if (encontrado != null) {
            System.out.println("Producto encontrado:\n" + encontrado);
        } else {
            System.out.println("❌ Producto no encontrado");
        }
    }

    private static void listarPorSKU() {
        System.out.println("\n--- PRODUCTOS ORDENADOS POR SKU ---");
        arbolPorSKU.inOrderTraversal();
    }

    private static void listarPorNombre() {
        System.out.println("\n--- PRODUCTOS ORDENADOS POR NOMBRE ---");
        arbolPorNombre.inOrderTraversal();
    }
}