package algorithms.binarytree;

import model.techiedelight.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://www.techiedelight.com/?problem=SpiralOrderTraversal/">link</a>
 * <p>
 * <b>Spiral Order traversal</b>
 * <p>
 * level: medium
 * <p>
 * Given the root of a binary tree, return the spiral level order traversal of its nodes' values. The solution
 * should consider the binary tree nodes level by level in spiral order, i.e., all nodes present at level 1
 * should be processed first from left to right, followed by nodes of level 2 from right to left, followed by nodes of
 * level 3 from left to right and so on… In other words, odd levels should be processed from left to right, and even
 * levels should be processed from right to left.
 * Input:
 * // * 		   1
 * // * 		 /   \
 * // * 		/	  \
 * // * 	   2	   3
 * // * 	  /		  / \
 * // * 	 /	  	 /	 \
 * // * 	4		5	  6
 * // * 		   / \
 * // * 		  /   \
 * // * 		 7	   8
 * Output: [1, 3, 2, 4, 5, 6, 8, 7]
 * <p>
 */
public class SpiralOrderTraversal {

    public List<Integer> traverse(Node root) {
        if (root == null) return Collections.emptyList();

        var result = new ArrayList<Integer>();
        var queue = new LinkedList<Node>();
        queue.addLast(root);
        int level = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            while (levelSize > 0) {
                var data = isEven(level) ? processEvenLevel(queue) : processOddLevel(queue);
                result.add(data);
                levelSize = levelSize - 1;
            }
            level = level + 1;
        }
        return result;
    }

    private boolean isEven(int level) {
        return level % 2 == 0;
    }

    private int processOddLevel(LinkedList<Node> queue) {
        var node = queue.pollLast();

        if (node.left != null) queue.offerFirst(node.left);
        if (node.right != null) queue.offerFirst(node.right);

        return node.data;
    }

    private int processEvenLevel(LinkedList<Node> queue) {
        var node = queue.pollFirst();

        if (node.right != null) queue.offerLast(node.right);
        if (node.left != null) queue.offerLast(node.left);

        return node.data;
    }
}
