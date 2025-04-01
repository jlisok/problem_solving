package algorithms.dynamicprogramming;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClimbingStairsTest {
    @InjectMocks
    private ClimbingStairs testee;

    @Test
    void climbStairs_shouldReturn1_ifInput0() {
        //given //when
        var result = testee.climbStairs(0);
        //then
        assertEquals(1, result);
    }

    @Test
    void climbStairs_shouldReturn2_ifInput2() {
        //given //when
        var result = testee.climbStairs(2);
        //then
        assertEquals(2, result);
    }

    @Test
    void climbStairs_shouldReturn3_ifInput3() {
        //given //when
        var result = testee.climbStairs(3);
        //then
        assertEquals(3, result);
    }

    @Test
    void climbStairs_shouldReturn5_ifInput4() {
        //given //when
        var result = testee.climbStairs(4);
        //then
        assertEquals(5, result);
    }

    @Test
    void climbStairs_shouldReturnCorrectResult_ifInput120() {
        //given //when
        var result = testee.climbStairs(120);
        //then
        assertEquals(1919601489, result);
    }
}
