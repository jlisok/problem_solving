package algorithms.sort;

import algorithms.sort.InsertionSortAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class InsertionSortAlgorithmTest {
    @InjectMocks
    private InsertionSortAlgorithm algorithm;

    @Test
    void sortWhenInputNull() {
        //when //rhwn
        Assertions.assertDoesNotThrow(() -> algorithm.sort(null));
    }

    @ParameterizedTest
    @MethodSource("input")
    void sort(int[] input, int[] expected) {
        //when
        algorithm.sort(input);
        //then
        Assertions.assertEquals(input.length, expected.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i], input[i]);
        }
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(
                        new int[]{},
                        new int[]{}
                ),
                Arguments.of(
                        new int[]{1},
                        new int[]{1}
                ),
                Arguments.of(
                        new int[]{1, 2},
                        new int[]{1, 2}
                ),
                Arguments.of(
                        new int[]{2, 1},
                        new int[]{1, 2}
                ),
                Arguments.of(
                        new int[]{2, 1, 5},
                        new int[]{1, 2, 5}
                ),
                Arguments.of(
                        new int[]{5, 3, 2, 1},
                        new int[]{1, 2, 3, 5}
                ),
                Arguments.of(
                        new int[]{12, 4, 7, 22, 1, 13, 18},
                        new int[]{1, 4, 7, 12, 13, 18, 22}
                ),
                Arguments.of(
                        new int[]{1, 1, 1, 1},
                        new int[]{1, 1, 1, 1}
                ),
                Arguments.of(
                        new int[]{12, 4, 7, 22, 1, 13, 18, 0},
                        new int[]{0, 1, 4, 7, 12, 13, 18, 22}
                )
        );
    }
}