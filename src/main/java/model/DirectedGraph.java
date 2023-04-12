package model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectedGraph {
    private final Set<Edge> edges;
    private final Map<Integer, List<Integer>> adjacencyMap;
    private final Set<Integer> vertexes;

    public DirectedGraph(Set<Edge> edges) {
        this.edges = Optional.ofNullable(edges)
                .orElse(new HashSet<>());

        this.adjacencyMap = toAdjacencyMap(edges);
        this.vertexes = toVertexes();
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public Set<Integer> getVertexes() {
        return vertexes;
    }

    public Map<Integer, List<Integer>> getAdjacencyMap() {
        return adjacencyMap;
    }

    private Map<Integer, List<Integer>> toAdjacencyMap(Set<Edge> edges) {
        if (edges == null) return Collections.emptyMap();
        if (edges.isEmpty()) return Collections.emptyMap();

        return edges.stream()
                .collect(Collectors.groupingBy(
                                Edge::source,
                                Collectors.mapping(
                                        Edge::destination,
                                        Collectors.toList()
                                )
                        )
                );
    }

    private Set<Integer> toVertexes() {
        return edges.stream()
                .flatMap(edge -> Stream.of(edge.source(), edge.destination()))
                .collect(Collectors.toSet());
    }


    public static DirectedGraph reversed(Set<Edge> edges) {
        if (edges == null) return new DirectedGraph(null);

        var reversed = edges.stream()
                .map(edge -> new Edge(edge.destination(), edge.source()))
                .collect(Collectors.toSet());

        return new DirectedGraph(reversed);
    }
}
