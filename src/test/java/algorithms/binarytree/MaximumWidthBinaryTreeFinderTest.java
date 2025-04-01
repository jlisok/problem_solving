package algorithms.binarytree;

import model.Node;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class MaximumWidthBinaryTreeFinderTest {
    @InjectMocks
    private MaximumWidthBinaryTreeFinder testee;

    @Test
    void findMaximumWidth_shouldReturn0_whenRootNull() {
        //when
        var result = testee.findMaximumWidth(null);
        //then
        assertEquals(0, result);
    }

    @Test
    void findMaximumWidth_shouldReturn1_whenOnlyRoot() {
        //given
        var root = new Node(3);
        //when
        var result = testee.findMaximumWidth(root);
        //then
        assertEquals(1, result);
    }

    @Test
    void findMaximumWidth_shouldReturn4_whenSymmetric3LevelTree() {
        //given
        var node2 = Node.ofStructure(2, 4, 5);
        var node3 = Node.ofStructure(3, 6, 7);
        var root = new Node(1, node2, node3);
        //when
        var result = testee.findMaximumWidth(root);
        //then
        assertEquals(4, result);
    }

    @Test
    void findMaximumWidth_shouldReturn4_when3LevelLinkedList() {
        //given
        var node3 = Node.ofStructure(3, 4, null);
        var node2 = new Node(2, node3, null);
        var root = new Node(1, node2, null);
        //when
        var result = testee.findMaximumWidth(root);
        //then
        assertEquals(1, result);
    }
}