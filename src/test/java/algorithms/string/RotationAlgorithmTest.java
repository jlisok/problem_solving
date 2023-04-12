package algorithms.string;

import algorithms.string.RotationAlgorithm;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class RotationAlgorithmTest {
    @InjectMocks
    private RotationAlgorithm algorithm;

    @ParameterizedTest
    @MethodSource("input")
    void isAnagramTest(String left, String right, int expected) {
        //when
        var result = algorithm.countRotation(left, right);
        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(null, "ABC", -1),
                Arguments.of("ABC", null, -1),
                Arguments.of("ABC", "AB", -1),
                Arguments.of("AB", "ABC", -1),
                Arguments.of("ABT", "ABC", -1),
                Arguments.of("ABCD", "ABCD", 0),
                Arguments.of("ABCD", "DABC", 1),
                Arguments.of("BCDA", "DABC", 2)
        );
    }
}