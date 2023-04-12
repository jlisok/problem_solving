package algorithms.binarytree;

import model.Node;

/**
 * Basic binary search tree implementation
 * <p>
 * operacja dodawania odbywa się tylko na liściach drzewa binarnego;
 * drzewo binarne nie jest współbieżne
 */
public class BinarySearchTreeImplToDo {
    private Node root;

    public BinarySearchTreeImplToDo(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public Node search(int value) {
        return recursionSearch(root, value);
    }

    private Node recursionSearch(Node current, int value) {
        if (current == null) return null;

        var key = current.getValue();
        if (key > value) return recursionSearch(current.getLeft(), value);
        if (key < value) return recursionSearch(current.getRight(), value);

        return current;
    }


    public boolean add(int value) {
        if (root == null) {
            root = new Node(value);
            return true;
        }

        return addRecursive(root, value);
    }

    private boolean addRecursive(Node node, int value) {
        if (node.getValue() == value) return true;

        boolean added = false;

        if (value > node.getValue()) {

            if (node.getRight() == null) {
                var newNode = new Node(value);
                node.setRight(newNode);

                return true;
            }

            added = addRecursive(node.getRight(), value);

        }

        if (value < node.getValue()) {

            if (node.getLeft() != null) {
                var newNode = new Node(value);
                node.setLeft(newNode);

                return true;
            }

            added = addRecursive(node.getLeft(), value);
        }

        return added;
    }


    public boolean remove(int value) {
        return false;
    }
}
