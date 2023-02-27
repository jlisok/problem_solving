package algorithms.binarytree;

import model.Node;
import model.NodeWithDepth;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * <a href="https://www.techiedelight.com/find-maximum-width-given-binary-tree/">link</a>
 * <p>
 * <b>Compute the maximum number of nodes at any level in a binary tree</b>
 * <p>
 * Given a binary tree, write an efficient algorithm to compute the maximum number of nodes in any level in the
 * binary tree.
 * <p>
 * this instruction sucks. Please refer to examples on the website.
 */
public class MaxNodesFinder {
    private static final int ROOT_LEVEL = 1;
    private static final int INITIAL_LEVEL_COUNT = 0;

    Integer getMax(Node root) {
        if (root == null) return null;

        var queue = new LinkedList<NodeWithDepth>();
        queue.add(new NodeWithDepth(root, ROOT_LEVEL));
        var nodeCountByLevel = new HashMap<Integer, Integer>();
        var max = -1;

        while (!queue.isEmpty()) {

            var current = queue.poll();
            var node = current.getNode();
            var level = current.getDepth();

            addToQueue(queue, node.getLeft(), level + 1);
            addToQueue(queue, node.getRight(), level + 1);

            var count = nodeCountByLevel.getOrDefault(level, INITIAL_LEVEL_COUNT) + 1;
            nodeCountByLevel.put(level, count);

            if (max < count) max = count;
        }

        return max;
    }

    private void addToQueue(LinkedList<NodeWithDepth> queue, Node node, int level) {
        if (node != null) queue.add(new NodeWithDepth(node, level));
    }
}
