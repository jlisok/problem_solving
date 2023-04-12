package algorithms.binarytree;

import model.Node;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BinarySearchTreeImplToDoTest {

    @ParameterizedTest
    @MethodSource("input")
    void search(Node root, int value, Node expected) {
        //given
        var bst = new BinarySearchTreeImplToDo(root);
        //when
        var result = bst.search(value);
        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(null, 5, null),
                Arguments.of(
                        new Node(5),
                        3,
                        null
                ),
                Arguments.of(
                        new Node(5),
                        5,
                        new Node(5)
                ),
                Arguments.of(
                        new Node(5),
                        5,
                        new Node(5)
                ),
                Arguments.of(
                        oneLevelTree(),
                        3,
                        new Node(3)
                ),
                Arguments.of(
                        oneLevelTree(),
                        7,
                        new Node(7)
                ),
                Arguments.of(
                        oneLevelTree(),
                        5,
                        oneLevelTree()
                ),
                Arguments.of(
                        twoLevelTree(),
                        1,
                        new Node(1)
                ),
                Arguments.of(
                        twoLevelTree(),
                        8,
                        new Node(8)
                ),
                Arguments.of(
                        twoLevelTree(),
                        3,
                        new Node(3, new Node(1), new Node(4))
                ),
                Arguments.of(
                        twoLevelTree(),
                        5,
                        twoLevelTree()
                ),
                Arguments.of(
                        twoLevelTree(),
                        13,
                        null
                ),
                Arguments.of(
                        twoLevelTree(),
                        0,
                        null
                )
        );
    }

    @ParameterizedTest
    @MethodSource("inputAdd")
    void add(Node root, int value, boolean expectedAdded, Node expectedRoot) {
        //given
        var bst = new BinarySearchTreeImplToDo(root);
        //when
        var result = bst.add(value);
        //then
        assertEquals(expectedAdded, result);
        assertEquals(expectedRoot, bst.getRoot());
    }

    private static Stream<Arguments> inputAdd() {
        return Stream.of(
                Arguments.of(null, 5, true, new Node(5)),
                Arguments.of(
                        new Node(3),
                        5,
                        true,
                        new Node(
                                3,
                                null,
                                new Node(5)
                        )
                ),
                Arguments.of(
                        new Node(3),
                        1,
                        true,
                        new Node(
                                3,
                                new Node(1),
                                null
                        )
                ),
                Arguments.of(
                        new Node(
                                3,
                                new Node(1),
                                new Node(5)
                        ),
                        5,
                        true,
                        new Node(
                                3,
                                new Node(1),
                                new Node(5)
                        )
                ),
                Arguments.of(
                        new Node(
                                3,
                                new Node(1),
                                new Node(5)
                        ),
                        1,
                        true,
                        new Node(
                                3,
                                new Node(1),
                                new Node(5)
                        )
                ),
                Arguments.of(
                        new Node(
                                3,
                                new Node(1),
                                new Node(5, null, new Node(6))
                        ),
                        4,
                        true,
                        new Node(
                                3,
                                new Node(1), new Node(5, new Node(4),
                                new Node(6))
                        )
                ),
                Arguments.of(
                        new Node(
                                3,
                                new Node(1, new Node(0), null),
                                new Node(5)
                        ),
                        2,
                        true,
                        new Node(
                                3,
                                new Node(1, new Node(0), new Node(2)),
                                new Node(5)
                        )
                ),
                Arguments.of(
                        new Node(
                                3,
                                new Node(1, new Node(0), null),
                                new Node(5)
                        ),
                        -1,
                        true,
                        new Node(
                                3,
                                new Node(1, new Node(0, new Node(-1), null), null),
                                new Node(5)
                        )
                )
        );
    }

    private static Node oneLevelTree() {
        var leftNode = new Node(3);
        var rightNode = new Node(7);

        return new Node(5, leftNode, rightNode);
    }

    private static Node twoLevelTree() {
        var leftLeaf = new Node(3, new Node(1), new Node(4));
        var rightLeaf = new Node(7, new Node(6), new Node(8));

        return new Node(5, leftLeaf, rightLeaf);
    }
}