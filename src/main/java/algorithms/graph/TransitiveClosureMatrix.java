package algorithms.graph;

import io.vavr.collection.Stream;
import model.DirectedGraph;
import model.Edge;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://www.techiedelight.com/transitive-closure-graph/">link</a>
 * <p>
 * <b>Transitive closure of a graph</b>
 * <p>
 * he transitive closure for a digraph G is a digraph G’ with an edge (i, j) corresponding to each directed path from i to j in G.
 * The resultant digraph G’ representation in the form of the adjacency matrix is called the connectivity matrix.
 */
public class TransitiveClosureMatrix {


    List<List<Integer>> createUsingEdges(Set<Edge> edges) {
        if (edges == null) return new ArrayList<>();
        if (edges.isEmpty()) return new ArrayList<>();

        var vertexes = toVertexes(edges);
        var resultSize = vertexes.size();

        List<List<Integer>> result = Stream.range(0, resultSize)
                .map(i -> new ArrayList<>(Collections.nCopies(resultSize, 0)))
                .collect(Collectors.toList()); // must stay, modifiable list

        for (Edge edge : edges) {

            var source = edge.source();
            var destination = edge.destination();

            var rowSource = result.get(source);
            rowSource.set(source, 1);
            rowSource.set(destination, 1);

            result.get(destination).set(destination, 1);
        }

        return result;
    }

    private Set<Integer> toVertexes(Set<Edge> edges) {
        return edges.stream()
                .flatMap(edge -> java.util.stream.Stream.of(edge.source(), edge.destination()))
                .collect(Collectors.toSet());
    }


    List<List<Integer>> createUsingAdjacencyMatrix(Set<Edge> edges) {
        if (edges == null) return new ArrayList<>();
        if (edges.isEmpty()) return new ArrayList<>();

        var graph = new DirectedGraph(edges);
        var vertexes = graph.getVertexes();
        var resultSize = vertexes.size();

        List<List<Integer>> result = Stream.range(0, resultSize)
                .map(i -> new ArrayList<>(Collections.nCopies(resultSize, 0)))
                .collect(Collectors.toList()); // must stay, modifiable list

        graph.getAdjacencyMap()
                .entrySet()
                .forEach(entry -> fillMatrix(entry, result));


        return result;
    }

    private void fillMatrix(Map.Entry<Integer, List<Integer>> entry, List<List<Integer>> result) {
        var source = entry.getKey();
        var row = result.get(source);
        row.set(source, 1);

        for (Integer destination : entry.getValue()) {
            row.set(destination, 1);
            result.get(destination).set(destination, 1);
        }
    }
}
