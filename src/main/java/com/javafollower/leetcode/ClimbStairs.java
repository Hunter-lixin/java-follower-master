package com.javafollower.leetcode;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 分析：
 * 假设我们到达楼顶需要n步，那么我们到达第n阶楼梯时，我们有那些方法呢？
 * 我们有2种方法，就是从第n-2阶直接跨2阶到达第n阶；我们也可以从第n-1阶跨1阶到达n阶。
 * 这就是典型的动态规划，dp[i] = dp[i-1] + dp[i-2].
 * 我们首先需要求出1~n-1的方法，才能求出到达第n阶的方法。
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
