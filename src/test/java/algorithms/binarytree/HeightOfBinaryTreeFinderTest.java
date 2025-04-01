package algorithms.binarytree;

import model.Node;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class HeightOfBinaryTreeFinderTest {
    @InjectMocks
    private HeightOfBinaryTreeFinder testee;

    @Test
    void findHeight_shouldReturn0_whenRootNull() {
        //when
        int result = testee.findHeight(null);
        //then
        assertEquals(0, result);
    }

    @Test
    void findHeight_shouldReturn1_whenOnlyRoot() {
        //given
        var root = new Node(6);
        //when
        int result = testee.findHeight(root);
        //then
        assertEquals(1, result);
    }

    @Test
    void findHeight_shouldReturn3_when2Levels() {
        //given
        var node6 = new Node(6);
        var node7 = new Node(7);
        var node3 = new Node(3, node6, node7);

        var node4 = new Node(4);
        var node5 = new Node(5);
        var node2 = new Node(2, node4, node5);

        var root = new Node(1, node2, node3);

        //when
        int result = testee.findHeight(root);
        //then
        assertEquals(3, result);
    }

    @Test
    void findHeight_shouldReturn4_when3Levels() {
        //given
        var node4 = new Node(4);
        var node3 = new Node(3, node4, null);
        var node2 = new Node(2, node3, null);
        var root = new Node(1, node2, null);

        //when
        int result = testee.findHeight(root);
        //then
        assertEquals(4, result);
    }

    @Test
    void findHeight_shouldReturn3_whenLeftMostDeepest() {
        //given
        var node3 = new Node(3);
        var node4 = new Node(4);
        var node2 = new Node(2, node4, null);
        var root = new Node(1, node2, node3);

        //when
        int result = testee.findHeight(root);
        //then
        assertEquals(3, result);
    }

    @Test
    void findHeight_shouldReturn3_whenRightMostDeepest() {
        //given
        var node7 = new Node(7);
        var node3 = new Node(3, null, node7);
        var node2 = new Node(2, null, null);
        var root = new Node(1, node2, node3);

        //when
        int result = testee.findHeight(root);
        //then
        assertEquals(3, result);
    }

    @Test
    void findHeight_shouldReturn3_whenMidDeepest() {
        //given
        var node6 = new Node(6);
        var node3 = new Node(3, node6, null);
        var node2 = new Node(2);
        var root = new Node(1, node2, node3);

        //when
        int result = testee.findHeight(root);
        //then
        assertEquals(3, result);
    }
}