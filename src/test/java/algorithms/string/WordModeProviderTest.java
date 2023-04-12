package algorithms.string;

import algorithms.string.WordModeProvider;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class WordModeProviderTest {
    @InjectMocks
    private WordModeProvider provider;

    @ParameterizedTest
    @MethodSource("input")
    void removeTest(List<String> input, String expected) {
        //when
        var result = provider.find(input);
        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(Collections.emptyList(), null),
                Arguments.of(List.of("test"), "test"),
                Arguments.of(List.of("test", "test"), "test"),
                Arguments.of(List.of("test", "test", "test1", "test1"), "test"),
                Arguments.of(List.of("test", "test1", "test1"), "test1"),
                Arguments.of(List.of("code", "coder", "coding", "codable", "codec", "codecs", "coded", "codeless", "codec",
                        "codecs", "codependence", "codex", "codify", "codependents", "codes", "code", "coder", "codesign",
                        "codec", "codeveloper", "codrive", "codec", "codecs", "codiscovered"), "codec")
        );
    }
}