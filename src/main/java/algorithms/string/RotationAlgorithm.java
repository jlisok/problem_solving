package algorithms.string;

/**
 * https://www.techiedelight.com/check-strings-can-derived-circularly-rotating/
 * <p>
 * <b>Check if strings can be derived from each other by circularly rotating them</b>
 * <p>
 * Check if a given string can be derived from another string by circularly rotating it. The rotation can be in a
 * clockwise or anti-clockwise rotation.
 *
 * <p>
 * example:
 * <p>
 * X = ABCD, Y = DABC --> true, 1
 **/
public class RotationAlgorithm {

    public int countRotation(String left, String right) {
        if (left == null || right == null) return -1;
        if (left.length() != right.length()) return -1;

        return doRecursion(0, left, right);
    }

    private int doRecursion(int count, String left, String right) {
        var lastIndex = left.length() - 1;

        if (count > lastIndex) return -1;
        if (left.equals(right)) return count;

        var newLeft = left.charAt(lastIndex) + left.substring(0, lastIndex);
        return doRecursion(count + 1, newLeft, right);
    }
}
