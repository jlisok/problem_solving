package model.techiedelight;


public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public static Node ofStructure(int data, int left, int right) {
        return new Node(data, new Node(left), new Node(right));
    }
}
