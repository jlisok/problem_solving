package algorithms.binarytree;

import model.Node;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://www.techiedelight.com/?problem=RootToLeafPathsInBinaryTree/">link</a>
 * <p>
 * <b>paths from root to leafs</b>
 * <p>
 * level: easy
 * <p>
 * Given the root of a binary tree, return all paths from the root node to every leaf node in the binary tree.
 * Input:
 * 1
 * /   \
 * /		 \
 * 2		  3
 * /  \		 /  \
 * /	  \		/	 \
 * 4	   5   6	  7
 * /		   \
 * /			\
 * 8			 9
 * Output: {[1, 2, 4], [1, 2, 5], [1, 3, 6, 8], [1, 3, 7, 9]}
 * Explanation: The binary tree has four root-to-leaf paths:
 * 1 —> 2 —> 4
 * 1 —> 2 —> 5
 * 1 —> 3 —> 6 —> 8
 * 1 —> 3 —> 7 —> 9
 */
public class RootToLeafPathsPrinter {

    public Set<List<Integer>> findRootToLeafPaths(Node root) {
        if (root == null) return Collections.emptySet();
        return getPath(root);
    }

    private Set<List<Integer>> getPath(Node node) {
        if (node == null) return HashSet.newHashSet(0);
        if (isLeaf(node)) return initPath(node.getValue());

        var left = getPath(node.getLeft());
        var right = getPath(node.getRight());

        left.addAll(right);
        left.forEach(item -> item.addFirst(node.getValue()));

        return left;
    }

    private boolean isLeaf(Node node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    private Set<List<Integer>> initPath(Integer value) {
        var initList = new LinkedList<Integer>();
        initList.addLast(value);

        var initSet = new HashSet<List<Integer>>();
        initSet.add(initList);
        return initSet;
    }
}
