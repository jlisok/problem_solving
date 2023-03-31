package algorithms.array;

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
class ArrayGreatestElementsFinderTest {
    @InjectMocks
    private ArrayGreatestElementsFinder finder;

    @ParameterizedTest
    @MethodSource("input")
    void getLocalMaxes(List<Integer> elements, List<Integer> expected) {
        //when
        var result = finder.getLocalMaxes(elements);
        //then
        Assertions.assertEquals(expected.size(), result.size());
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
                        List.of(1, 4, 6, 8),
                        List.of(8)
                ),
                Arguments.of(
                        List.of(1, 10, 6, 8),
                        List.of(8, 10)
                ),
                Arguments.of(
                        List.of(-1, -10, -6, -8),
                        List.of(-8, -6, -1)
                ),
                Arguments.of(
                        List.of(10, 4, 6, 3, 5),
                        List.of(5, 6, 10)
                )
        );
    }
}