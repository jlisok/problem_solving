package algorithms.binarytree;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import model.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class InorderPointerSetterTest {
    @InjectMocks
    private InorderPointerSetterToDo setter;

    @ParameterizedTest
    @MethodSource("input")
    void createSuccessorTree(Node root, List<Tuple2<Integer, Integer>> expected) {
        //when
        var result = setter.createNextPointers(root);
        //then
        Assertions.assertEquals(expected.size(), result.size());
        expected.forEach(entry -> Assertions.assertEquals(entry._2(), result.get(entry._1())));
    }


    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(
                        new Node(5, new Node(3), new Node(8)),
                        List.of(
                                Tuple.of(3, 5),
                                Tuple.of(5, 8),
                                Tuple.of(8, null)
                        )
                )
        );
    }
}