package algorithms.binarytree;

import model.Node;

/**
 * <a href="https://www.techiedelight.com/split-binary-tree-into-two-trees/">link</a>
 * <p>
 * <b>Check if removing an edge can split a binary tree into two equal size trees</b>
 * <p>
 * OP is somehow not very precise in the description. What they really meant was the algorithm that checks whether a tree can
 * split into tree into 2 even subtrees. The output for this algorithm is boolean. No input of some `edge` is required.
 * Anyway, the following text quotes the `original` content:
 * <p>
 * Given a binary tree, check if removing an edge can split it into two binary trees of equal size.
 * <p>
 * For example, removing the edge 1 —> 2 from a binary tree on the left below splits it into two binary trees of size 3.
 * However, there is no edge whose removal splits the binary tree on the right into two equal-size binary trees.
 * <p>
 * example:
 * <p>
 */
public class SplitToSubtreesChecker {

    boolean check(Node root) {
        if (root == null) return false;

        int count = checkRecursive(root);
        return count % 2 == 0;
    }

    private int checkRecursive(Node node) {
        if (node == null) return 0;

        int left = checkRecursive(node.getLeft());
        int right = checkRecursive(node.getRight());

        return left + right + 1;
    }
}
