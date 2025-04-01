package algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <strong>Level:</strong> Easy<br>
 * <strong>Problem:</strong> 303. Range Sum Query - Immutable<br>
 * <strong>Link:</strong> <a href="https://leetcode.com/problems/range-sum-query-immutable/">Range Sum Query - Immutable</a>
 * <p>
 * Given an integer array {@code nums}, handle multiple queries of the following type:
 * </p>
 * <ul>
 *   <li>Calculate the sum of the elements of {@code nums} between indices {@code left} and {@code right} (inclusive),
 *       where {@code left} <= {@code right}.</li>
 * </ul>
 * <p>
 * Implement the {@code NumArray} class:
 * </p>
 * <ul>
 *   <li>{@code NumArray(int[] nums)} - Initializes the object with the integer array {@code nums}.</li>
 *   <li>{@code int sumRange(int left, int right)} - Returns the sum of the elements of {@code nums}
 *       between indices {@code left} and {@code right} (inclusive).</li>
 * </ul>
 *
 * <p><strong>Example 1:</strong></p>
 * <pre>
 * Input:
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 *
 * Output:
 * [null, 1, -1, -3]
 *
 * Explanation:
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
 * numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
 * numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 * </pre>
 *
 * <p><strong>Constraints:</strong></p>
 * <ul>
 *   <li>1 <= nums.length <= 10⁴</li>
 *   <li>-10⁵ <= nums[i] <= 10⁵</li>
 *   <li>0 <= left <= right < nums.length</li>
 *   <li>At most 10⁴ calls will be made to {@code sumRange}.</li>
 * </ul>
 */
public class NumArray {
    private final List<Integer> cumulative;

    public NumArray(int[] nums) {
        cumulative = calculate(nums);
    }

    public List<Integer> calculate(int[] nums) {
        var result = new ArrayList<Integer>(nums.length);
        result.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            var previous = result.getLast();
            result.add(previous + nums[i]);
        }

        return result;
    }

    public int sumRange(int left, int right) {
        if (right < left) return 0;
        if (left == 0) return cumulative.get(right);

        return cumulative.get(right) - cumulative.get(left - 1);
    }
}
