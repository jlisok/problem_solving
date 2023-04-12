package algorithms.string;

import algorithms.string.LongestCommonPrefix;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class LongestCommonPrefixTest {
    @InjectMocks
    private LongestCommonPrefix verifier;

    @ParameterizedTest
    @MethodSource("input")
    void moreElegant(List<String> input, String expected) {
        //given
        System.out.println("new test");

        //when
        var result = verifier.check(input);
        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(null, ""),
                Arguments.of(new ArrayList<>(), ""),
                Arguments.of(List.of("test"), "test"),
                Arguments.of(List.of("test", " "), ""),
                Arguments.of(List.of("test", "no matchi matchi", "some other string"), ""),
                Arguments.of(List.of("test", "testing", "tete"), "te"),
                Arguments.of(List.of("testing", "test"), "test"),
                Arguments.of(List.of("testing", "t", "test"), "t"),
                Arguments.of(List.of("test", "teapot"), "te"),
                Arguments.of(List.of("teapot", "test "), "te"),
                Arguments.of(List.of("teapot", "other", "test "), "")
        );
    }
}