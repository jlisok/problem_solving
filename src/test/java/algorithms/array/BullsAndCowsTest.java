package algorithms.array;

import algorithms.string.BullsAndCows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BullsAndCowsTest {
    @InjectMocks
    private BullsAndCows testee;

    @ParameterizedTest
    @CsvSource({
            "1807, 7810, 1A3B",
            "1123, 0111, 1A1B",
            "1234, 5678, 0A0B",
            "1234, 1234, 4A0B",
            "1234, 4321, 0A4B",
            "1122, 0001, 0A1B"
    })
    void getHintFirstAttempt_shouldReturnExpectedResult(String secret, String guess, String expected) {
        // when
        String result = testee.getHintFirstAttempt(secret, guess);

        // then
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "1807, 7810, 1A3B",
            "1123, 0111, 1A1B",
            "1234, 5678, 0A0B",
            "1234, 1234, 4A0B",
            "1234, 4321, 0A4B",
            "1122, 0001, 0A1B"
    })
    void getHint_shouldReturnExpectedResult(String secret, String guess, String expected) {
        // when
        String result = testee.getHint(secret, guess);

        // then
        assertEquals(expected, result);
    }
}