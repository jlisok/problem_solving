package algorithms.binarytree;

import model.Node;

/**
 * <a href="https://www.techiedelight.com/check-skewed-binary-tree/">link</a>
 * <p>
 * <b>Check if each node of a binary tree has exactly one child</b>
 * <p>
 * Given a binary tree, check if each node has exactly one child or not. In other words,
 * check whether the binary tree is skewed or not.
 */
public class SkewnessVerifier {

    boolean isSkewed(Node root) {
        if (root == null) return false;

        return checkSkewed(root);
    }

    private boolean checkSkewed(Node node) {
        if (node == null) return true;
        if (node.getLeft() != null && node.getRight() != null) return false;

        boolean left = checkSkewed(node.getLeft());
        boolean right = checkSkewed(node.getRight());

        return left && right;
    }
}
