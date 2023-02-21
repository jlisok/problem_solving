package model;


import java.util.Objects;

public class CharNode {
    private final char value;
    private CharNode left;
    private CharNode right;

    public CharNode(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public CharNode(char value, CharNode left, CharNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public char getValue() {
        return value;
    }

    public CharNode getLeft() {
        return left;
    }

    public CharNode getRight() {
        return right;
    }

    public void setLeft(CharNode left) {
        this.left = left;
    }

    public void setRight(CharNode right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        var thatNode = (CharNode) o;
        return checkEquals(thatNode, this);
    }

    private boolean checkEquals(CharNode node1, CharNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (!Objects.equals(node1.getValue(), node2.getValue())) return false;

        var leftEqual = checkEquals(node1.getLeft(), node2.getLeft());
        var rightEqual = checkEquals(node1.getRight(), node2.getRight());

        return leftEqual && rightEqual;
    }
}
