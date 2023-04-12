package algorithms.binarytree;

import model.TreeNode;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class MirrorMTreeCreatorTest {
    @InjectMocks
    private MirrorMTreeCreator creator;

    @ParameterizedTest
    @MethodSource("input")
    void construct(TreeNode root, TreeNode expected) {
        //when
        creator.flipTree(root);
        //then
        assertEquals(expected, root);
    }


    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(
                        null,
                        null
                ),
                Arguments.of(
                        new TreeNode(5),
                        new TreeNode(5)
                ),
                Arguments.of(
                        new TreeNode(5, List.of(new TreeNode(3), new TreeNode(7))),
                        new TreeNode(5, List.of(new TreeNode(7), new TreeNode(3)))
                ),
                Arguments.of(
                        new TreeNode(
                                5,
                                List.of(
                                        new TreeNode(4, List.of(new TreeNode(11))),
                                        new TreeNode(7, List.of(new TreeNode(15), new TreeNode(18)))
                                )
                        ),
                        new TreeNode(
                                5,
                                List.of(
                                        new TreeNode(7, List.of(new TreeNode(18), new TreeNode(15))),
                                        new TreeNode(4, List.of(new TreeNode(11)))
                                )
                        )
                )
        );
    }
}