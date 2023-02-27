package algorithms.binarytree;

import model.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class NodePrinterTest {
    @InjectMocks
    private NodePrinter printer;

    @ParameterizedTest
    @MethodSource("input")
    void print(Node root, int from, int to, List<Integer> expected) {
        //when
        var result = printer.print(root, from, to);
        //then
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(
                        new Node(5, new Node(3), new Node(8)),
                        1,
                        1,
                        List.of(5)
                ),
                Arguments.of(
                        new Node(1,
                                new Node(2, new Node(4), new Node(5)),
                                new Node(3, new Node(6), new Node(7))
                        ),
                        2,
                        3,
                        List.of(2, 3, 4, 5, 6, 7)
                ),
                Arguments.of(
                        new Node(5, new Node(3), new Node(8)),
                        3,
                        2,
                        Collections.emptyList()
                ),
                Arguments.of(
                        new Node(5, new Node(3), new Node(8)),
                        0,
                        0,
                        Collections.emptyList()
                ),
                Arguments.of(
                        new Node(5, new Node(3), new Node(8)),
                        4,
                        5,
                        Collections.emptyList()
                ),
                Arguments.of(
                        new Node(5, null, new Node(8)),
                        2,
                        2,
                        List.of(8)
                )
        );
    }
}