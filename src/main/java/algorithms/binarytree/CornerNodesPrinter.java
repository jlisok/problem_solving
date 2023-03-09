package algorithms.binarytree;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import model.Node;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a href="https://www.techiedelight.com/print-corner-nodes-every-level-binary-tree/">link</a>
 * <p>
 * <b>Print corner nodes of every level in a binary tree</b>
 * <p>
 * Given a binary tree, print corner nodes of every level in it.
 * <p>
 */
public class CornerNodesPrinter {
    private static final int ROOT_LEVEL = 1;

    List<Integer> getCorners(Node root) {
        if (root == null) return Collections.emptyList();

        var corners = new HashMap<Integer, Tuple2<Integer, Integer>>();
        identifyCorner(root, corners, ROOT_LEVEL);

        return corners.entrySet().stream()
                .flatMap(entry -> Stream.of(entry.getValue()._1(), entry.getValue()._2()))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private void identifyCorner(Node node, Map<Integer, Tuple2<Integer, Integer>> corners, int level) {
        if (node == null) return;

        corners.computeIfPresent(level, (key, tuple) -> Tuple.of(tuple._1, node.getValue()));
        corners.computeIfAbsent(level, key -> Tuple.of(node.getValue(), null));

        identifyCorner(node.getLeft(), corners, level + 1);
        identifyCorner(node.getRight(), corners, level + 1);
    }

}
