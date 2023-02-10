package algorithms.graph;

import java.util.*;

/**
 Write a function,hasPath,that takes in an object representing the adjacency list of a directed acyclic graph and two
 nodes(src,dst).The function should return a boolean indicating whether or not there exists a directed path between
 the source and destination nodes.
 **/
public class HasPathProblem {

    /**
     * space: O(n)
     * time: O(n^2)
     */
    public boolean hasPathRecursive(Map<String, List<String>> graph, String current, String target) {
        if (Objects.equals(current, target)) return true;

        var neighbours = graph.getOrDefault(current, Collections.emptyList());
        for (String neighbour : neighbours) {
            var hasPath = hasPathRecursive(graph, neighbour, target);
            if (hasPath) return true;
        }

        return false;
    }

    public boolean hasPathBfs(Map<String, List<String>> graph, String source, String target) {
        var queue = new LinkedList<>(List.of(source));

        while (!queue.isEmpty()) {
            var current = queue.removeFirst();

            if (Objects.equals(current, target)) return true;
            var neighbours = graph.getOrDefault(current, Collections.emptyList());

            for (String neighbour : neighbours) {
                queue.addLast(neighbour);
            }
        }

        return false;
    }
}
