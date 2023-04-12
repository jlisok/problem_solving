package algorithms.string;

import algorithms.string.RemovePatternAlgorithm;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class RemovePatternAlgorithmTest {
    @InjectMocks
    private RemovePatternAlgorithm algorithm;

    @ParameterizedTest
    @MethodSource("input")
    void removeTest(String input, String expected) {
        //when
        var result = algorithm.remove(input);
        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(null, ""),
                Arguments.of("", ""),
                Arguments.of(" ", " "),
                Arguments.of("CBAABCAB", "BA"),
                Arguments.of("ABACB", ""),
                Arguments.of("ABCACBCAABB", "")
        );
    }
}