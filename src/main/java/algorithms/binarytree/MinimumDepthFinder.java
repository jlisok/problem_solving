package algorithms.binarytree;

import model.Node;
import model.NodeWithDepth;

import java.util.ArrayDeque;

/**
 * <a href="https://www.techiedelight.com/?problem=MinimumDepthBinaryTree/">link</a>
 * <p>
 * <b>find minimum depth of a binary tree</b>
 * <p>
 * level: easy
 * <p>
 * Given the root of a binary tree, return the minimum depth of the binary tree. The minimum depth is the total number of nodes along the shortest path in binary tree from the root node down to the nearest leaf node.
 * Input:
 * 				1
 * 			  /   \
 * 			/		\
 * 		  /			  \
 * 		 2			   3
 * 	   /   \		 /   \
 * 	  /		\		/	  \
 * 	 4		 5	   6	   7
 * 	  \		  \			  / \
 * 	   \	   \		 /   \
 * 		8		9		10	 11
 * 		 \
 * 		  \
 * 		  12
 * Output: 3
 * Explanation: The shortest path is 1 —> 3 —> 6.
 */
public class MinimumDepthFinder {

    public int find(Node root) {
        if (root == null) return 0;

        var queue = new ArrayDeque<NodeWithDepth>();
        queue.offer(new NodeWithDepth(root, 1));

        while (!queue.isEmpty()) {
                var current = queue.poll();

                var node = current.getNode();
                var depth = current.getDepth();
                var left = node.getLeft();
                var right = node.getRight();

                if (left == null && right == null) return depth;
                if (left != null) queue.offer(new NodeWithDepth(left, depth + 1));
                if (right != null) queue.offer(new NodeWithDepth(right, depth + 1));
            }

        return 0;
    }
}
