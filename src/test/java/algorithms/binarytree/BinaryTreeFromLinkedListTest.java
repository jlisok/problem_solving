package algorithms.binarytree;

import model.Node;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BinaryTreeFromLinkedListTest {
    @InjectMocks
    private BinaryTreeFromLinkedList algorithm;

    @ParameterizedTest
    @MethodSource("input")
    void createTree(LinkedList<Integer> input, Node expected) {
        //when
        var result = algorithm.createTree(input);

        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(
                        null,
                        null
                ),
                Arguments.of(
                        new LinkedList<>(),
                        null
                ),
                Arguments.of(
                        new LinkedList<>(List.of(1)),
                        new Node(1)
                ),
                Arguments.of(
                        new LinkedList<>(List.of(1, 3)),
                        new Node(
                                1,
                                new Node(3),
                                null
                        )
                ),
                Arguments.of(
                        new LinkedList<>(List.of(1, 3, 6)),
                        new Node(
                                1,
                                new Node(3),
                                new Node(6)
                        )
                ),
                Arguments.of(
                        new LinkedList<>(List.of(1, 3, 6, 7)),
                        new Node(
                                1,
                                new Node(3, new Node(7), null),
                                new Node(6)
                        )
                ),
                Arguments.of(
                        new LinkedList<>(List.of(1, 3, 6, 7, 2)),
                        new Node(1,
                                new Node(3, new Node(7), new Node(2)),
                                new Node(6)
                        )
                ),
                Arguments.of(
                        new LinkedList<>(List.of(1, 3, 6, 7, 2, 8)),
                        new Node(
                                1,
                                new Node(3, new Node(7), new Node(2)),
                                new Node(6, new Node(8), null)
                        )
                ),
                Arguments.of(
                        new LinkedList<>(List.of(1, 3, 6, 7, 2, 8, -1)),
                        new Node(
                                1,
                                new Node(3, new Node(7), new Node(2)),
                                new Node(6, new Node(8), new Node(-1))
                        )
                )
        );
    }
}