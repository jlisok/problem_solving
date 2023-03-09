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
class BTreeSwapComparatorTest {
    @InjectMocks
    private BTreeSwapComparator comparator;

    @ParameterizedTest
    @MethodSource("input")
    void getCorners(Node root1, Node root2, boolean expected) {
        //when
        var result = comparator.swapAndCompare(root1, root2);
        //then
        assertEquals(expected, result);
    }


    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(
                        null,
                        null,
                        true
                ),
                Arguments.of(
                        null,
                        new Node(5),
                        false
                ),
                Arguments.of(
                        new Node(5),
                        null,
                        false
                ),
                Arguments.of(
                        new Node(5),
                        new Node(5),
                        true
                ),
                Arguments.of(
                        new Node(5, null, new Node(7)),
                        new Node(5, null, new Node(6)),
                        false
                ),
                Arguments.of(
                        new Node(5, new Node(7), null),
                        new Node(5, null, new Node(6)),
                        false
                ),
                Arguments.of(
                        new Node(5, new Node(6), null),
                        new Node(5, null, new Node(6)),
                        true
                ),
                Arguments.of(
                        new Node(7, new Node(6), null),
                        new Node(5, null, new Node(6)),
                        false
                ),
                Arguments.of(
                        new Node(5, null, new Node(6)),
                        new Node(5, null, new Node(6)),
                        true
                ),
                Arguments.of(
                        new Node(
                                5,
                                null,
                                new Node(6, new Node(3), new Node(10))
                        ),
                        new Node(
                                5,
                                null,
                                new Node(6, new Node(3), new Node(9))
                        ),
                        false
                ),
                Arguments.of(
                        new Node(
                                5,
                                null,
                                new Node(6, new Node(3), new Node(9))
                        ),
                        new Node(
                                5,
                                new Node(6, new Node(3), new Node(9)),
                                null

                        ),
                        true
                ),
                Arguments.of(
                        new Node(
                                5,
                                null,
                                new Node(6, new Node(9), new Node(3))
                        ),
                        new Node(
                                5,
                                new Node(6, new Node(3), new Node(9)),
                                null

                        ),
                        true
                )
        );
    }
}