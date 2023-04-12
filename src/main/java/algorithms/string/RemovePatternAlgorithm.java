package algorithms.string;

/**
 * https://www.techiedelight.com/inplace-remove-all-occurrences-ab-c-string/
 * <p>
 * <b>Remove all occurrences of `AB` and `C` from a string</b>
 * <p>
 * Given a string, remove all occurrences of AB and C in a single traversal of it.
 * <p>
 * example:
 * <p>
 * 'CBAABCAB' —> 'C BA AB C AB' —> 'BA' <p>
 * 'ABACB' —> 'AB'  —> '' <p>
 * 'ABCACBCAABB' —> 'ABAB' —> '' <p>
 **/
public class RemovePatternAlgorithm {
    private static final Character A_CHAR = 'A';
    private static final Character B_CHAR = 'B';
    private static final Character C_CHAR = 'C';


    public String remove(String input) {
        if (input == null) return "";
        if (input.isEmpty()) return input;
        if (input.isBlank()) return input;

        var result = new StringBuilder(); // byte array under the hood, charAt O(1), delete 'last' O(1)
        var lastIndex = -1; // to spare time to get result.size on every iteration step

        for (int i = 0; i < input.length(); i++) {
            var current = input.charAt(i);

            if (B_CHAR.equals(current) && result.length() != 0 && A_CHAR.equals(result.charAt(lastIndex))) {
                result.deleteCharAt(lastIndex);
                lastIndex--;
            } else if (!C_CHAR.equals(current)) {
                result.append(current);
                lastIndex++;
            }
        }

        return result.toString();
    }
}
