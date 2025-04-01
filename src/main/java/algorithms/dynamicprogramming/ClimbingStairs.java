package algorithms.dynamicprogramming;


import java.util.HashMap;
import java.util.Map;

/**
 * source: <a href="https://leetcode.com/problems/climbing-stairs/">LeetCode</a>
 * <p>
 * title: 70. Climbing Stairs
 * <p>
 * level: easy
 * <p>
 * You are climbing a staircase. It takes {@code n} steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. This method calculates
 * the number of distinct ways you can climb to the top.
 * </p>
 *
 * <p><strong>Example 1:</strong></p>
 * <pre>
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <pre>
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * </pre>
 *
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        var memo = new HashMap<Integer, Integer>();

        return climb(n, memo);
    }

    private int climb(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) return memo.get(n);

        if (n == 0) return 1;
        if (n < 0) return 0;

        var result = climb(n - 1, memo) + climb(n - 2, memo);
        memo.put(n, result);

        return result;
    }

    public int climbStairsBottomUp(int n) {
        if (n < 3) return n;

        var first = 1;
        var second = 2;

        for (int i = 2; i < n; i++) {
            var current = second + first;
            first = second;
            second = current;
        }

        return second;
    }
}
