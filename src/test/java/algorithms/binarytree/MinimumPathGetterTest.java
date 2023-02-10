package algorithms.binarytree;

import model.Node;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class MinimumPathGetterTest {
    @InjectMocks
    private MinimumPathGetter getter;

    @ParameterizedTest
    @MethodSource("input")
    void checkDFS(Node root, int expected) {
        //when
        var result = getter.getMinimumPathDFS(root);
        //then
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("input")
    void checkBFS(Node root, int expected) {
        //when
        var result = getter.getMinimumPathBFS(root);
        //then
        assertEquals(expected, result);
    }


    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(
                        null,
                        -1
                ),
                Arguments.of(
                        new Node(1),
                        0
                ),
                Arguments.of(
                        new Node(1, new Node(2), null),
                        1
                )
                ,
                Arguments.of(
                        new Node(
                                1,
                                new Node(2),
                                new Node(5)
                        ),
                        1
                ),
                Arguments.of(
                        new Node(
                                1,
                                new Node(2, new Node(3), null),
                                new Node(2, new Node(3), null)
                        ),
                        2
                ),
                Arguments.of(
                        new Node(
                                1,
                                new Node(2, new Node(3), new Node(3)),
                                new Node(2, new Node(3), new Node(3))
                        ),
                        2
                ),
                Arguments.of(
                        new Node(
                                1,
                                new Node(2, new Node(3), new Node(3)),
                                new Node(2, new Node(3), new Node(3, new Node(5), null))
                        ),
                        2
                ),
                Arguments.of(
                        new Node(
                                1,
                                new Node(2, new Node(3), new Node(3)),
                                new Node(2, new Node(3), new Node(3, null, new Node(5)))
                        ),
                        2
                )
        );
    }
}