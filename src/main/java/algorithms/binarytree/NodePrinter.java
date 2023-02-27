package algorithms.binarytree;

import model.Node;
import model.NodeWithDepth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://www.techiedelight.com/print-nodes-between-two-levels-binary-tree/">link</a>
 * <p>
 * <b>Efficiently print all nodes between two given levels in a binary tree</b>
 * <p>
 * Given a binary tree, efficiently print all nodes in it between two given levels.
 * The nodes for any level should be printed from left and right.
 * <p>
 */
public class NodePrinter {
    private static final int ROOT_LEVEL = 1;

    List<Integer> print(Node root, int fromInclusive, int toInclusive) {
        if (root == null) return Collections.emptyList();
        if (fromInclusive > toInclusive) return Collections.emptyList();

        var queue = new LinkedList<NodeWithDepth>();
        var result = new ArrayList<Integer>();

        queue.add(new NodeWithDepth(root, ROOT_LEVEL));

        while (!queue.isEmpty()) {

            var current = queue.poll();
            var node = current.getNode();
            var level = current.getDepth();

            addToQueue(queue, node.getLeft(), level + 1, toInclusive);
            addToQueue(queue, node.getRight(), level + 1, toInclusive);

            if (level >= fromInclusive && level <= toInclusive) result.add(node.getValue());
        }

        return result;
    }

    private void addToQueue(LinkedList<NodeWithDepth> queue, Node node, int level, int to) {
        if (node != null && level <= to) queue.add(new NodeWithDepth(node, level));
    }
}
