package model;


import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private final int value;
    private List<TreeNode> children;

    public TreeNode(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public TreeNode(int value, List<TreeNode> children) {
        this.value = value;
        this.children = children;
    }

    public int getValue() {
        return value;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        var thatNode = (TreeNode) o;
        return checkEquals(thatNode, this);
    }

    private boolean checkEquals(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.getValue() != node2.getValue()) return false;
        if (node1.getChildren().size() != node2.getChildren().size()) return false;

        var size = node1.getChildren().size();
        boolean equals = true;
        int i = 0;

        while (equals && i < size) {
            equals = checkEquals(node1.getChildren().get(i), node2.getChildren().get(i));
            i++;
        }

        return equals;
    }
}
