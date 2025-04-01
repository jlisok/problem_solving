package algorithms.binarytree;

import model.Node;

/**
 * <a href="https://www.techiedelight.com/?problem=TransformBinaryTree/">link</a>
 * <p>
 * <b>check if two binary trees can be transformed into one another</b>
 * <p>
 * level: easy
 * <p>
 * Given root of two binary trees, x and y, determine if x can be converted into y by doing any number of swaps of its
 * right and left branches. Two binary trees are identical if they have identical structure and same nodes' values.
 * Input: Two binary trees
 * 				6
 * 			  /   \
 * 			/		\
 * 		  /			  \
 * 		 3			   8
 * 		/ \			  / \
 * 	   /   \		 /   \
 * 	  1		7		4	  2
 * 				   / \	   \
 * 				  /   \		\
 * 				 7	   1	 3
 * <p>
 * 				6
 * 			  /   \
 * 			/		\
 * 		  /			  \
 * 		 8			   3
 * 		/ \			  / \
 * 	   /   \		 /   \
 * 	  2		4		7	  1
 * 	 /	   / \
 * 	/	  /	  \
 *    3	 1	   7
 * Output: true
 */
public class TransformChecker {

    public boolean check(Node node1, Node node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null) return false;
        if (node2 == null) return false;
        if (node1.getValue() != node2.getValue()) return false;

        var equal = check(node1.getLeft(), node2.getLeft()) && check(node1.getRight(), node2.getRight());
        var transformedEqual = check(node1.getLeft(), node2.getRight()) && check(node1.getRight(), node2.getLeft());

        return equal || transformedEqual;
    }
}
