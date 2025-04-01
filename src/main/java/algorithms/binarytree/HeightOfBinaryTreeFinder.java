package algorithms.binarytree;

import model.Node;

/**
 * <a href="https://www.techiedelight.com/?problem=HeightOfBinaryTree/">link</a>
 * <p>
 * <b>find height of binary tree</b>
 * <p>
 * level: easy
 * <p>
 * <p>
 * Given the root of a binary tree, return the binary tree's height. The height of the binary tree is the total number
 * of edges or nodes on the longest path from the root node to the leaf node.
 * <p>
 * The solution should consider the total number of nodes in the longest path. For example, an empty tree's height is 0,
 * and the tree's height with only one node is 1.
 * <p>
 * Input:
 * Input:
 * 		   1
 * 		 /   \
 * 		/	  \
 * 	   2	   3
 * 	  /	\	  / \
 * 	 /	 \ 	 /	 \
 * 	4	  5	6	  7
 * <p>
 * Output: 3
 * <p>
 * <p>
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
 * <p>
 * Output: 4
 */
public class HeightOfBinaryTreeFinder {

    public int findHeight(Node node) {
        if (node == null) return 0;

        int leftHeight = findHeight(node.getLeft()) + 1;
        int rightHeight = findHeight(node.getRight()) + 1;

        return Math.max(leftHeight, rightHeight);
    }
}
