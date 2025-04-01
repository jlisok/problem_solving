package algorithms.binarytree;

import model.Node;

/**
 * <a href="https://www.techiedelight.com/?problem=TransformBinaryTreeII/">link</a>
 * <p>
 * <b>sum nodes in binary tree</b>
 * <p>
 * level: easy
 * <p>
 * Given the root of a binary tree, in-place replace each node's value to the sum of all elements present in its left
 * and right subtree. You may assume the value of an empty child node to be 0.
 * Input:
 * 	   1
 * 	 /   \
 * 	/	  \
 *    2	   3
 * Output:
 * 	   5
 * 	 /   \
 * 	/	  \
 *    0	   0
 * Input:
 * 	   1
 * 	 /	 \
 * 	/	  \
 *    /	   \
 *   2			3
 *    \	   / \
 * 	\	  /	  \
 * 	 4   5	   6
 * 		/ \
 * 	   /   \
 * 	  7		8
 * Output:
 * 	   35
 * 	 /	  \
 * 	/	   \
 *    /		\
 *   4			26
 *    \	   /  \
 * 	\	  /	   \
 * 	 0   15		0
 * 		/  \
 * 	   /	\
 * 	  0		 0
 */
public class SumProvider {

    public void transform(Node node) {
        if (node == null) return;
        sum(node);
    }

    private int sum(Node node) {
        if (node == null) return 0;

        var leftSum = sum(node.getLeft());
        var rightSum = sum(node.getRight());

        var previous = node.getValue();
        node.setValue(leftSum + rightSum);

        return previous + node.getValue();
    }
}
