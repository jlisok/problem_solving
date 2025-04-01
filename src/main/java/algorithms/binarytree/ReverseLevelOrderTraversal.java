package algorithms.binarytree;

import model.Node;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://www.techiedelight.com/?problem=ReverseLevelOrderTraversal/">link</a>
 * <p>
 * <b>reverse level order traversal</b>
 * <p>
 * level: easy
 * <p>
 * Given the root of a binary tree, return the reverse level order traversal of its nodes' values. The solution should
 * consider the binary tree nodes level by level in bottom-up order from left to right, i.e., process all nodes of the
 * last level first, followed by all nodes of the second last level, and so on.
 * Input:
 * 		   1
 * 		 /   \
 * 		/	  \
 * 	   2	   3
 * 	  /		  / \
 * 	 /	  	 /	 \
 * 	4		5	  6
 * 		   / \
 * 		  /   \
 * 		 7	   8
 * Output: [7, 8, 4, 5, 6, 2, 3, 1]
 */
public class ReverseLevelOrderTraversal {

    public List<Integer> findReverseLevelOrderTraversal(Node root) {
        if (root == null) return Collections.emptyList();

        var queue = new ArrayDeque<Node>();
        var stack = new LinkedList<Integer>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            var current = queue.poll();
            stack.push(current.getValue());

            if (current.getRight() != null) queue.offer(current.getRight());
            if (current.getLeft() != null) queue.offer(current.getLeft());
        }

        return stack;
    }
}
