package algorithms.binarytree;

import model.Node;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class IdenticalBinaryTreeCheckerTest {
    @InjectMocks
    private IdenticalBinaryTreeChecker testee;

    @Test
    void isIdentical_shouldReturnTrue_whenBothTreesNull() {
        //when
        boolean result = testee.isIdentical(null, null);
        //then
        assertTrue(result);
    }

    @Test
    void isIdentical_shouldReturnTrue_whenBothTreesRootIdentical() {
        //given
        var node1 = new Node(5);
        var node2 = new Node(5);
        //when
        boolean result = testee.isIdentical(node1, node2);
        //then
        assertTrue(result);
    }

    @Test
    void isIdentical_shouldReturnFalse_whenBothTreesRootDifferent() {
        //given
        var node1 = new Node(4);
        var node2 = new Node(5);
        //when
        boolean result = testee.isIdentical(node1, node2);
        //then
        assertFalse(result);
    }

    @Test
    void isIdentical_shouldReturnTrue_whenBothHaveSameStructureAndContents() {
        //given
        var node6 = new Node(6);
        var node7 = new Node(7);
        var node3 = new Node(3, node6, node7);

        var node4 = new Node(4);
        var node5 = new Node(5);
        var node2 = new Node(2, node4, node5);

        var root1 = new Node(1, node2, node3);
        var root2 = new Node(1, node2, node3);

        //when
        boolean result = testee.isIdentical(root1, root2);
        //then
        assertTrue(result);
    }

    @Test
    void isIdentical_shouldReturnFalse_whenBothHaveDifferentStructures() {
        //given
        var node6 = new Node(6);
        var node7 = new Node(7);
        var node3 = new Node(3, node6, node7);

        var node4 = new Node(4);
        var node5 = new Node(5);
        var node2 = new Node(2, node4, node5);

        var root1 = new Node(1, node2, node3);

        var node26 = new Node(6);
        var node23 = new Node(3, node26, null);

        var node24 = new Node(4);
        var node25 = new Node(5);
        var node22 = new Node(2, node24, node25);

        var root2 = new Node(1, node22, node23);

        //when
        boolean result = testee.isIdentical(root1, root2);
        //then
        assertFalse(result);
    }

    @Test
    void isIdentical_shouldReturnFalse_whenBothHaveDifferentContents() {
        //given
        var node6 = new Node(6);
        var node7 = new Node(7);
        var node3 = new Node(3, node6, node7);

        var node4 = new Node(4);
        var node5 = new Node(5);
        var node2 = new Node(2, node4, node5);

        var root1 = new Node(1, node2, node3);

        var node26 = new Node(6);
        var node28 = new Node(8);
        var node23 = new Node(3, node26, node28);

        var node24 = new Node(4);
        var node25 = new Node(5);
        var node22 = new Node(2, node24, node25);

        var root2 = new Node(1, node22, node23);

        //when
        boolean result = testee.isIdentical(root1, root2);
        //then
        assertFalse(result);
    }
}