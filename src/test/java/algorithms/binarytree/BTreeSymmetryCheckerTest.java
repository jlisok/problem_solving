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
class BTreeSymmetryCheckerTest {
    @InjectMocks
    private BTreeSymmetryChecker checker;

    @ParameterizedTest
    @MethodSource("input")
    void getCorners(Node root, boolean expected) {
        //when
        var result = checker.check(root);
        //then
        assertEquals(expected, result);
    }


    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(
                        null,
                        true
                ),
                Arguments.of(
                        new Node(5),
                        true
                ),
                Arguments.of(
                        new Node(
                                5,
                                null,
                                new Node(6)
                        ),
                        false
                ),
                Arguments.of(
                        new Node(
                                5,
                                new Node(2),
                                new Node(6)
                        ),
                        true
                ),
                Arguments.of(
                        new Node(
                                5,
                                new Node(2, new Node(3), null),
                                new Node(6, null, new Node(11))
                        ),
                        true
                ),
                Arguments.of(
                        new Node(
                                5,
                                new Node(2, new Node(3), new Node(13)),
                                new Node(6, new Node(33), new Node(11))
                        ),
                        true
                ),
                Arguments.of(
                        new Node(
                                5,
                                new Node(6, null, new Node(11)),
                                new Node(2, new Node(3), null)
                        ),
                        true
                )
        );
    }
}