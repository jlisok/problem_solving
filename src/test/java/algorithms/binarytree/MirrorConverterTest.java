package algorithms.binarytree;

import model.Node;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MirrorConverterTest {
    @InjectMocks
    private MirrorConverter testee;

    @Test
    void convert_shouldConvertNothing_whenRootNull() {
        //given
        Node root = null;
        //when
        testee.convert(root);
        //then
        assertNull(root);
    }

    @Test
    void convert_shouldConvertNothing_whenOnlyRoot() {
        //given
        var root = new Node(1);
        //when
        testee.convert(root);
        //then
        assertEquals(1, root.getValue());
        assertNull(root.getLeft());
        assertNull(root.getRight());
    }

    @Test
    void convert_shouldSwapChildren_when1LevelTree() {
        //given
        var root = Node.ofStructure(1, 2, null);
        //when
        testee.convert(root);
        //then
        assertEquals(1, root.getValue());
        assertEquals(2, root.getRight().getValue());
        assertNull(root.getLeft());
    }

    @Test
    void convert_shouldSwapChildren_whenSymmetricTree() {
        //given
        var node2 = Node.ofStructure(2, 4,5);
        var node3 = Node.ofStructure(3, 6,7);
        var root = new Node(1, node2, node3);
        //when
        testee.convert(root);
        //then
        assertEquals(1, root.getValue());
        assertEquals(2, root.getRight().getValue());
        assertEquals(5, node2.getLeft().getValue());
        assertEquals(4, node2.getRight().getValue());

        assertEquals(3, root.getLeft().getValue());
        assertEquals(7, node3.getLeft().getValue());
        assertEquals(6, node3.getRight().getValue());
    }
}