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
class LeftViewBinaryTreeTest {
    @InjectMocks
    private LeftViewBinaryTree testee;

    @Test
    void findLeftView_shouldReturnsEmptyList_whenRootNull() {
        //when
        var result = testee.findLeftView(null);
        //then
        assertTrue(result.isEmpty());
    }

    @Test
    void findLeftView_returnsLeftMembers_When4LevelTree() {
        //given
        var node7 = new Node(7);
        var node8 = new Node(8);
        var node5 = new Node(5, node7, node8);
        var node6 = new Node(6);
        var node3 = new Node(3, node5, node6);
        var node2 = new Node(2);
        var root = new Node(1, node2, node3);

        var expected = List.of(1, 2, 5, 7);
        //when
        var result = testee.findLeftView(root);
        //then
        assertEquals(expected, result);
    }

    @Test
    void findLeftView_returnsLeftMembers_When3LevelTree() {
        //given
        var node5 = new Node(5);
        var node3 = new Node(3, node5, null);
        var node4 = new Node(4);
        var node2 = new Node(2, null, node4);
        var root = new Node(1, node2, node3);

        var expected = List.of(1, 2, 4);
        //when
        var result = testee.findLeftView(root);
        //then
        assertEquals(expected, result);
    }
}