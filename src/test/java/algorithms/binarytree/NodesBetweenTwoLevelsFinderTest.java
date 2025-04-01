package algorithms.binarytree;

import model.Node;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class NodesBetweenTwoLevelsFinderTest {
    @InjectMocks
    private NodesBetweenTwoLevelsFinder testee;

    @Test
    void findNodes_shouldReturnEmptyResult_whenRootNull() {
        //when
        var result = testee.findNodes(null, 1, 5);
        //then
        assertTrue(result.isEmpty());
    }

    @Test
    void findNodes_shouldReturnEmptyResult_whenMinAboveMax() {
        //given
        var root = new Node(3);
        //when
        var result = testee.findNodes(root, 5, 1);
        //then
        assertTrue(result.isEmpty());
    }

    @Test
    void findNodes_shouldReturnEmptyResult_whenLevelsAboveDepth() {
        //given
        var root = new Node(3);
        //when
        var result = testee.findNodes(root, 2, 3);
        //then
        assertTrue(result.isEmpty());
    }

    @Test
    void findNodes_shouldReturnResult_whenLevelsWithinDepth() {
        //given
        var node4 = Node.ofStructure(4, 6, 7);
        var node5 = Node.ofStructure(5, null, 8);
        var node3 = new Node(3, node4, node5);

        var node2 = new Node(2);
        var root = new Node(1, node2, node3);

        var expected = List.of(2, 3, 4, 5);
        //when
        var result = testee.findNodes(root, 2, 3);
        //then
        assertEquals(expected, result);
    }

    @Test
    void findNodes_shouldReturnResult_whenMaxAboveDepth() {
        //given
        var node4 = Node.ofStructure(4, 6, 7);
        var node5 = Node.ofStructure(5, null, 8);
        var node3 = new Node(3, node4, node5);

        var node2 = new Node(2);
        var root = new Node(1, node2, node3);

        var expected = List.of(2, 3, 4, 5, 6, 7, 8);
        //when
        var result = testee.findNodes(root, 2, 7);
        //then
        assertEquals(expected, result);
    }

}