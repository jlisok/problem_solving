package algorithms.binarytree;

import model.Node;

/**
 * <a href="https://www.techiedelight.com/determine-binary-tree-can-converted-another-number-swaps-left-right-child/">link</a>
 * <p>
 * <b>Determine if a binary tree can be converted to another by doing any number of swaps of children</b>
 * <p>
 * Given a binary tree, write an efficient algorithm to determine if it can be converted into another binary tree by
 * doing any number of swaps of its right and left branches. For example, consider a binary tree shown on the left below.
 * It can be converted into a binary tree shown on the right by few swaps of its right and left branches.
 * <p>
 */
public class BTreeSwapComparator {

    boolean swapAndCompare(Node node1, Node node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;

        var leftEquals = swapAndCompare(node1.getLeft(), node2.getLeft());
        var rightEquals = swapAndCompare(node1.getRight(), node2.getRight());
        var valuesEqual = node1.getValue() == node2.getValue();

        if (leftEquals && rightEquals && valuesEqual) return true;

        var leftSwappedEquals = swapAndCompare(node1.getLeft(), node2.getRight());
        var rightSwappedEquals = swapAndCompare(node1.getRight(), node2.getLeft());

        return valuesEqual && leftSwappedEquals && rightSwappedEquals;
    }
}
