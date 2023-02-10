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
class SkewnessVerifierTest {
    @InjectMocks
    private SkewnessVerifier verifier;

    @ParameterizedTest
    @MethodSource("input")
    void check(Node root, boolean expected) {
        //when
        var result = verifier.isSkewed(root);
        //then
        assertEquals(expected, result);
    }


    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(
                        null,
                        false
                ),
                Arguments.of(
                        new Node(1),
                        true
                ),
                Arguments.of(
                        new Node(1, new Node(2), null),
                        true
                ),
                Arguments.of(
                        new Node(1, new Node(2), new Node(5)),
                        false
                ),
                Arguments.of(
                        new Node(
                                1,
                                new Node(2, new Node(3), null),
                                new Node(5)
                        ),
                        false
                ),
                Arguments.of(
                        new Node(
                                1,
                                new Node(2, null, new Node(3)),
                                null
                        ),
                        true
                ),
                Arguments.of(
                        new Node(
                                1,
                                new Node(2, new Node(3), null),
                                null
                        ),
                        true
                ),
                Arguments.of(
                        new Node(
                                1,
                                null,
                                new Node(2, new Node(3), null)
                        ),
                        true
                ),
                Arguments.of(
                        new Node(
                                1,
                                null,
                                new Node(2, null, new Node(3))
                        ),
                        true
                ),
                Arguments.of(
                        new Node(
                                1,
                                null,
                                new Node(2, new Node(5), new Node(3))
                        ),
                        false
                )
        );
    }
}