package model;

public class NodeWithDepth {
    private final Node node;
    private final int depth;

    public NodeWithDepth(Node node, int depth) {
        this.node = node;
        this.depth = depth;
    }

    public Node getNode() {
        return node;
    }

    public int getDepth() {
        return depth;
    }
}
