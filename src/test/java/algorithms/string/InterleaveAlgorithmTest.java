package algorithms.string;

import algorithms.string.InterleaveAlgorithm;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class InterleaveAlgorithmTest {
    @InjectMocks
    private InterleaveAlgorithm algorithm;

    @ParameterizedTest
    @MethodSource("input")
    void interleaveTest(String left, String right, Set<String> expected) {
        //when
        var result = algorithm.getInterleaves(left, right);
        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(null, "", Collections.emptySet()),
                Arguments.of("", null, Collections.emptySet()),
                Arguments.of("", "ABC", Set.of("ABC")),
                Arguments.of("ABC", "", Set.of("ABC")),
                Arguments.of("ABC", "ACB", Set.of("ACBABC", "AABCBC", "ACABCB", "ABCACB", "AACBBC", "ABACCB", "ACABBC", "ABACBC", "AACBCB", "AABCCB"))
        );
    }
}