package algorithms.binarytree;

import model.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://www.techiedelight.com/?problem=PostorderTreeTraversal">link</a>
 * <p>
 * <b>postorder traversal</b>
 * <p>
 * level: easy
 * <p>
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [4, 2, 7, 8, 5, 6, 3, 1]
 *
 * <p>
 */
public class PostOrderTraversal {

    public List<Integer> findPostorderTraversal(Node root) {
        if (root == null) return Collections.emptyList();

        var result = new ArrayList<Integer>();
        traverse(root, result);

        return result;
    }

    private void traverse(Node node, List<Integer> result) {
        if (node == null) return;

        traverse(node.getLeft(), result);
        traverse(node.getRight(), result);

        result.add(node.getValue());
    }
}
