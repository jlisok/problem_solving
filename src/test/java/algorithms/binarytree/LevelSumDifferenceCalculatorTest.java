package algorithms.binarytree;

import model.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class LevelSumDifferenceCalculatorTest {
    @InjectMocks
    private LevelSumDifferenceCalculator calculator;

    @ParameterizedTest
    @MethodSource("input")
    void calculate(Node root, Integer expected) {
        //when
        var result = calculator.calculate(root);
        //then
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(
                        null,
                        null
                ),
                Arguments.of(
                        new Node(5, new Node(3), new Node(8)),
                        -6
                ),
                Arguments.of(
                        new Node(5, new Node(8), null),
                        -3
                ),
                Arguments.of(
                        new Node(
                                1,
                                new Node(
                                        2,
                                        new Node(4),
                                        null
                                ),
                                new Node(
                                        3,
                                        new Node(
                                                5,
                                                new Node(7),
                                                new Node(8)
                                        ),
                                        new Node(6)
                                )
                        ),
                        -4
                )
        );
    }
}