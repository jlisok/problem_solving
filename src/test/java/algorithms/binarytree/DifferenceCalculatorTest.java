package algorithms.binarytree;

import model.Node;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DifferenceCalculatorTest {
    @InjectMocks
    private DifferenceCalculator testee;

    @Test
    void findDifference_shouldReturn0_whenRootNull() {
        //when
        var result = testee.findDifference(null);
        //then
        assertEquals(0, result);
    }

    @Test
    void findDifference_shouldReturnRootValue_whenOnlyRoot() {
        //given
        var root = new Node(1);
        //when
        var result = testee.findDifference(root);
        //then
        assertEquals(1, result);
    }

    @Test
    void findDifference_shouldReturnResult_whenMultilevelTree() {
        //given
        var node5 = Node.ofStructure(5, 7, 8);
        var node6 = new Node(6);
        var node3 = new Node(3, node5, node6);
        var node2 = Node.ofStructure(2,4,null);
        var root = new Node(1, node2, node3);

        var expected = -4;
        //when
        var result = testee.findDifference(root);
        //then
        assertEquals(expected, result);
    }
}