package algorithms.string;

/**
 * https://www.techiedelight.com/implement-strstr-function-java/
 * <p>
 * Implement strstr function in Java
 * <p>
 * Given a string, remove adjacent duplicates characters from it. In other words, remove all consecutive same characters except one
 * <p>
 * The prototype of the strstr() function is int strstr(String X, String Y);
 * example:
 * <p>
 * no examples provided :(
 **/
public class StrstrFunctionProvider {

    public int findIndex(String candidate, String pattern) {
        if (candidate == null || pattern == null) return -1;
        if (candidate.isEmpty()) return -1;
        if (pattern.isEmpty()) return 0;
        if (candidate.length() < pattern.length()) return -1;

        var patternSize = pattern.length();
        int headIndex = -1;
        for (int i = 0; i < candidate.length() - patternSize + 1; i++) {

            var tailIndex = i + patternSize;
            var substring = candidate.substring(i, tailIndex);
            if (substring.equals(pattern)) {
                headIndex = i;
                break;
            }

        }

        return headIndex;
    }
}
