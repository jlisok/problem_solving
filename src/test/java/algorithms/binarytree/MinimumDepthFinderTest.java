package algorithms.binarytree;

import model.Node;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class MinimumDepthFinderTest {
    @InjectMocks
    private MinimumDepthFinder testee;

    @Test
    void find_shouldReturn0_whenRootNull() {
        //when
        var result = testee.find(null);
        //then
        assertEquals(0, result);
    }

    @Test
    void find_shouldReturn1_whenOnlyRoot() {
        //given
        var root = new Node(3);
        //when
        var result = testee.find(root);
        //then
        assertEquals(1, result);
    }

    @Test
    void find_shouldReturn3_whenTree1() {
        //given
        var node8 = Node.ofStructure(8, null, 12);
        var node4 = new Node(4, null, node8);

        var node5 = Node.ofStructure(5, null, 9);
        var node2 = new Node(2, node4, node5);

        var node7 = Node.ofStructure(7, 10, 11);
        var node3 = new Node(3, new Node(6), node7);

        var root = new Node(1, node2, node3);
        //when
        var result = testee.find(root);
        //then
        assertEquals(3, result);
    }

    @Test
    void find_shouldReturn3_whenTree2() {
        //given
        var node5 = Node.ofStructure(5, 7, 8);
        var node3 = new Node(3, node5, new Node(6));
        var node2 = Node.ofStructure(2, 4, null);
        var root = new Node(1, node2, node3);
        //when
        var result = testee.find(root);
        //then
        assertEquals(3, result);
    }


    @Test
    void find_shouldReturn2_whenTreeWithTwoLevels() {
        //given
        var node2 = new Node(2);
        var root = new Node(1, node2, null);
        //when
        var result = testee.find(root);
        //then
        assertEquals(2, result);
    }

    @Test
    void find_shouldReturn4_whenTreeWithFourLevels() {
        //given
        var node4 = new Node(4);
        var node3 = new Node(3, node4, null);
        var node2 = new Node(2, node3, null);
        var root = new Node(1, node2, null);
        //when
        var result = testee.find(root);
        //then
        assertEquals(4, result);
    }
}