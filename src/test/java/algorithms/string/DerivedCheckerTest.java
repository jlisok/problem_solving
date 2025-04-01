package algorithms.string;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DerivedCheckerTest {
    @InjectMocks
    private DerivedChecker testee;

    @Test
    void check_shouldReturnTrue_whenBothNull() {
        //when
        var result = testee.check(null, null);
        //then
        assertTrue(result);
    }

    @Test
    void check_shouldReturnFalse_whenOneNull() {
        //when
        var result = testee.check("TEST", null);
        //then
        assertFalse(result);
    }

    @Test
    void check_shouldReturnFalse_whenDifferentLength() {
        //when
        var result = testee.check("TEST", "TEST03");
        //then
        assertFalse(result);
    }

    @Test
    void check_shouldReturnFalse_whenNoDerivative() {
        //when
        var result = testee.check("ETEST", "MTEST");
        //then
        assertFalse(result);
    }

    @Test
    void check_shouldReturnTrue_whenNoRotationRequired() {
        //when
        var result = testee.check("TEST", "TEST");
        //then
        assertTrue(result);
    }

    @Test
    void check_shouldReturnTrue_whenRotationRequired() {
        //when
        var result = testee.check("TTES", "TEST");
        //then
        assertTrue(result);
    }
}