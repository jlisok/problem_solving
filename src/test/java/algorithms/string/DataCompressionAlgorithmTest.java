package algorithms.string;

import algorithms.string.DataCompressionAlgorithm;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DataCompressionAlgorithmTest {
    @InjectMocks
    private DataCompressionAlgorithm algorithm;

    @ParameterizedTest
    @MethodSource("input")
    void removeTest(String input, String expected) {
        //when
        var result = algorithm.compress(input);
        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of("", null),
                Arguments.of(" ", "1 "),
                Arguments.of("A", "1A"),
                Arguments.of("AAA", "3A"),
                Arguments.of("ABBB", "1A3B"),
                Arguments.of("AAB", "2A1B"),
                Arguments.of("AABABB", "2A1B1A2B"),
                Arguments.of("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW", "12W1B12W3B24W1B14W")
        );
    }
}