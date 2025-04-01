package algorithms.binarytree;

import model.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://www.techiedelight.com/?problem=InorderTreeTraversal/">link</a>
 * <p>
 * <b>inorder traversal</b>
 * <p>
 * level: easy
 * <p>
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
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
 * Output: [4, 2, 1, 7, 5, 8, 3, 6]
 *
 * <p>
 */
public class InOrderTraversal {

    public List<Integer> findInorderTraversal(Node root) {
        if (root == null) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();
        traverse(root, result);

        return result;
    }

    private void traverse(Node node, List<Integer> result) {
        if (node == null) return;

        traverse(node.getLeft(), result);
        result.add(node.getValue());
        traverse(node.getRight(), result);
    }
}
