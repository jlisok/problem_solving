package algorithms.graph;

import model.Edge;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class StrongConnectionVerifierTest {
    @InjectMocks
    private StrongConnectionVerifier algorithm;

    @ParameterizedTest
    @MethodSource("input")
    void verifyTest(Set<Edge> edges, boolean expected) {
        //when
        var result = algorithm.verify(edges);
        //then
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("input")
    void verifyBruteForceTest(Set<Edge> edges, boolean expected) {
        //when
        var result = algorithm.verifyBruteForce(edges);
        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(
                        null,
                        true
                ),
                Arguments.of(
                        Collections.emptySet(),
                        true
                ),
                Arguments.of(
                        Set.of(
                                new Edge(1, 2)
                        ),
                        false
                ),
                Arguments.of(
                        Set.of(
                                new Edge(1, 2),
                                new Edge(2, 1)
                        ),
                        true
                ),
                Arguments.of(
                        Set.of(
                                new Edge(1, 2),
                                new Edge(2, 3),
                                new Edge(3, 4)
                        ),
                        false
                ),
                Arguments.of(
                        Set.of(
                                new Edge(1, 2),
                                new Edge(2, 3),
                                new Edge(3, 4),
                                new Edge(4, 1)
                        ),
                        true
                ),
                Arguments.of(
                        Set.of(
                                new Edge(1, 2),
                                new Edge(2, 3),
                                new Edge(3, 2),
                                new Edge(3, 4),
                                new Edge(3, 1),
                                new Edge(4, 1)
                        ),
                        true
                ),
                Arguments.of(
                        Set.of(
                                new Edge(1, 2),
                                new Edge(2, 3),
                                new Edge(3, 4),
                                new Edge(5, 1)
                        ),
                        false
                ),
                Arguments.of(
                        Set.of(
                                new Edge(1, 2),
                                new Edge(2, 3),
                                new Edge(3, 1),
                                new Edge(5, 6),
                                new Edge(6, 5)
                        ),
                        false
                )
        );
    }
}

