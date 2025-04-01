package algorithms.binarytree;

import model.Node;

/**
 * <a href="https://www.techiedelight.com/?problem=MirrorOfBinaryTree/">link</a>
 * <p>
 * <b>mirror binary tree in an in-place manner</b>
 * <p>
 * level: easy
 * Given the root of a binary tree, convert the binary tree into its mirror.
 *
 * Input:
 * 		   1
 * 		 /   \
 * 		/	  \
 * 	   2	   3
 * 	  / \	  / \
 * 	 /	 \	 /	 \
 * 	4	  5	6	  7
 *
 * Output:
 *
 * 		   1
 * 		 /   \
 * 		/	  \
 * 	   3	   2
 * 	  / \	  / \
 * 	 /	 \	 /	 \
 * 	7	  6	5	  4
 *
 * Explanation:
 * 						|
 * 						|
 * 		   1			|		   1
 * 		 /   \			|		 /   \
 * 		/	  \			|		/	  \
 * 	   2	   3		|	   3	   2
 * 	  / \	  / \		|	  / \	  / \
 * 	 /	 \	 /	 \		|	 /	 \	 /	 \
 * 	4	  5	6	  7		|	7	  6	5	  4
 * 						|
 */
public class MirrorConverter {

    public void convert(Node node) {
        if (node == null) return;
        if (node.getLeft() == null && node.getRight() == null) return;

        var left = node.getLeft();
        var right = node.getRight();
        node.setLeft(right);
        node.setRight(left);

        convert(left);
        convert(right);
    }
}
