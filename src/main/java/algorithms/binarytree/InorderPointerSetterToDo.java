package algorithms.binarytree;

import io.vavr.Tuple2;
import model.Node;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * <a href="https://www.techiedelight.com/set-next-pointer-inorder-successor-binary-tree/">link</a>
 * <p>
 * <b>Set next pointer to the inorder successor of all nodes in a binary tree</b>
 * <p>
 * Given a binary tree where each node has one extra pointer next, set it to the inorder successor for all binary tree nodes.
 * For example, consider the following tree. Here, the blue dotted line represents the next pointer for each node.
 * <p>
 */
public class InorderPointerSetterToDo {

    Map<Integer, Integer> createNextPointers(Node root) {
        if (root == null) return Collections.emptyMap();

        var successors = new HashMap<Integer, Integer>();
        getPointers(root, successors);

        return successors;
    }

    void getPointers(Node node, Map<Integer, Integer> successors) {
        if (node == null) return;

        getPointers(node.getLeft(), successors);
        var leftSuccessor = printResponse(node.getLeft(), node);
        if (leftSuccessor != null) successors.put(leftSuccessor._1(), leftSuccessor._2());

        getPointers(node.getRight(), successors);
        var rightSuccessor = printResponse(node, node.getRight());
        if (rightSuccessor != null) successors.put(rightSuccessor._1(), rightSuccessor._2());
    }

    private Tuple2<Integer, Integer> printResponse(Node current, Node next) {
        var nextValue = Optional.ofNullable(next)
                .map(Node::getValue)
                .orElse(null);

        return Optional.ofNullable(current)
                .map(n -> current.getValue())
                .map(n -> new Tuple2<>(n, nextValue))
                .orElse(null);
    }

}
