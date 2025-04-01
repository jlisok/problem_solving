package algorithms.binarytree;

import model.Node;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RootToLeafPathsPrinterTest {
    @InjectMocks
    private RootToLeafPathsPrinter testee;

    @Test
    void findRootToLeafPaths_shouldReturnEmptySet_whenRootNull() {
        //when
        var result = testee.findRootToLeafPaths(null);
        //then
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void findRootToLeafPaths_shouldReturn1List_whenOnlyRoot() {
        //given
        var root = new Node(1);
        var expected = List.of(1);
        //when
        var result = testee.findRootToLeafPaths(root);
        //then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(expected, result.iterator().next());
    }

    @Test
    void findRootToLeafPaths_shouldReturn1List_when4levelTree() {
        //given
        var node2 = Node.ofStructure(2,4,5);
        var node6 = Node.ofStructure(6, 8, null);
        var node7 = Node.ofStructure(7, null, 9);
        var node3 = new Node(3, node6, node7);
        var root = new Node(1, node2, node3);

        var expected = Set.of(
                List.of(1, 2, 4),
                List.of(1, 2, 5),
                List.of(1, 3, 6, 8),
                List.of(1, 3, 7, 9)
        );
        //when
        var result = testee.findRootToLeafPaths(root);
        //then
        assertNotNull(result);
        assertEquals(expected.size(), result.size());
        assertEquals(expected, result);
    }
}