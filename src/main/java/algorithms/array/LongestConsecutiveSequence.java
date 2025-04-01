package algorithms.array;


import java.util.HashSet;

/**
 * source: <a href="https://leetcode.com/problems/longest-consecutive-sequence/">LeetCode</a>
 * <p>
 * title: 128. Longest Consecutive Sequence
 * <p>
 * level: medium
 * <p>
 * Given an unsorted array of integers {@code nums}, this method returns
 * the length of the longest consecutive elements sequence.
 * <p>
 * The algorithm must run in O(n) time complexity.
 * </p>
 *
 * <p><strong>Example 1:</strong></p>
 * <pre>
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore, its length is 4.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <pre>
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 * <pre>
 * Input: nums = [1,0,1,2]
 * Output: 3
 * </pre>
 *
 * <p><strong>Constraints:</strong></p>
 * <ul>
 *   <li>0 <= nums.length <= 10⁵</li>
 *   <li>-10⁹ <= nums[i] <= 10⁹</li>
 * </ul>
 *
 * @param nums an unsorted array of integers
 * @return the length of the longest consecutive elements sequence
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        var set = new HashSet<Integer>(nums.length);
        for (int num : nums) set.add(num);

        int max = 1;

        for (int current : set) {
            if (set.contains(current - 1)) continue;

            int count = 1;
            while (set.contains(current + count)) count++;
            if (count > max) max = count;
        }

        return max;
    }
}
