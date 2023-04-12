package algorithms.string;

import java.util.Objects;

/**
 * https://www.techiedelight.com/remove-adjacent-duplicates-characters-string/
 * <p>
 * Remove adjacent duplicate characters from a string
 * <p>
 * Given a string, remove adjacent duplicates characters from it. In other words, remove all consecutive same characters except one
 * <p>
 * example:
 * <p>
 * Input:  AABBBCDDD
 * <p>
 * Output: ABCD
 **/
public class AdjacentDuplicateRemover {

    public String removeAdjacent(String input) {
        if (input == null) return "";
        if (input.isEmpty()) return "";
        if (input.length() == 1) return input;

        var stringBuilder = new StringBuilder();
        Character previous = null;

        for (int i = 0; i < input.length(); i++) {
            Character current = input.charAt(i);

            if (!Objects.equals(previous, current)) {
                stringBuilder.append(current);
            }

            previous = current;
        }

        return stringBuilder.toString();
    }
}
