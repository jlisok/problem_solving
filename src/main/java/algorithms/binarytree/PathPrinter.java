package algorithms.binarytree;

import lombok.NonNull;
import model.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://www.techiedelight.com/print-all-paths-from-root-to-leaf-nodes-binary-tree/">link</a>
 * <p>
 * <b>Print all paths from the root to leaf nodes of a binary tree</b>
 * <p>
 * Given a binary tree, write an efficient algorithm to print all paths from the root node to every leaf node in it.
 * <p>
 */
public class PathPrinter {
    private static final String EDGE = "--";

    List<String> getPath(Node root) {
        if (root == null) return Collections.emptyList();

        var result = new ArrayList<String>();
        assemble(root, result, "");

        return result;
    }

    private void assemble(Node node, @NonNull List<String> allPaths, @NonNull String path) {
        if (node == null) return;

        var value = node.getValue();
        var thisPath = path.isEmpty() ? String.valueOf(value) : path + EDGE + value;
        if (node.getLeft() == null && node.getRight() == null) allPaths.add(thisPath);

        assemble(node.getLeft(), allPaths, thisPath);
        assemble(node.getRight(), allPaths, thisPath);
    }
}
