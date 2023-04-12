package algorithms.string;

import algorithms.string.AdjacentDuplicateRemover;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AdjacentDuplicateRemoverTest {
    @InjectMocks
    private AdjacentDuplicateRemover remover;

    @ParameterizedTest
    @MethodSource("input")
    void removeTest(String input, String expected) {
        //when
        var result = remover.removeAdjacent(input);
        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(null, ""),
                Arguments.of("", ""),
                Arguments.of("A", "A"),
                Arguments.of("AA", "A"),
                Arguments.of("AB", "AB"),
                Arguments.of("ABBBBBBA", "ABA"),
                Arguments.of("ABB BBBBA", "AB BA"),
                Arguments.of("AABBBCDDD", "ABCD")
        );
    }
}