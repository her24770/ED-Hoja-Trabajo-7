/**
 * Clase BinaryTree simulando un nodo con sus hijos.
 * Codigo obtenido de ejemplo del contenido de Clase de Estructura de Datos.
 */
import java.util.Comparator;

public class BinaryTree<T extends Comparable<T>> {
    protected T value;
    protected BinaryTree<T> parent;
    protected BinaryTree<T> left, right;
    private Comparator<T> comparador;

    /**
     * 
     */
    public BinaryTree() {
        this(null);
    }

    /**
     * @param comparador
     */
    public BinaryTree(Comparator<T> comparador) {
        this.value = null;
        this.parent = null;
        this.left = this.right = this;
        this.comparador = comparador;
    }

    /**
     * @param a
     * @param b
     * @return
     */
    private int compare(T a, T b) {
        if (comparador != null) {
            return comparador.compare(a, b);
        } else {
            return a.compareTo(b);
        }
    }

    /**
     * @return
     */
    public boolean isEmpty() {
        return value == null;
    }

    /**
     * @return
     */
    public T getValue() {
        return value;
    }

    /**
     * @return
     */
    public BinaryTree<T> getLeft() {
        return left;
    }

    /**
     * @return
     */
    public BinaryTree<T> getRight() {
        return right;
    }

    /**
     * @return
     */
    public BinaryTree<T> getParent() {
        return parent;
    }

    /**
     * @param newLeft
     */
    public void setLeft(BinaryTree<T> newLeft) {
        if (isEmpty()) return;
        if (left != null && left.getParent() == this) {
            left.setParent(null);
        }
        left = newLeft;
        left.setParent(this);
    }

    /**
     * @param newRight
     */
    public void setRight(BinaryTree<T> newRight) {
        if (isEmpty()) return;
        if (right != null && right.getParent() == this) {
            right.setParent(null);
        }
        right = newRight;
        right.setParent(this);
    }

    /**
     * @param newParent
     */
    protected void setParent(BinaryTree<T> newParent) {
        if (!isEmpty()) {
            parent = newParent;
        }
    }

    /**
     * @param val
     */
    public void insert(T val) {
        if (isEmpty()) {
            value = val;
            left = new BinaryTree<>(comparador);
            right = new BinaryTree<>(comparador);
            left.setParent(this);
            right.setParent(this);
        } else {
            int cmp = compare(val, this.value);
            if (cmp < 0) {
                left.insert(val);
            } else if (cmp > 0) {
                right.insert(val);
            }
        }
    }

    /**
     * @param sku
     * @return
     */
    public T buscarPorSKU(String sku) {
        if (isEmpty()) {
            return null;
        }

        String skuActual = ((Producto)this.value).getSku();
        int cmp = sku.compareTo(skuActual);

        if (cmp == 0) {
            return this.value;
        } else if (cmp < 0) {
            return left.buscarPorSKU(sku);
        } else {
            return right.buscarPorSKU(sku);
        }
    }

    /**
     * @param nombre
     * @return
     */
    public T buscarPorNombre(String nombre) {
        if (isEmpty()) {
            return null;
        }

        String nombreActual = ((Producto)this.value).getNombre();
        int cmp = nombre.compareToIgnoreCase(nombreActual);

        if (cmp == 0) {
            return this.value;
        } else if (cmp < 0) {
            return left.buscarPorNombre(nombre);
        } else {
            return right.buscarPorNombre(nombre);
        }
    }

    /**
     * 
     */
    public void inOrderTraversal() {
        if (!isEmpty()) {
            left.inOrderTraversal();
            System.out.println(value);
            right.inOrderTraversal();
        }
    }
}