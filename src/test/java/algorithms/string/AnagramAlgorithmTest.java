package algorithms.string;

import algorithms.string.AnagramAlgorithm;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AnagramAlgorithmTest {
    @InjectMocks
    private AnagramAlgorithm algorithm;

    @ParameterizedTest
    @MethodSource("input")
    void isAnagramTest(String left, String right, boolean expected) {
        //when
        var result = algorithm.isAnagram(left, right);
        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(null, "", false),
                Arguments.of("", null, false),
                Arguments.of("", "A", false),
                Arguments.of("A", "AB", false),
                Arguments.of("silett", "listen", false),
                Arguments.of("A", "A", true),
                Arguments.of("silent", "listen", true),
                Arguments.of("incest", "insect", true),
                Arguments.of("tommarvoloriddle", "iamlordvoldemort", true)
        );
    }
}