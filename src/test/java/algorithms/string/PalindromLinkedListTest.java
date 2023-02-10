package algorithms.string;

import algorithms.string.PalindromLinkedListVerifier;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PalindromLinkedListTest {
    @InjectMocks
    private PalindromLinkedListVerifier verifier;

    @ParameterizedTest
    @MethodSource("input")
    void checkIfPalindromString(LinkedList<String> candidate, boolean expected) {
        System.out.println("Next iteration");

        //when
        var result = verifier.checkIfPalindromString(candidate);
        //then
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("input")
    void checkIfPalindromRecursive(LinkedList<String> candidate, boolean expected) {
        System.out.println("Next iteration");

        //when
        var result = verifier.checkIfPalindromRecursive(candidate);
        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(null, false),
                Arguments.of(new LinkedList<>(), false),
                Arguments.of(new LinkedList<>(List.of("A")), true),
                Arguments.of(new LinkedList<>(List.of("A", "A")), true),
                Arguments.of(new LinkedList<>(List.of("AB")), false),
                Arguments.of(new LinkedList<>(List.of("AB", "A")), true),
                Arguments.of(new LinkedList<>(List.of("AB", "AB")), false),
                Arguments.of(new LinkedList<>(List.of("AA", "XYZ", "CD", "C", "ZYX", "AA")), true),
                Arguments.of(new LinkedList<>(List.of("A", "B", "C", "DC", "B")), false)
        );
    }
}