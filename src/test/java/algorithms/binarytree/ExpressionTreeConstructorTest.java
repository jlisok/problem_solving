package algorithms.binarytree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ExpressionTreeConstructorTest {
    @InjectMocks
    private ExpressionTreeConstructor constructor;

    @ParameterizedTest
    @MethodSource("input")
    void construct(String postfixExpression, String expected) {
        //when
        var result = constructor.constructAndPrint(postfixExpression);
        //then
        assertEquals(expected, result);
    }


    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(
                        null,
                        null
                ),
                Arguments.of(
                        "",
                        null
                ),
                Arguments.of(
                        "ab+cde+**",
                        "((a+b)*(c*(d+e)))"
                ),
                Arguments.of(
                        " ab+cde+* *",
                        "((a+b)*(c*(d+e)))"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("invalidInput")
    void constructAndThrowError(String postfixExpression) {
        //when // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> constructor.constructAndPrint(postfixExpression));
    }


    private static Stream<String> invalidInput() {
        return Stream.of(
                "*3*",
                "2+3**",
                "2+3-7+*"
        );
    }
}