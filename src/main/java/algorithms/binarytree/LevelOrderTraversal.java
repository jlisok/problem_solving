package algorithms.binarytree;

import model.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://www.techiedelight.com/?problem=LevelOrderTraversal/">link</a>
 * <p>
 * <b>level order traversal</b>
 * <p>
 * level: easy
 * <p>
 * Given the root of a binary tree, return the level order traversal of its nodes' values. The solution should consider
 * the binary tree nodes level by level from left to right, i.e., process all nodes of level 1 first, followed by all
 * nodes of level 2, and so on.
 * Input:
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
 * Output: [1, 2, 3, 4, 5, 6, 7, 8]
 */
public class LevelOrderTraversal {

    public List<Integer> findLevelOrderTraversal(Node root) {
        if (root == null) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();
        var fifo = new ArrayDeque<Node>();
        fifo.offer(root);

        while (!fifo.isEmpty()) {
            var current = fifo.poll();

            result.add(current.getValue());
            if (current.getLeft() != null) fifo.offer(current.getLeft());
            if (current.getRight() != null) fifo.offer(current.getRight());
        }

        return result;
    }
}
