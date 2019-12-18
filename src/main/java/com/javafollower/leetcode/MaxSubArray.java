package com.javafollower.leetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * <p>
 * 输出: 6
 * <p>
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 解题思路：
 * <p>
 * 下面介绍动态规划的做法，复杂度为 O(n)。
 * <p>
 * 步骤 1：令状态 dp[i] 表示以 A[i] 作为末尾的连续序列的最大和（这里是说 A[i]必须作为连续序列的末尾）。
 * <p>
 * 步骤 2：做如下考虑：因为 dp[i] 要求是必须以 A[i] 结尾的连续序列，那么只有两种情况：
 * <p>
 * 这个最大和的连续序列只有一个元素，即以 A[i] 开始，以 A[i] 结尾。
 * <p>
 * 这个最大和的连续序列有多个元素，即从前面某处 A[p] 开始 (p<i)，一直到 A[i] 结尾。
 * <p>
 * 对第一种情况，最大和就是 A[i] 本身。
 * <p>
 * 对第二种情况，最大和是 dp[i-1]+A[i]。
 * <p>
 * 于是得到状态转移方程：
 * <p>
 * dp[i] = max{A[i], dp[i-1]+A[i]}
 * <p>
 * 这个式子只和 i 与 i 之前的元素有关，且边界为 dp[0] = A[0]，由此从小到大枚举 i，即可得到整个 dp 数组。接着输出 dp[0]，dp[1]，...，dp[n-1] 中的最大子即为最大连续子序列的和。
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

}
