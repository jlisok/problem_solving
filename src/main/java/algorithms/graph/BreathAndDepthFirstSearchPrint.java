package algorithms.graph;

import java.util.*;

public class BreathAndDepthFirstSearchPrint {

    public void applyDfs(Map<String, List<String>> graph, String current) {
        System.out.println(current);
        var neighbours = graph.getOrDefault(current, Collections.emptyList());
        for (String neighbour : neighbours) {
            applyDfs(graph, neighbour);
        }
    }

    public void applyBfs(Map<String, List<String>> graph, String source) {
        var queue = new LinkedList<>(List.of(source));

        while (queue.size() > 0) {
            var current = queue.removeFirst();
            System.out.println(current);

            var neighbours = graph.getOrDefault(current, Collections.emptyList());
            for (String neighbour : neighbours) {
                queue.addLast(neighbour);
            }
        }
    }
}
