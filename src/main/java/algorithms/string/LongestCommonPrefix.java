package algorithms.string;

import java.util.List;

/**
 * https://www.techiedelight.com/check-linked-list-strings-palindromic/<p>
 * <p>
 * Longest Common Prefix (LCP) Problem
 * <p>
 * Write an efficient algorithm to find the longest common prefix (LCP) between a given set of strings.
 * <p>
 * example:
 * <p>
 * Input:  technique, technician, technology, technical <p>
 * Output: The longest common prefix is techn
 **/
public class LongestCommonPrefix {

    public String check(List<String> input) {
        if (input == null) return "";
        if (input.size() == 0) return "";
        if (input.size() == 1) return input.get(0);

        String commonPrefix = input.get(input.size() - 1);
        for (int j = 0; j < input.size() - 1; j++) {

            var current = input.get(j);

            for (int i = 0; i < commonPrefix.length(); i++) {

                if (current.length() - 1 < i || commonPrefix.charAt(i) != current.charAt(i)) {
                    commonPrefix = commonPrefix.substring(0, i);
                    break;
                }

            }

            if (commonPrefix.length() == 0) break;
        }

        return commonPrefix;
    }

}
