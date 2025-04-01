package algorithms.binarytree;

import model.techiedelight.Node;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class SpiralOrderTraversalTest {
    @InjectMocks
    private SpiralOrderTraversal testee;

    @Test
    void traverse_shouldReturnEmptyResult_whenRootNull() {
        //when
        var result = testee.traverse(null);
        //then
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void traverse_shouldReturnOneElement_whenOnlyRoot() {
        //given
        var root = new Node(5);
        //when
        var result = testee.traverse(root);
        //then
        assertEquals(1, result.size());
        assertEquals(root.data, result.getFirst());
    }

    @Test
    void traverse_shouldReturnExpected_when4LevelTree() {
        //given
        var node5 = Node.ofStructure(5, 7, 8);
        var node3 = new Node(3, node5, new Node(6));
        var node2 = new Node(2, new Node(4), null);
        var root = new Node(1, node2, node3);

        var expected = List.of(1, 3, 2, 4, 5, 6, 8, 7);
        //when
        var result = testee.traverse(root);
        //then
        assertEquals(expected, result);
    }

}