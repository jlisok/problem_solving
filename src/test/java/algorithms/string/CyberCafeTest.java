package algorithms.string;

import algorithms.string.CyberCafe;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CyberCafeTest {
    @InjectMocks
    private CyberCafe cafe;

    @ParameterizedTest
    @MethodSource("input")
    void countUnattendedCustomers(String customers, int capacity, int expected) {
        System.out.println("Next beautiful day starts now");

        //when
        var result = cafe.countUnattendedCustomers(customers, capacity);
        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(null, 0, 0),
                Arguments.of("ABCD", 0, 0),
                Arguments.of(null, 5, 0),
                Arguments.of(" ", 5, 0),
                Arguments.of("ABCDDCEFFEBGAG", 3, 2),
                Arguments.of("ABCDDCBEFFEGAG", 2, 3)
        );
    }
}