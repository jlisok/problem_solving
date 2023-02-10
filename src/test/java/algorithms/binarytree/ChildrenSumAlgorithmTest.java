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
class ChildrenSumAlgorithmTest {
    @InjectMocks
    private ChildrenSumAlgorithmToDo algorithm;

    @ParameterizedTest
    @MethodSource("input")
    void childrenSumTest(Node root, boolean expected) {
        //when
        var result = algorithm.isSumOfChildren(root);
        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of(new Node(5), false),
                Arguments.of(createUnHappyLeft(), false),
                Arguments.of(createUnHappyRight(), false),
                Arguments.of(createUnHappyUneven(), false),
                Arguments.of(createHappyUneven(), true),
                Arguments.of(createHappyTree(), true)
        );
    }

    //              25
//                /    \
//               /      \
//              /        \
//             12        13
//            /  \      /  \
//           /    \    /    \
//          7      5  6      7
    private static Node createHappyTree() {
        var node12 = new Node(12, new Node(7), new Node(5));
        var node13 = new Node(13, new Node(6), new Node(7));

        return new Node(25, node12, node13);
    }

    private static Node createUnHappyLeft() {
        var node12 = new Node(12, new Node(7), new Node(3));
        var node13 = new Node(13, new Node(6), new Node(7));

        return new Node(25, node12, node13);
    }

    private static Node createUnHappyRight() {
        var node12 = new Node(12, new Node(7), new Node(5));
        var node13 = new Node(13, new Node(6), new Node(8));

        return new Node(25, node12, node13);
    }

    private static Node createUnHappyUneven() {
        var node12 = new Node(12, new Node(7), null);
        var node13 = new Node(13, new Node(6), new Node(7));

        return new Node(25, node12, node13);
    }

    private static Node createHappyUneven() {
        var node12 = new Node(12, new Node(7), new Node(5));
        var node13 = new Node(13, null, new Node(13));

        return new Node(25, node12, node13);
    }
}

