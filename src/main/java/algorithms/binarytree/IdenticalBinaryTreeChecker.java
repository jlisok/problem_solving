package algorithms.binarytree;

import model.Node;

/**
 * <a href="https://www.techiedelight.com/?problem=CheckIdenticalBinaryTrees/">link</a>
 * <p>
 * <b>check identical binary tree</b>
 * <p>
 * level: easy
 * <p>
 * Given the root of two binary trees, x and y, check if x is identical to y. Two binary trees are identical if they
 * have identical structure and their contents are also the same.
 * Input:
 * 		   1						1
 * 		 /   \					  /   \
 * 		/	  \					 /	   \
 * 	   2	   3				2		3
 * 	  /	\	  / \			   / \	   / \
 * 	 /	 \ 	 /	 \			  /	  \	  /	  \
 * 	4	  5	6	  7			 4	   5 6	   7
 * Output: true
 * Explanation: Both binary trees have the same structure and contents.
 * Input:
 * 		   1						1
 * 		 /   \					  /   \
 * 		/	  \					 /	   \
 * 	   2	   3				2		3
 * 	  /	\	  / \			   / \	   /
 * 	 /	 \ 	 /	 \			  /	  \	  /
 * 	4	  5	6	  7			 4	   5 6
 * Output: false
 * Explanation: Both binary trees have different structures.
 * Input:
 * 		   1						1
 * 		 /   \					  /   \
 * 		/	  \					 /	   \
 * 	   2	   3				2		3
 * 	  /	\	  / \			   / \	   / \
 * 	 /	 \ 	 /	 \			  /	  \	  /	  \
 * 	4	  5	6	  7			 4	   5 6	   8
 * Output: false
 * Explanation: Both binary trees have the same structure but differ in nodes' values.
 */
public class IdenticalBinaryTreeChecker {

    public boolean isIdentical(Node node1, Node node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.getValue() != node2.getValue()) return false;

        boolean leftEqual = isIdentical(node1.getLeft(), node2.getLeft());
        boolean rightEqual = isIdentical(node1.getRight(), node2.getRight());

        return leftEqual && rightEqual;
    }
}
