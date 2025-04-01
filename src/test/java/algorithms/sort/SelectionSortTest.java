package algorithms.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class SelectionSortTest {
    @InjectMocks
    private SelectionSort algorithm;

    @Test
    void sortWhenInputNull() {
        //when //then
        Assertions.assertDoesNotThrow(() -> algorithm.sort(null));
    }

    @ParameterizedTest
    @MethodSource("input")
    void sort(List<Integer> input, List<Integer> expected) {
        //when
        algorithm.sort(input);
        //then
        assertEquals(expected, input);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
//                Arguments.of(
//                        Collections.emptyList(),
//                        Collections.emptyList()
//                ),
//                Arguments.of(
//                        Arrays.asList(1),
//                        Arrays.asList(1)
//                ),
//                Arguments.of(
//                        Arrays.asList(1, 2),
//                        Arrays.asList(1, 2)
//                ),
//                Arguments.of(
//                        Arrays.asList(2, 1),
//                        Arrays.asList(1, 2)
//                ),
                Arguments.of(
                        Arrays.asList(2, 1, 5),
                        Arrays.asList(1, 2, 5)
                ),
                Arguments.of(
                        Arrays.asList(5, 3, 2, 1),
                        Arrays.asList(1, 2, 3, 5)
                ),
                Arguments.of(
                        Arrays.asList(12, 4, 7, 22, 1, 13, 18),
                        Arrays.asList(1, 4, 7, 12, 13, 18, 22)
                ),
                Arguments.of(
                        Arrays.asList(1, 1, 1, 1),
                        Arrays.asList(1, 1, 1, 1)
                ),
                Arguments.of(
                        Arrays.asList(12, 4, 7, 22, 1, 13, 18, 0),
                        Arrays.asList(0, 1, 4, 7, 12, 13, 18, 22)
                )
        );
    }
}