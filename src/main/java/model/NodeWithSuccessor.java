package model;


public class NodeWithSuccessor {
    private final int value;
    private NodeWithSuccessor left;
    private NodeWithSuccessor right;
    private NodeWithSuccessor successor;

    public NodeWithSuccessor(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public NodeWithSuccessor(int value, NodeWithSuccessor left, NodeWithSuccessor right, NodeWithSuccessor successor) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.successor = successor;
    }

    public int getValue() {
        return value;
    }

    public NodeWithSuccessor getLeft() {
        return left;
    }

    public NodeWithSuccessor getRight() {
        return right;
    }

    public void setLeft(NodeWithSuccessor left) {
        this.left = left;
    }

    public void setRight(NodeWithSuccessor right) {
        this.right = right;
    }

    public NodeWithSuccessor getSuccessor() {
        return successor;
    }

    public void setSuccessor(NodeWithSuccessor successor) {
        this.successor = successor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        var thatNode = (NodeWithSuccessor) o;
        return checkEquals(thatNode, this);
    }

    private boolean checkEquals(NodeWithSuccessor node1, NodeWithSuccessor node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.getValue() != node2.getValue()) return false;

        var leftEqual = checkEquals(node1.getLeft(), node2.getLeft());
        var rightEqual = checkEquals(node1.getRight(), node2.getRight());
        var successorEqual = checkEquals(node1.getSuccessor(), node2.getSuccessor());

        return leftEqual && rightEqual && successorEqual;
    }
}
