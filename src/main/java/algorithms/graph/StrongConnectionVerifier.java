package algorithms.graph;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import model.DirectedGraph;
import model.Edge;

import java.util.*;

/**
 * <a href="https://www.techiedelight.com/find-path-between-vertices-directed-graph/">link</a>
 * <p>
 * <b>Check if a graph is strongly connected or not</b>
 * <p>
 * Given a directed graph, check if it is strongly connected or not. A directed graph is said to be strongly connected
 * if every vertex is reachable from every other vertex.
 */
public class StrongConnectionVerifier {

    boolean verify(Set<Edge> edges) {
        if (edges == null) return true;
        if (edges.isEmpty()) return true;

        var graph = new DirectedGraph(edges);
        var source = graph.getVertexes().iterator().next();

        var hasPath = verifyInternal(graph, source);
        if (!hasPath) return false;

        var reversedGraph = DirectedGraph.reversed(edges);
        return verifyInternal(reversedGraph, source);
    }

    private boolean verifyInternal(DirectedGraph graph, Integer source) {
        var adjacencyMap = graph.getAdjacencyMap();
        if (adjacencyMap.isEmpty()) return true;

        var vertexes = graph.getVertexes();

        return vertexes.stream()
                .allMatch(vertex -> hasPath(source, vertex, new ArrayList<>(), adjacencyMap));
    }

    private boolean hasPath(Integer source, Integer destination, List<Integer> visited, Map<Integer, List<Integer>> graph) {
        if (destination.equals(source)) return true;

        visited.add(source);
        var candidates = graph.getOrDefault(source, Collections.emptyList());
        for (Integer candidate : candidates) {
            if (!visited.contains(candidate)) {

                var hasPath = hasPath(candidate, destination, visited, graph);
                if (hasPath) return true;

            }

        }

        return false;
    }

    boolean verifyBruteForce(Set<Edge> edges) {
        var graph = new DirectedGraph(edges);
        var adjacencyMap = graph.getAdjacencyMap();

        if (adjacencyMap.isEmpty()) return true;

        return toCartesianProduct(graph).stream()
                .allMatch(tuple -> hasPath(tuple._1, tuple._2, new ArrayList<>(), adjacencyMap));
    }

    private List<Tuple2<Integer, Integer>> toCartesianProduct(DirectedGraph graph) {
        if (graph == null) return Collections.emptyList();

        var vertexes = graph.getVertexes();
        var result = new ArrayList<Tuple2<Integer, Integer>>();
        for (Integer vertex1 : vertexes) {

            for (Integer vertex2 : vertexes) {

                var tuple = Tuple.of(vertex1, vertex2);
                if (vertex1.equals(vertex2) || result.contains(tuple)) continue;

                result.add(tuple);

            }
        }

        return result;
    }
}
