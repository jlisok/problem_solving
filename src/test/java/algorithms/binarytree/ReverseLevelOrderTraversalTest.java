package algorithms.binarytree;

import model.Node;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class ReverseLevelOrderTraversalTest {
    @InjectMocks
    private ReverseLevelOrderTraversal testee;

    @Test
    void findInorderTraversal_whenInputNull_thenRespondsWithEmptyList() {
        // when
        var result = testee.findReverseLevelOrderTraversal(null);
        //then
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void findInorderTraversal_whenInputValid_thenRespondsWithFilledInList() {
        //given
        var node7 = new Node(7);
        var node8 = new Node(8);
        var node5 = new Node(5, node7, node8);
        var node6 = new Node(6);
        var node3 = new Node(3, node5, node6);
        var node4 = new Node(4);
        var node2 = new Node(2, node4, null);
        var root = new Node(1, node2, node3);
        var expected = List.of(7, 8, 4, 5, 6, 2, 3, 1);

        // when
        var result = testee.findReverseLevelOrderTraversal(root);
        //then
        assertNotNull(result);
        assertEquals(expected, result);
    }
}