package algorithms.binarytree;

import lombok.NonNull;
import model.CharNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://www.techiedelight.com/expression-tree/">link</a>
 * <p>
 * <b>Construction of an expression tree</b>
 * <p>
 * Construct an expression tree from a given postfix notation and print the infix notation.
 * The binary expression tree is a binary tree whose leaves are operands, such as constants or
 * variable names, and the other nodes contain operators.
 * For example, the postfix notation a b + c d e + * * results in the following expression tree.
 * The corresponding infix notation is (a+b)*(c*(d+e)) which can be produced by traversing the expression tree in an inorder fashion.
 * However, an opening and closing parenthesis must be added at the beginning and end of each expression (every subtree represents a subexpression).
 *
 * <p>
 * Dodatkowe założenia: algorytm przyjmuje tylko symbole alfabetu łacińskiego i nieujemne
 */
public class ExpressionTreeConstructor {
    private static final List<String> PARENTHESES = List.of("(", ")");

    String constructAndPrint(String postfixExpression) {
        if (postfixExpression == null || postfixExpression.isBlank()) return null;

        var root = construct(postfixExpression);
        var builder = new StringBuilder();

        printInorder(root, builder);
        return builder.toString();
    }

    private CharNode construct(@NonNull String postfixExpression) {
        var stack = new LinkedList<CharNode>();

        for (Character item : postfixExpression.toCharArray()) {
            if (item.equals(' ')) continue;

            var node = new CharNode(item);
            if (!isLetter(item)) {

                validateChildrenCandidates(stack);
                node.setRight(stack.pop());
                node.setLeft(stack.pop());

            }

            stack.push(node);
        }

        validateRoot(stack);
        return stack.pop();
    }

    private boolean isLetter(char candidate) {
        return Character.isLetter(candidate);
    }

    private void validateChildrenCandidates(LinkedList<CharNode> stack) {
        if (stack.size() < 2) {
            throw new IllegalArgumentException("Invalid input, that does not represent mathematical expression in a postfix manner");
        }
    }

    private void validateRoot(LinkedList<CharNode> stack) {
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid input, that does not represent valid tree");
        }
    }

    private void printInorder(CharNode node, StringBuilder builder) {
        if (node == null) return;

        var left = node.getLeft();
        var right = node.getRight();
        var hasChildren = !(left == null && right == null);

        if (hasChildren) builder.append(PARENTHESES.get(0));

        printInorder(left, builder);
        builder.append(node.getValue());
        printInorder(right, builder);

        if (hasChildren) builder.append(PARENTHESES.get(1));
    }
}
