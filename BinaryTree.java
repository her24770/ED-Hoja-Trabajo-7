public class BinaryTree<T> {

    protected T value;
    protected BinaryTree<T> parent;
    protected BinaryTree<T> left, right;

    // Constructor para un nodo vacío
    public BinaryTree() {
        value = null;
        parent = null;
        left = right = this;
    }

    // Constructor para un nodo con valor
    public BinaryTree(T val) {
        value = val;
        right = left = new BinaryTree<>();
        setLeft(left);
        setRight(right);
    }

    // Constructor para un nodo con valor y subárboles izquierdo y derecho
    public BinaryTree(T val, BinaryTree<T> left, BinaryTree<T> right) {
        value = val;
        if (left == null) {
            left = new BinaryTree<>();
        }
        setLeft(left);
        if (right == null) {
            right = new BinaryTree<>();
        }
        setRight(right);
    }

    // Método para obtener el subárbol izquierdo
    public BinaryTree<T> getLeft() {
        return left;
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    // Método para obtener el padre del nodo
    public BinaryTree<T> getParent() {
        return parent;
    }

    // Método para establecer el subárbol izquierdo
    public void setLeft(BinaryTree<T> newLeft) {
        if (isEmpty()) return;
        if (left != null && left.getParent() == this) {
            left.setParent(null);
        }
        left = newLeft;
        left.setParent(this);
    }

    // Método para establecer el subárbol derecho
    public void setRight(BinaryTree<T> newRight) {
        if (isEmpty()) return;
        if (right != null && right.getParent() == this) {
            right.setParent(null);
        }
        right = newRight;
        right.setParent(this);
    }

    // Método para establecer el padre del nodo
    protected void setParent(BinaryTree<T> newParent) {
        if (!isEmpty()) {
            parent = newParent;
        }
    }

    // Método para verificar si el nodo está vacío
    public boolean isEmpty() {
        return value == null;
    }

    // Método para obtener el valor del nodo
    public T getValue() {
        return value;
    }

    // Método para establecer el valor del nodo
    public void setValue(T val) {
        value = val;
    }

    // Método para verificar si el nodo es un hijo izquierdo
    public boolean isLeftChild() {
        if (parent == null) {
            return false;
        }
        return this == parent.getLeft();
    }

    // Método para recorrer el árbol en orden (in-order traversal)
    public void inOrderTraversal() {
        if (!isEmpty()) {
            left.inOrderTraversal();
            System.out.println(value);
            right.inOrderTraversal();
        }
    }

    // Método para insertar un valor en el árbol (BST-style)
    public void insert(T val) {
        if (isEmpty()) {
            value = val;
            left = new BinaryTree<>();
            right = new BinaryTree<>();
        } else if (((Comparable<T>) val).compareTo(val) < 0) {
            left.insert(value);
        } else {
            right.insert(value);
        }
    }
}