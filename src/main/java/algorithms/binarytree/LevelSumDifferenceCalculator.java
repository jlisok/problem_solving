package algorithms.binarytree;

import model.Node;
import model.NodeWithDepth;

import java.util.LinkedList;

/**
 * <a href="https://www.techiedelight.com/difference-between-sum-nodes-odd-even-levels/">link</a>
 * <p>
 * <b>Find difference between sum of all nodes present at odd and even levels in a binary tree</b>
 * <p>
 * Given a binary tree, calculate the difference between the sum of all nodes present at odd levels
 * and the sum of all nodes present at even level.
 * <p>
 * For example, consider the following binary tree. The required difference is:
 * <p>
 * (1 + 4 + 5 + 6) - (2 + 3 + 7 + 8) = -4
 */
public class LevelSumDifferenceCalculator {
    private static final int ROOT_LEVEL = 1;

    Integer calculate(Node root) {
        if (root == null) return null;

        var queue = new LinkedList<NodeWithDepth>();
        queue.add(new NodeWithDepth(root, ROOT_LEVEL));

        var oddSum = 0;
        var evenSum = 0;
        while (!queue.isEmpty()) {

            var current = queue.poll();
            var node = current.getNode();
            var level = current.getDepth();

            addToQueue(queue, node.getLeft(), level + 1);
            addToQueue(queue, node.getRight(), level + 1);

            if (level % 2 == 0) {
                evenSum = evenSum + node.getValue();
            } else {
                oddSum = oddSum + node.getValue();
            }
        }

        return oddSum - evenSum;
    }

    private void addToQueue(LinkedList<NodeWithDepth> queue, Node node, int level) {
        if (node != null) queue.add(new NodeWithDepth(node, level));
    }
}
