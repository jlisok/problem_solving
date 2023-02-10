package algorithms.graph;

import java.util.*;

/**
 * Write a function, connectedComponentsCount, that takes in the adjacency list of an undirected graph.
 * The function should return the number of connected components within the graph.
 */
public class ConnectedComponentCount {

    // loop approach
    public int count(Map<Integer, Set<Integer>> graph) {
        var visited = new HashSet<Integer>();
        return graph.keySet().stream()
                .map(key -> getCount(key, visited, graph))
                .reduce(0, Integer::sum);
    }

    private int getCount(Integer source, Set<Integer> visited, Map<Integer, Set<Integer>> graph) {
        var stack = new LinkedList<>(List.of(source));
        var count = 0;

        while (!stack.isEmpty()) {
            var current = stack.removeFirst();
            var neighbours = graph.getOrDefault(current, Collections.emptySet());

            if (!visited.contains(current)) {
                visited.add(current);
                for (Integer neighbour : neighbours) {
                    stack.addFirst(neighbour);
                }
                count = 1;
            }
        }

        return count;
    }

    // recursive approach
    public int countRec(Map<Integer, Set<Integer>> graph) {
        var visited = new HashSet<Integer>();

        return graph.keySet().stream()
                .map(key -> getCountRec(key, visited, graph)) // visited modified in clean method, bad habit
                .reduce(0, Integer::sum);
    }

    private int getCountRec(Integer current, Set<Integer> visited, Map<Integer, Set<Integer>> graph) {
        if (visited.contains(current)) return 0;

        visited.add(current);
        var neighbours = graph.getOrDefault(current, Collections.emptySet());
        for (Integer neighbour : neighbours) {
            getCountRec(neighbour, visited, graph);
        }

        return 1;
    }
}
