package algorithms.graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Write a function, undirectedPath, that takes in an array of edges for an undirected graph and two nodes (nodeA, nodeB).
 * The function should return a boolean indicating whether there exists a path between nodeA and nodeB.
 */
public class UndirectedPath {

    /**
     * space: O(n)
     * time: O(e)
     */
    public boolean hasUndirectedPathRecursive(String[][] edges, String current, String target) {
        var adjacencyMap = convertToAdjacencyMap(edges);
        return applyUndirectedPathRecursive(adjacencyMap, current, target, new HashSet<>());
    }

    private boolean applyUndirectedPathRecursive(Map<String, Set<String>> graph, String current, String target, Set<String> visited) {
        if (Objects.equals(current, target)) return true;
        if (visited.contains(current)) return false;

        visited.add(current);
        var neighbours = graph.getOrDefault(current, Collections.emptySet());

        for (String neighbour : neighbours) {
            var hasPath = applyUndirectedPathRecursive(graph, neighbour, target, visited);
            if (hasPath) return true;
        }

        return false;
    }

    public boolean hasUndirectedPathBfs(String[][] edges, String source, String target) {
        var graph = convertToAdjacencyMap(edges);

        var visited = new HashSet<String>();
        var queue = new LinkedList<>(List.of(source));

        while (!queue.isEmpty()) {
            var current = queue.removeFirst();
            if (Objects.equals(current, target)) return true;

            if (visited.contains(current)) continue;
            visited.add(current);

            graph.getOrDefault(current, Collections.emptySet())
                    .forEach(queue::addLast);
        }

        return false;
    }

    private Map<String, Set<String>> convertToAdjacencyMap(String[][] edges) {
        if (Objects.isNull(edges)) {
            return Collections.emptyMap();
        }

        return Stream.of(edges)
                .flatMap(item -> Stream.of(Map.entry(item[0], item[1]), Map.entry(item[1], item[0])))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toSet())));
    }
}
