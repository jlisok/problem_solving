package algorithms.graph;

import algorithms.graph.HasPathProblem;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

class BreathAndDepthFirstSearchPrintTest {
    private final HasPathProblem hasPathProblem = new HasPathProblem();

    private static final Map<String, List<String>> graph = Map.of(
            "f", List.of("g", "i"),
            "g", List.of("h"),
            "h", Collections.emptyList(),
            "i", List.of("g", "k"),
            "j", List.of("i")
    );

    @Test
    void hasPath() {
        var result = hasPathProblem.hasPathRecursive(graph, "f", "k");
        System.out.println(result);
    }

}