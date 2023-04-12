package algorithms.binarytree;

import model.Node;

/**
 * <a href="https://www.techiedelight.com/check-children-sum-property-binary-tree/">link</a>
 * <p>
 * <b>Check children-sum property in a binary tree</b>
 * <p>
 * Given the root of a binary tree, determine if the binary tree holds children-sum property. For a tree to satisfy the
 * children-sum property, each node’s value should be equal to the sum of values at its left and right children.
 * The value of an empty node is considered as 0.
 *
 * <p>
 * example:
 * <p>
 */
public class ChildrenSumAlgorithmToDo {

    public boolean isSumOfChildren(Node root) {
        if (root == null) return true;

        return Integer.MIN_VALUE != compute(root);
    }

    private int compute(Node node) {
        var value = node.getValue();
        if (node.getLeft() == null && node.getRight() == null) return value;

        var left = compute(node.getLeft());
        var right = compute(node.getRight());

        return value == left + right
                ? value
                : Integer.MIN_VALUE;
    }
}
