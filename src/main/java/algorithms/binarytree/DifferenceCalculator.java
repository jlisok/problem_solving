package algorithms.binarytree;

import model.Node;
import model.NodeWithDepth;

import java.util.ArrayDeque;

/**
 * <a href="https://www.techiedelight.com/?problem=AlternateLevelsSumDifference/">link</a>
 * <p>
 * <b>sum difference between odd and even levels</b>
 * <p>
 * level: easy
 * <p>
 * Given the root of a binary tree, return the difference between the sum of all nodes present at odd levels and the
 * sum of all nodes present at even level.
 * Input:
// * 		   1
 // * 		 /   \
 // * 		/	  \
 // * 	   2	   3
 // * 	  /		  / \
 // * 	 /	  	 /	 \
 // * 	4	  	5	  6
 // * 		   / \
 // * 		  /	  \
 // * 		 7	   8
 * Output: -4
 * Explanation: The difference is (1 + 4 + 5 + 6) - (2 + 3 + 7 + 8) = -4
 * <p>
 */
public class DifferenceCalculator {

    public int findDifference(Node root) {
       if (root == null) return 0;

       var queue = new ArrayDeque<NodeWithDepth>();
        queue.offer(new NodeWithDepth(root, 1));

        int result = 0;
        while (!queue.isEmpty()) {
           var current = queue.poll();
           var level = current.getDepth();
           var node = current.getNode();

           if (level % 2 == 0) result = result - node.getValue();
           if (level % 2 != 0) result = result + node.getValue();

           if (node.getLeft() != null) queue.offer(new NodeWithDepth(node.getLeft(), level + 1));
           if (node.getRight() != null) queue.offer(new NodeWithDepth(node.getRight(), level + 1));
       }

        return result;
    }
}
