package algorithms.binarytree;

import model.Node;

/**
 * <a href="https://www.techiedelight.com/clone-binary-tree/">link</a>
 * <p>
 * <b>Clone a Binary Tree</b>
 * <p>
 * Given a binary tree, efficiently create copy of it.
 */
public class TreeCloneProvider {

    Node clone(Node node) {
        if (node == null) return null;

        var left = clone(node.getLeft());
        var right = clone(node.getRight());

        return new Node(node.getValue(), left, right);
    }
}
