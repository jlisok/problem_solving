package algorithms.binarytree;

import model.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://www.techiedelight.com/?problem=PreorderTreeTraversal">link</a>
 * <p>
 * <b>preorder traversal</b>
 * <p>
 * level: easy
 * <p>
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
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
 * Output: [1, 2, 4, 3, 5, 7, 8, 6]
 *
 * <p>
 */
public class PreOrderTraversal {

    public List<Integer> findPreorderTraversal(Node root) {
        if (root == null) return Collections.emptyList();

        var result = new ArrayList<Integer>();
        traverse(root, result);

        return result;
    }

    private void traverse(Node node, List<Integer> result) {
        if (node == null) return;

        result.add(node.getValue());

        traverse(node.getLeft(), result);
        traverse(node.getRight(), result);
    }
}
