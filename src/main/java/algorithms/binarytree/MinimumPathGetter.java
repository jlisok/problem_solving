package algorithms.binarytree;

import model.Node;
import model.NodeWithDepth;

import java.util.LinkedList;
import java.util.Optional;

/**
 * <a href="https://www.techiedelight.com/find-minimum-depth-binary-tree/">link</a>
 * <p>
 * <b>Find the minimum depth of a binary tree</b>
 * <p>
 * Given a binary tree, find its minimum depth. The minimum depth is the total number of nodes along the shortest
 * path from the root node down to the nearest leaf node.
 */
public class MinimumPathGetter {

    int getMinimumPathBFS(Node root) {
        if (root == null) return -1;

        LinkedList<NodeWithDepth> queue = new LinkedList<>();
        queue.offer(new NodeWithDepth(root, 0));

        NodeWithDepth candidate = null;
        while (!queue.isEmpty()) {

            candidate = queue.remove();

            var node = candidate.getNode();
            var left = node.getLeft();
            var right = node.getRight();

            if (left == null && right == null) break;

            if (left != null) queue.offer(new NodeWithDepth(left, candidate.getDepth() + 1));
            if (right != null) queue.offer(new NodeWithDepth(right, candidate.getDepth() + 1));
        }

        return Optional.ofNullable(candidate)
                .map(NodeWithDepth::getDepth)
                .orElse(-1);
    }


    // not optimal --> always traversing all tree.
    // BFS more optimal --> ends up whilst reaching first leaf
    int getMinimumPathDFS(Node node) {
        if (node == null) return -1;

        return getMinimumRecursive(node);
    }

    int getMinimumRecursive(Node node) {
        if (node == null) return Integer.MAX_VALUE;
        if (node.getLeft() == null && node.getRight() == null) return 0;

        int left = getMinimumRecursive(node.getLeft());
        int right = getMinimumRecursive(node.getRight());

        return Math.min(left, right) + 1;
    }
}
