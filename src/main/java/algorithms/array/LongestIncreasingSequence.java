package algorithms.array;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <strong>Level:</strong> Medium<br>
 * <strong>Problem:</strong> 300. Longest Increasing Subsequence<br>
 * <strong>Link:</strong> <a href="https://leetcode.com/problems/longest-increasing-subsequence/">Longest Increasing Subsequence</a>
 * <p>
 * Given an integer array {@code nums}, return the length of the longest
 * strictly increasing subsequence.
 * </p>
 *
 * <p><strong>Example 1:</strong></p>
 * <pre>
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <pre>
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 * <pre>
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 * </pre>
 *
 * <p><strong>Constraints:</strong></p>
 * <ul>
 *   <li>1 <= nums.length <= 2500</li>
 *   <li>-10⁴ <= nums[i] <= 10⁴</li>
 * </ul>
 */
public class LongestIncreasingSequence {


    // time:    O(n^2)
    // space:   O(n)
    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;

        var memo = new int[nums.length];
        Arrays.fill(memo, 1);

        int max = 1;
        for (int j = nums.length - 2; j > -1; j--) {
            int node = nums[j];

            for (int i = j + 1; i < nums.length; i++) {

                int neighbour = nums[i];
                if (neighbour <= node) continue;

                int maxCandidate = memo[i] + 1;
                if (maxCandidate > memo[j]) {
                    memo[j] = maxCandidate;
                    max = Math.max(max, maxCandidate);
                }
            }
        }

        return max;
    }


    // im gonna leave it here. even though it is not optimal and slow just to mark my thought process
    public int lengthOfLISFirst(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;

        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = findMax(i, nums, new HashMap<>(2 * nums.length));
            if (max < count) max = count;
            if (max >= nums.length - i) break;
        }

        return max;
    }

    private int findMax(int idx, int[] nums, Map<Integer, Integer> memo) {
        if (memo.containsKey(idx)) return memo.get(idx);
        if (idx + 1 >= nums.length) return 1;

        int max = 1;
        int count = 1;
        int node = nums[idx];
        for (int i = idx + 1; i < nums.length; i++) {
            var neighbour = nums[i];
            if (neighbour <= node) continue;

            count = findMax(i, nums, memo) + 1;
            if (max < count) max = count;
        }

        memo.putIfAbsent(idx, max);
        return max;
    }
}


