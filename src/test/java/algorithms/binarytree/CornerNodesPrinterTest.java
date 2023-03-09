package algorithms.binarytree;

import model.Node;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CornerNodesPrinterTest {
    @InjectMocks
    private CornerNodesPrinter printer;

    @ParameterizedTest
    @MethodSource("input")
    void getCorners(Node root, List<Integer> expected) {
        //when
        var result = printer.getCorners(root);
        //then
        assertEquals(expected, result);
    }


    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(
                        null,
                        Collections.emptyList()
                ),
                Arguments.of(
                        new Node(5),
                        List.of(5)
                ),
                Arguments.of(
                        new Node(5, new Node(3), new Node(7)),
                        List.of(5, 3, 7)
                ),
                Arguments.of(
                        new Node(
                                5,
                                new Node(4, new Node(11), null),
                                new Node(7, new Node(15), new Node(18))
                        ),
                        List.of(5, 4, 7, 11, 18)
                ),
                Arguments.of(
                        new Node(
                                6,
                                new Node(3),
                                new Node(
                                        8,
                                        new Node(4, new Node(1), new Node(7)),
                                        new Node(2, null, new Node(3))
                                )
                        ),
                        List.of(6, 3, 8, 4, 2, 1, 3)
                )
        );
    }
}