package algorithms.string;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.techiedelight.com/find-interleavings-of-given-strings/
 * <p>
 * <b>Find all interleaving of given strings</b>
 * <p>
 * Find all interleavings of given strings that can be formed from all the characters of the first and second
 * string where the order of characters is preserved.
 * <p>
 * example:
 * <p>
 * ABC and ACB --> [ACBABC, AABCBC, ACABCB, ABCACB, AACBBC, ABACCB, ACABBC, ABACBC, AACBCB, AABCCB]
 **/
public class InterleaveAlgorithm {


    public Set<String> getInterleaves(String left, String right) {
        if (left == null || right == null) return Collections.emptySet();

        var result = new HashSet<String>();
        doRecursion(result, "", left, right);

        return result;
    }

    private void doRecursion(Set<String> result, String current, String left, String right) {
        if (left.isEmpty() && right.isEmpty()) {
            result.add(current);
            return;
        }

        if (!left.isEmpty()) doRecursion(result, current + left.charAt(0), left.substring(1), right);
        if (!right.isEmpty()) doRecursion(result, current + right.charAt(0), left, right.substring(1));
    }
}
