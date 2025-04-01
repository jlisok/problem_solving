package algorithms.binarytree;

import model.Node;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TransformCheckerTest {
    @InjectMocks
    private TransformChecker testee;


    @Test
    void check_shouldReturnTrue_whenRootsNull() {
        //when
        var result = testee.check(null, null);
        //then
        assertTrue(result);
    }

    @Test
    void check_shouldReturnFalse_whenOneRootNull() {
        //given
        var root = Node.ofStructure(1, null, null);
        //when
        var result = testee.check(root, null);
        //then
        assertFalse(result);
    }

    @Test
    void check_shouldReturnFalse_whenAdditionalLevel() {
        //given
        var root1 = Node.ofStructure(1, null, 2);
        var leaf = new Node(2, null, new Node(3));
        var root2 = new Node(1, null, leaf);
        //when
        var result = testee.check(root1, root2);
        //then
        assertFalse(result);
    }

    @Test
    void check_shouldReturnTrue_whenTreesIdentical() {
        //given
        var root1 = Node.ofStructure(1, 3, 2);
        var root2 = Node.ofStructure(1, 3, 2);
        //when
        var result = testee.check(root1, root2);
        //then
        assertTrue(result);
    }

    @Test
    void check_shouldReturnTrue_whenTreesSymmetric() {
        //given
        var root1 = Node.ofStructure(1, 2, 3);
        var root2 = Node.ofStructure(1, 3, 2);
        //when
        var result = testee.check(root1, root2);
        //then
        assertTrue(result);
    }

    @Test
    void check_shouldReturnFalse_whenTreesDifferent() {
        //given
        var root1 = Node.ofStructure(1, 2, 3);
        var root2 = Node.ofStructure(1, 5, 2);
        //when
        var result = testee.check(root1, root2);
        //then
        assertFalse(result);
    }
}