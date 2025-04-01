package algorithms.binarytree;

import model.Node;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SumProviderTest {
    @InjectMocks
    private SumProvider testee;

    @Test
    void transform_shouldTransformNothing_whenRootNull() {
        //given
        Node root = null;
        //when
        testee.transform(root);
        //then
        assertNull(root);
    }

    @Test
    void transform_shouldTransformNothing_whenOnlyRoot() {
        //given
        Node root = new Node(5);
        //when
        testee.transform(root);
        //then
        assertEquals(0, root.getValue());
    }

    @Test
    void transform_shouldTransform_when2LevelSymmetricTree() {
        //given
        Node root = Node.ofStructure(1, 3, 5);
        //when
        testee.transform(root);
        //then
        assertEquals(8, root.getValue());
        assertEquals(0, root.getLeft().getValue());
        assertEquals(0, root.getRight().getValue());
    }

    @Test
    void transform_shouldTransform_when2LevelAsymmetricTree() {
        //given
        Node root = Node.ofStructure(1, null, 5);
        //when
        testee.transform(root);
        //then
        assertEquals(5, root.getValue());
        assertNull(root.getLeft());
        assertEquals(0, root.getRight().getValue());
    }
}