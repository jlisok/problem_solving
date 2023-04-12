package algorithms.graph;

import algorithms.graph.HasPathProblem;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HasPathProblemTest {
    private final HasPathProblem pathProblem = new HasPathProblem();

    private static final Map<String, List<String>> graph = Map.of(
            "a", List.of("c", "b"),
            "b", List.of("d"),
            "c", List.of("e"),
            "d", List.of("f"),
            "e", Collections.emptyList(),
            "f", Collections.emptyList()
    );

    @Test
    void applyDfs() {
        var result = pathProblem.hasPathRecursive(graph, "a", "d");
        assertTrue(result);
    }

    @Test
    void applyBfs() {
        var result = pathProblem.hasPathBfs(graph, "a", "d");
        assertTrue(result);
    }
}