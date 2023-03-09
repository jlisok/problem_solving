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
class BTreeInverterTest {
    @InjectMocks
    private BTreeInverter inverter;

    @ParameterizedTest
    @MethodSource("input")
    void construct(Node root, Node expected) {
        //when
        var result = inverter.invert(root);
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
                        new Node(5),
                        new Node(5)
                ),
                Arguments.of(
                        new Node(5, new Node(3), new Node(7)),
                        new Node(5, new Node(7), new Node(3))
                ),
                Arguments.of(
                        new Node(
                                5,
                                new Node(4, new Node(11), null),
                                new Node(7, new Node(15), new Node(18))
                        ),
                        new Node(
                                5,
                                new Node(7, new Node(18), new Node(15)),
                                new Node(4, null, new Node(11))
                        )
                )
        );
    }
}