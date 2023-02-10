package algorithms.graph;

import algorithms.graph.ConnectedComponentCount;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ConnectedComponentCountTest {
    private final ConnectedComponentCount component = new ConnectedComponentCount();
    private static final Map<Integer, Set<Integer>> graph1 = Map.of(
            0, Set.of(8, 1, 5),
            1, Set.of(0),
            5, Set.of(0, 8),
            8, Set.of(0, 5),
            2, Set.of(3, 4),
            3, Set.of(2, 4),
            4, Set.of(3, 2)
    );

    private static final Map<Integer, Set<Integer>> graph2 = Map.of(
            1, Set.of(2),
            2, Set.of(1, 8),
            6, Set.of(7),
            9, Set.of(8),
            7, Set.of(6, 8),
            8, Set.of(9, 7, 2)
    );

    private static final Map<Integer, Set<Integer>> graph3 = Map.of(
            3, Set.of(0),
            4, Set.of(6),
            6, Set.of(4, 5, 7, 8),
            8, Set.of(6),
            7, Set.of(6),
            5, Set.of(6),
            1, Set.of(2),
            2, Set.of(1)
    );

    private static final Map<Integer, Set<Integer>> graph4 = Collections.emptyMap();

    private static final Map<Integer, Set<Integer>> graph5 = Map.of(
            0, Set.of(4, 7),
            1, Collections.emptySet(),
            2, Collections.emptySet(),
            8, Collections.emptySet(),
            3, Set.of(6),
            4, Set.of(0),
            6, Set.of(3),
            7, Set.of(0)
    );


    @ParameterizedTest
    @MethodSource("input")
    void applyDfs(Map<Integer, Set<Integer>> graph, int expected) {
        var result = component.count(graph);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("input")
    void applyDfsRec(Map<Integer, Set<Integer>> graph, int expected) {
        var result = component.countRec(graph);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(graph1, 2),
                Arguments.of(graph2, 1),
                Arguments.of(graph3, 3),
                Arguments.of(graph4, 0),
                Arguments.of(graph5, 5)
        );
    }
}