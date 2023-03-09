package algorithms.binarytree;

import model.Node;

/**
 * <a href="https://www.techiedelight.com/invert-binary-tree-recursive-iterative/">link</a>
 * <p>
 * <b>Invert Binary Tree – Iterative and Recursive Solution</b>
 * <p>
 * Given a binary tree, write an efficient algorithm to invert it.
 * <p>
 */
public class BTreeInverter {

    Node invert(Node node) {
        if (node == null) return null;

        var right = invert(node.getLeft());
        var left = invert(node.getRight());

        return new Node(node.getValue(), left, right);
    }
}
