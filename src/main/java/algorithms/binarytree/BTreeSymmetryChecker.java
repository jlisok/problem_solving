package algorithms.binarytree;

import model.Node;

/**
 * <a href="https://www.techiedelight.com/check-given-binary-tree-symmetric-structure-not/">link</a>
 * <p>
 * <b>Check if a binary tree is symmetric or not</b>
 * <p>
 * Given a binary tree, write an efficient algorithm to check if it has a symmetric structure
 * or not, i.e., left and right subtree mirror each other.
 * <p>
 */
public class BTreeSymmetryChecker {

    boolean check(Node root) {
        if (root == null) return true;

        return isSymmetric(root.getLeft(), root.getRight());
    }

    private boolean isSymmetric(Node left, Node right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        var outerSymmetric = isSymmetric(left.getLeft(), right.getRight());
        var innerSymmetric = isSymmetric(left.getRight(), right.getLeft());

        return outerSymmetric && innerSymmetric;
    }
}
