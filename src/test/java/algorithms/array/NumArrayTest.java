package algorithms.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumArrayTest {
    private static final NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});

    @ParameterizedTest
    @CsvSource({
            "0, 2, 1",
            "2, 5, -1",
            "0, 5, -3"
    })
    void sumRange(int left, int right, int expected) {
        assertEquals(expected, numArray.sumRange(left, right));
    }
}