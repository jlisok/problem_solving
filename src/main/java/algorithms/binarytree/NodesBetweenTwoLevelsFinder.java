package algorithms.binarytree;

import model.Node;
import model.NodeWithDepth;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://www.techiedelight.com/?problem=NodesBetweenTwoLevels/">link</a>
 * <p>
 * <b>find nodes between two levels</b>
 * <p>
 * level: easy
 * <p>
 * Given the root of a binary tree and two positive numbers m and n where m >= n, return values of all nodes between
 * level m and level n. The nodes for each level should be processed from left and right.
 * Input: Below binary tree, m = 2, n = 3
 * 		   1
 * 		 /   \
 * 		/	  \
 * 	   2	   3
 * 			  / \
 * 			 /	 \
 * 			4	  5
 * 		   / \	   \
 * 		  /   \		\
 * 		 6	   7	 8
 * Output: [2, 3, 4, 5]
 * Note: If n is more than the number of levels in the binary tree, the solution return nodes till last level.
 * For example, if the starting level is 2 and the ending level is 7, the solution should return [2, 3, 4, 5, 6, 7, 8] for above binary tree.
 */
public class NodesBetweenTwoLevelsFinder {

    public List<Integer> findNodes(Node root, int min, int max) {
        if (root == null) return Collections.emptyList();
        if (max < min) return Collections.emptyList();

       var queue = new ArrayDeque<NodeWithDepth>();
       queue.offer(new NodeWithDepth(root, 1));

       var result = new ArrayList<Integer>();

       while (!queue.isEmpty()) {
           var current = queue.poll();
           var depth = current.getDepth();
           var node = current.getNode();

           if (depth > max) break;
           if (depth >= min) result.add(node.getValue());

           if (node.getLeft() != null) queue.offer(new NodeWithDepth(node.getLeft(), depth + 1));
           if (node.getRight() != null) queue.offer(new NodeWithDepth(node.getRight(), depth + 1));
       }

       return result;
    }
}
