import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        BinaryTree<Producto> arbolPorSKU = new BinaryTree<>();
        BinaryTree<Producto> arbolPorNombre = new BinaryTree<>(new ComparadorPorNombre());
        // Cargar datos de ejemplo
        Map<String, Integer> tallas = new HashMap<>();
        tallas.put("S", 10);
        tallas.put("M", 5);
        
        Producto p1 = new Producto("243", "camiseta", "Algodón orgánico", tallas);
        Producto p2 = new Producto("23", "aaaa", "Algodón orgánico", tallas);
        Producto p3 = new Producto("723", "iii", "Algodón orgánico", tallas);
        Producto p4 = new Producto("423", "u", "Algodón orgánico", tallas);
        
        arbolPorSKU.insert(p1);
        arbolPorNombre.insert(p1);
        arbolPorSKU.insert(p2);
        arbolPorNombre.insert(p2);
        arbolPorSKU.insert(p3);
        arbolPorNombre.insert(p3);
        arbolPorSKU.insert(p4);
        arbolPorNombre.insert(p4);
        
        while (true) {
            System.out.println("\n--- MENÚ DE INVENTARIO ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Editar producto");
            System.out.println("3. Buscar por SKU");
            System.out.println("4. Buscar por nombre");
            System.out.println("5. Listar por SKU");
            System.out.println("6. Listar por nombre");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: {
                    System.out.println("\n--- AGREGAR PRODUCTO ---");
                    System.out.print("SKU: ");
                    String sku = scanner.nextLine();
                    
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    
                    Map<String, Integer> tallasNuevo = new HashMap<>();
                    System.out.println("Ingrese tallas (ejemplo: S,5 M,10.):");
                    boolean loop = true;
                    while (loop) {
                        String input = scanner.nextLine();
                        if (input.equalsIgnoreCase(".")) loop=false;
                        
                        String[] partes = input.split(",");
                        if (partes.length == 2) {
                            tallasNuevo.put(partes[0].trim(), Integer.parseInt(partes[1].trim()));
                        }
                    }
                    
                    Producto nuevo = new Producto(sku, nombre, descripcion, tallasNuevo);
                    arbolPorSKU.insert(nuevo);
                    arbolPorNombre.insert(nuevo);
                    System.out.println("✔ Producto agregado exitosamente");
                    break;
                }
                
                case 2: {
                    System.out.println("\n--- EDITAR PRODUCTO ---");
                    System.out.print("Ingrese SKU del producto a editar: ");
                    String sku = scanner.nextLine();
                    
                    Producto producto = arbolPorSKU.buscarPorSKU(sku);
                    if (producto == null) {
                        System.out.println("No existe producto");
                        break;
                    }
                    
                    System.out.println("Producto: " + producto);
                    System.out.println("\n¿Qué desea editar?");
                    System.out.println("1. Descripción");
                    System.out.println("2. Tallas disponibles");
                    System.out.print("Opción: ");
                    int opcionEditar = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (opcionEditar == 1) {
                        System.out.print("Nueva descripción: ");
                        producto.setDescripcion(scanner.nextLine());
                    } else if (opcionEditar == 2) {
                        Map<String, Integer> nuevasTallas = new HashMap<>();
                        System.out.println("Ingrese nuevas tallas (ejemplo: S,5 M,10.) :");
                        boolean loop = true;
                        while (loop) {
                            String input = scanner.nextLine();
                            if (input.equalsIgnoreCase("fin")) loop=false;
                            
                            String[] partes = input.split(",");
                            if (partes.length == 2) {
                                nuevasTallas.put(partes[0].trim(), Integer.parseInt(partes[1].trim()));
                            }
                        }
                        producto.setTallasDisponibles(nuevasTallas);
                        
                    }
                    System.out.println("Actualizado");
                    break;
                }
                
                case 3: {
                    System.out.println("\n--- BUSCAR POR SKU ---");
                    System.out.print("Ingrese SKU: ");
                    String sku = scanner.nextLine();
                    
                    Producto producto = arbolPorSKU.buscarPorSKU(sku);
                    if (producto != null) {
                        System.out.println("Producto encontrado:\n" + producto);
                    } else {
                        System.out.println("No existe el producto");
                    }
                    break;
                }
                
                case 4: {
                    System.out.println("\n--- BUSCAR POR NOMBRE ---");
                    System.out.print("Ingrese nombre: ");
                    String name = scanner.nextLine();
                    
                    Producto proudcto = arbolPorNombre.buscarPorNombre(name);
                    if (proudcto != null) {
                        System.out.println("Producto :\n" + proudcto);
                    } else {
                        System.out.println("Producto no existe");
                    }
                    break;
                }
                
                case 5: {
                    System.out.println("\n--- PRODUCTOS ORDENADOS POR SKU ---");
                    arbolPorSKU.inOrderTraversal();
                    break;
                }
                
                case 6: {
                    System.out.println("\n--- PRODUCTOS ORDENADOS POR NOMBRE ---");
                    arbolPorNombre.inOrderTraversal();
                    break;
                }
                
                case 7: {
                    System.out.println("Saliendo del sistema...");
                    System.exit(0);
                    break;
                }
                
                default: {
                    System.out.println("Opcion invalida");
                }
            }
        }
    }
}