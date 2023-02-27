package algorithms.binarytree;

import model.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class TreeCloneProviderTest {
    @InjectMocks
    private TreeCloneProvider provider;

    @ParameterizedTest
    @MethodSource("input")
    void clone(Node root) {
        //when
        var result = provider.clone(root);
        //then
        Assertions.assertEquals(root, result);
    }

    private static Stream<Node> input() {
        return Stream.of(
                null,
                new Node(1),
                new Node(
                        1,
                        new Node(3),
                        null
                ),
                new Node(
                        1,
                        new Node(3),
                        new Node(6)
                ),
                new Node(
                        1,
                        new Node(3, new Node(7), null),
                        new Node(6)
                ),
                new Node(1,
                        new Node(3, new Node(7), new Node(2)),
                        new Node(6)
                ),
                new Node(
                        1,
                        new Node(3, new Node(7), new Node(2)),
                        new Node(6, new Node(8), null)
                ),
                new Node(
                        1,
                        new Node(3, new Node(7), new Node(2)),
                        new Node(6, new Node(8), new Node(-1))
                )
        );
    }
}