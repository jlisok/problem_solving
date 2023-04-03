package algorithms.graph;

import model.Edge;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TransitiveClosureMatrixTest {
    @InjectMocks
    private TransitiveClosureMatrix algorithm;

    @ParameterizedTest
    @MethodSource("input")
    void createTest(Set<Edge> edges, List<List<Integer>> expected) {
        //when
        var result = algorithm.createUsingAdjacencyMatrix(edges);
        //then
        assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("input")
    void createUsingEdgesTest(Set<Edge> edges, List<List<Integer>> expected) {
        //when
        var result = algorithm.createUsingEdges(edges);
        //then
        assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(
                        null,
                        Collections.emptyList()
                ),
                Arguments.of(
                        Collections.emptySet(),
                        Collections.emptyList()
                ),
                Arguments.of(
                        Set.of(
                                new Edge(0, 1)
                        ),
                        List.of(
                                List.of(1, 1),
                                List.of(0, 1)
                        )
                ),
                Arguments.of(
                        Set.of(
                                new Edge(0, 1),
                                new Edge(1, 0)
                        ),
                        List.of(
                                List.of(1, 1),
                                List.of(1, 1)
                        )
                ),
                Arguments.of(
                        Set.of(
                                new Edge(0, 1),
                                new Edge(1, 2),
                                new Edge(2, 3)
                        ),
                        List.of(
                                List.of(1, 1, 0, 0),
                                List.of(0, 1, 1, 0),
                                List.of(0, 0, 1, 1),
                                List.of(0, 0, 0, 1)
                        )
                )
        );
    }
}

