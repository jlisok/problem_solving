package algorithms.stack;

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
class ArrayReverserTest {
    @InjectMocks
    private ArrayReverser reverser;

    @ParameterizedTest
    @MethodSource("input")
    void reverse(List<Integer> elements, List<Integer> expected) {
        //when
        var result = reverser.reverse(elements);
        //then
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(
                        null,
                        Collections.emptyList()
                ),
                Arguments.of(
                        Collections.emptyList(),
                        Collections.emptyList()
                ),
                Arguments.of(
                        List.of(1),
                        List.of(1)
                ),
                Arguments.of(
                        List.of(1, 1),
                        List.of(1, 1)
                ),
                Arguments.of(
                        List.of(1, 2, 3),
                        List.of(3, 2, 1)
                ),
                Arguments.of(
                        List.of(1, 5, 10, 3),
                        List.of(3, 10, 5, 1)
                )
        );
    }
}