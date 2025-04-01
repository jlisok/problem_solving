package algorithms.string;

/**
 * <a href="https://www.techiedelight.com/?problem=AlternateLevelsSumDifference/">link</a>
 * <p>
 * <b>string derieved from another string</b>
 * <p>
 * level: easy
 * <p>
 * Check if a given string can be derived from another string by circularly rotating it. The rotation can be in a
 * clockwise or anti-clockwise rotation.
 * Input:
 * X = "ABCD", Y = "DABC"
 * Output: true
 * Explanation: "DABC" can be derived from "ABCD" by right-rotating it by 1 unit
 * <p>
 */
public class DerivedChecker {

    public boolean check(String left, String right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.length() != right.length()) return false;
        if (left.equals(right)) return true;

        var rotation = left.length();
        var result = false;
        String rotatedRight = right;

        while (rotation > 0) {

            rotatedRight = rotatedRight.substring(1) + rotatedRight.charAt(0);
            if (left.equals(rotatedRight)) {
                result = true;
                break;
            }
            rotation = rotation - 1;
        }

        return result;
    }
}
