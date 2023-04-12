package algorithms.graph;

import algorithms.graph.UndirectedPath;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UndirectedPathTest {
    private final UndirectedPath component = new UndirectedPath();
    private static final String[][] edges01 = {
            {"i", "j"},
            {"k", "i"},
            {"m", "k"},
            {"k", "l"},
            {"o", "n"}
    };

    private static final String[][] edges02 = {
            {"b", "a"},
            {"c", "a"},
            {"b", "c"},
            {"q", "r"},
            {"q", "s"},
            {"q", "u"},
            {"q", "t"}
    };

    private static final String[][] edges03 = {
            {"s", "r"},
            {"t", "q"},
            {"q", "r"}
    };


    @ParameterizedTest
    @MethodSource("input")
    void applyDfs(String[][] edges, String start, String destination, boolean expected) {
        var result = component.hasUndirectedPathRecursive(edges, start, destination);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("input")
    void applyBfs(String[][] edges, String start, String destination, boolean expected) {
        var result = component.hasUndirectedPathBfs(edges, start, destination);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(edges01, "j", "m", true),
                Arguments.of(edges01, "m", "j", true),
                Arguments.of(edges01, "l", "j", true),
                Arguments.of(edges01, "k", "o", false),
                Arguments.of(edges01, "i", "o", false),

                Arguments.of(edges02, "a", "b", true),
                Arguments.of(edges02, "a", "c", true),
                Arguments.of(edges02, "r", "t", true),
                Arguments.of(edges02, "r", "b", false),

                Arguments.of(edges03, "r", "t", true)
        );
    }
}