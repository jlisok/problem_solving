package model;


public class Node {
    private final int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        var thatNode = (Node) o;
        return checkEquals(thatNode, this);
    }

    private boolean checkEquals(Node node1, Node node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.getValue() != node2.getValue()) return false;

        var leftEqual = checkEquals(node1.getLeft(), node2.getLeft());
        var rightEqual = checkEquals(node1.getRight(), node2.getRight());

        return leftEqual && rightEqual;
    }
}
