package com.javafollower.leetcode.reverse;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 *  示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Solution {

    public int reverse(int x) {
        if (x == 0) return 0;
        int result = 0;
        int num = x;
        if (x < 0) num = -x;
        while (num > 0) {
            if (result > Integer.MAX_VALUE / 10) return 0;

            int temp = num % 10;
            result = result * 10 + temp;
            num = (num - temp) / 10;
        }
        if (x < 0) result = -result;
        return result;
    }

    public static void main(String[] args) {
        int num = 1534236469;
        Solution solution = new Solution();
        int result = solution.reverse(num);
        System.out.println(result);
    }
}
