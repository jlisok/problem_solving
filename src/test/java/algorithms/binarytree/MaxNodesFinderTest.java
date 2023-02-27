package algorithms.binarytree;

import model.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class MaxNodesFinderTest {
    @InjectMocks
    private MaxNodesFinder finder;

    @ParameterizedTest
    @MethodSource("input")
    void getMax(Node root, Integer expected) {
        //when
        var result = finder.getMax(root);
        //then
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(
                        null,
                        null
                ),
                Arguments.of(
                        new Node(5),
                        1
                ),
                Arguments.of(
                        new Node(5, new Node(3), null),
                        1
                ),
                Arguments.of(
                        new Node(5, new Node(3), new Node(7)),
                        2
                ),
                Arguments.of(
                        new Node(
                                5,
                                new Node(
                                        3,
                                        new Node(-1),
                                        new Node(-5)
                                        ),
                                new Node(7)
                        ),
                        2
                ),
                Arguments.of(
                        new Node(
                                5,
                                new Node(
                                        3,
                                        new Node(-1),
                                        new Node(-5)
                                ),
                                new Node(
                                        7,
                                        new Node(30),
                                        null
                                )
                        ),
                        3
                )
        );
    }
}