package algorithms.binarytree;

import model.Node;

import java.util.ArrayDeque;

/**
 * <a href="https://www.techiedelight.com/?problem=MaximumWidthBinaryTree/">link</a>
 * <p>
 * <b>find maximum width of a binary tree</b>
 * <p>
 * level: easy
 * <p>
 * Given the root of a binary tree, return the maximum number of nodes at any level in the binary tree.
 * Input:
 * 		   1
 * 		 /   \
 * 		/	  \
 * 	   2	   3
 * 	  /	\	  / \
 * 	 /	 \ 	 /	 \
 * 	4	  5	6	  7
 *
 * Output: 4
 *
 * Input:
 * 		   1
 * 		  /
 * 		 /
 * 		2
 * 	   /
 * 	  /
 * 	 3
 * 	/
 *    /
 *   4
 *
 * Output: 1
 */
public class MaximumWidthBinaryTreeFinder {

    public int findMaximumWidth(Node root) {
        int max = 0;
        if (root == null) return max;

        var queue = new ArrayDeque<Node>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > max) max = size;

            while (size > 0) {

                Node current = queue.poll();
                if (current.getLeft() != null) queue.offer(current.getLeft());
                if (current.getRight() != null) queue.offer(current.getRight());
                size--;
            }
        }

        return max;
    }
}
