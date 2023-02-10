package algorithms.string;

import algorithms.string.StrstrFunctionProvider;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class StrstrFunctionProviderTest {
    @InjectMocks
    private StrstrFunctionProvider provider;

    @ParameterizedTest
    @MethodSource("input")
    void removeTest(String input, String pattern, int expected) {
        //when
        var result = provider.findIndex(input, pattern);
        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(null, "ABC", -1),
                Arguments.of("ABC", null, -1),
                Arguments.of("ABC", "", 0),
                Arguments.of("AA", "AAAA", -1),
                Arguments.of(" A", "A", 1),
                Arguments.of("AA", "A", 0),
                Arguments.of("AATTTAAZB", "TA", 4),
                Arguments.of("AATTTAAZB", "KA", -1)
        );
    }
}