package algorithms.string;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/**
 * https://www.techiedelight.com/check-linked-list-strings-palindromic/<p>
 * <p>
 * Check if a linked list of strings is palindromic
 * <p>
 * Given a linked list of strings, check whether the concatenation of all values in the list together forms a palindrome.
 * It is not permissible to construct a string out of the linked list nodes and check that string for palindrome.
 * <p>
 * example:
 * <p>
 * Input:  AA —> XYZ —> CD —> C —> ZYX —> AA —> null
 * <p>
 * Output: true
 **/
public class PalindromLinkedListVerifier {

    public boolean checkIfPalindromString(LinkedList<String> palindromCandidate) {
        if (palindromCandidate == null || palindromCandidate.size() == 0) return false;

        var leftRightStringBuilder = new StringBuilder();
        palindromCandidate.forEach(leftRightStringBuilder::append);
        var leftRightString = leftRightStringBuilder.toString();

        var rightToLeftBuilder = new StringBuilder();
        palindromCandidate
                .descendingIterator()
                .forEachRemaining(item -> {
                            var reverseInput = new StringBuilder().append(item).reverse().toString();
                            rightToLeftBuilder.append(reverseInput);
                        }
                );

        var rightToLeftString = rightToLeftBuilder.toString();

        return Objects.equals(leftRightString, rightToLeftString);
    }

    public boolean checkIfPalindromRecursive(LinkedList<String> palindromCandidate) {
        if (palindromCandidate == null || palindromCandidate.size() == 0) return false;

        var ascendingBuilder = new StringBuilder();
        var descendingBuilder = new StringBuilder();
        doRecursion(palindromCandidate.iterator(), ascendingBuilder, descendingBuilder);

        var ascendingString = ascendingBuilder.toString();
        var descendingString = descendingBuilder.toString();

        return Objects.equals(ascendingString, descendingString);
    }

    private void doRecursion(Iterator<String> iterator, StringBuilder ascending, StringBuilder descending) {
        if (!iterator.hasNext()) return;

        var node = iterator.next();
        if (node == null) return;

        ascending.append(node);
        doRecursion(iterator, ascending, descending);

        var reverseInput = new StringBuilder().append(node).reverse().toString();
        descending.append(reverseInput);
    }

}
