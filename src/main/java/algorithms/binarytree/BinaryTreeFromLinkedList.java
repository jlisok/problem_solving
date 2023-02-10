package algorithms.binarytree;

import model.Node;

import java.util.LinkedList;
import java.util.function.Consumer;

/**
 * https://www.techiedelight.com/construct-complete-binary-tree-from-linked-list/
 * <p>
 * <b>Construct a complete binary tree from its linked list representation</b>
 * <p>
 * Given a linked list, construct a complete binary tree from it. Assume that the order of elements present in the
 * linked list is the same as that in the complete tree’s array representation.
 * <p>
 * For a tree node at position i in the linked list, the left child is present at position 2×i, and the right child is
 * present at position 2×i + 1. (Here, position i starts from 1).
 * <p>
 * example:
 * <p>
 */
public class BinaryTreeFromLinkedList {

    // time: O(n)
    // space: O(nlogn)
    Node createTree(LinkedList<Integer> linkedList) {
        if (linkedList == null || linkedList.isEmpty()) return null;

        var nodeQueue = new LinkedList<Node>();

        var root = linkedList.remove();
        Node rootNode = new Node(root);
        nodeQueue.offer(rootNode);

        while (!linkedList.isEmpty()) {

            var head = nodeQueue.remove();
            var element = linkedList.remove();

            if (head.getLeft() == null) {

                createNodeAndOffer(nodeQueue, element, head::setLeft);
                nodeQueue.push(head);

            } else if (head.getRight() == null) {

                createNodeAndOffer(nodeQueue, element, head::setRight);

            }
        }

        return rootNode;
    }

    private void createNodeAndOffer(LinkedList<Node> queue, Integer element, Consumer<Node> setter) {
        var candidate = new Node(element);
        queue.offer(candidate);
        setter.accept(candidate);
    }
}
