import java.util.Comparator;

public class BinaryTree<T extends Comparable<T>> {
    protected T value;
    protected BinaryTree<T> parent;
    protected BinaryTree<T> left, right;
    private Comparator<T> comparador;

    // Constructores
    public BinaryTree() {
        this(null);  // Usa orden natural (Comparable)
    }

    public BinaryTree(Comparator<T> comparador) {
        this.value = null;
        this.parent = null;
        this.left = this.right = this;
        this.comparador = comparador;
    }

    // Método de comparación
    private int compare(T a, T b) {
        if (comparador != null) {
            return comparador.compare(a, b);
        } else {
            return a.compareTo(b);  // Usa Comparable si no hay comparador
        }
    }

    // Métodos básicos del árbol
    public boolean isEmpty() {
        return value == null;
    }

    public T getValue() {
        return value;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    public BinaryTree<T> getParent() {
        return parent;
    }

    // Métodos de modificación
    public void setLeft(BinaryTree<T> newLeft) {
        if (isEmpty()) return;
        if (left != null && left.getParent() == this) {
            left.setParent(null);
        }
        left = newLeft;
        left.setParent(this);
    }

    public void setRight(BinaryTree<T> newRight) {
        if (isEmpty()) return;
        if (right != null && right.getParent() == this) {
            right.setParent(null);
        }
        right = newRight;
        right.setParent(this);
    }

    protected void setParent(BinaryTree<T> newParent) {
        if (!isEmpty()) {
            parent = newParent;
        }
    }

    // Operaciones principales
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
            // Ignora duplicados (cmp == 0)
        }
    }

    public T buscar(String clave, ComparadorBusqueda<T> comparadorBusqueda) {
        if (isEmpty()) {
            return null;
        }

        String valorClave = comparadorBusqueda.obtenerValor(this.value);

        if (valorClave.equals(clave)) {
            return this.value;
        } else if (clave.compareTo(valorClave) < 0) {
            return left.buscar(clave, comparadorBusqueda);
        } else {
            return right.buscar(clave, comparadorBusqueda);
        }
    }

    // Recorridos
    public void inOrderTraversal() {
        if (!isEmpty()) {
            left.inOrderTraversal();
            System.out.println(value);
            right.inOrderTraversal();
        }
    }

    // Método para limpiar el árbol
    public void clear() {
        value = null;
        left = right = this;
    }
}