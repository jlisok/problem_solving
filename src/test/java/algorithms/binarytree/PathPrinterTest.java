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
class PathPrinterTest {
    @InjectMocks
    private PathPrinter printer;

    @ParameterizedTest
    @MethodSource("input")
    void construct(Node root, List<String> expected) {
        //when
        var result = printer.getPath(root);
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
                        List.of("5")
                ),
                Arguments.of(
                        new Node(5, new Node(3), new Node(7)),
                        List.of(
                                "5--3",
                                "5--7"
                        )
                ),
                Arguments.of(
                        new Node(
                                5,
                                new Node(4, new Node(11), null),
                                new Node(7, new Node(15), new Node(18))
                        ),
                        List.of(
                                "5--4--11",
                                "5--7--15",
                                "5--7--18"
                        )
                ),
                Arguments.of(
                        new Node(
                                1,
                                new Node(
                                        2,
                                        new Node(4),
                                        new Node(5)
                                ),
                                new Node(
                                        3,
                                        new Node(
                                                6,
                                                new Node(8),
                                                null

                                        ),
                                        new Node(
                                                7,
                                                null,
                                                new Node(9)
                                        )
                                )
                        ),
                        List.of(
                                "1--2--4",
                                "1--2--5",
                                "1--3--6--8",
                                "1--3--7--9"
                        )
                )
        );
    }
}