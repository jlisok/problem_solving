package algorithms.binarytree;

import model.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * <a href="https://www.techiedelight.com/?problem=LeftViewBinaryTree/">link</a>
 * <p>
 * <b>Left view binary tree</b>
 * <p>
 * level: easy
 * <p>
 * Given the root of a binary tree, return the left view of its nodes' values. Assume the left and right child of a
 * node makes a 45–degree angle with the parent.
 * <p>
 * Input:
 * 		   1
 * 		 /	 \
 * 		/	  \
 * 	   2	   3
 * 	  		 /   \
 * 	 	  	/	  \
 * 		   5	   6
 * 		 /   \
 * 		/	  \
 * 	   7	   8
 * <p>
 * Output: [1, 2, 5, 7]
 * <p>
 * Input:
 * <p>
 * 	  1
 * 	/   \
 *    /	 \
 *   2		  3
 *    \	 /
 * 	\   /
 * 	 4 5
 * <p>
 * Output: [1, 2, 4]
 */
public class LeftViewBinaryTree {

    public List<Integer> findLeftView(Node root) {
        if (root == null) return Collections.emptyList();

        var resultMap = new TreeMap<Integer, Integer>();
        traverse(root, 0, resultMap);

        return new ArrayList<>(resultMap.values());
    }

    private void traverse(Node node, int level, TreeMap<Integer, Integer> results) {
        if (node == null) return;

        results.putIfAbsent(level, node.getValue());
        traverse(node.getLeft(), level+1, results);
        traverse(node.getRight(), level+1, results);
    }
}
