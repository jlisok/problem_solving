package algorithms.graph;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ItineraryFinderTest {
    @InjectMocks
    private ItineraryFinder finder;

    @ParameterizedTest
    @MethodSource("input")
    void find(String[][] sourceDestinations, String expected) {
        //when
        var result = finder.find(sourceDestinations);
        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(
                        null,
                        null
                ),
                Arguments.of(
                        new String[][]{
                                {"LAX", "DXB"},
                                {"DXB", "LAX"}
                        },
                        null
                ),
                Arguments.of(
                        new String[][]{
                                {"LAX", "DXB"}
                        },
                        "LAX --> DXB"
                ),
                Arguments.of(
                        new String[][]{
                                {"LAX", "DXB"},
                                {"LUS", "DXB"}
                        },
                        null
                ),
                Arguments.of(
                        new String[][]{
                                {"LAX", "DXB"},
                                {"DFW", "JFK"},
                                {"LHR", "DFW"},
                                {"JFK", "LAX"}
                        },
                        "LHR --> DFW --> JFK --> LAX --> DXB"
                ),
                Arguments.of(
                        new String[][]{
                                {"HKG", "DXB"},
                                {"FRA", "HKG"},
                                {"DEL", "FRA"}
                        },
                        "DEL --> FRA --> HKG --> DXB"
                )
        );
    }

}