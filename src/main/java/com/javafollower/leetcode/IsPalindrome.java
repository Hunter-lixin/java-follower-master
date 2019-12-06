package com.javafollower.leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * 输入: 121
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        int temp = x;
        int help = 1;
        while (temp > 10) {
            help *= 10;
            temp /= 10;
        }

        while (x != 0) {
            if (x % 10 != x / help) {
                return false;
            }

            x = x % help / 10;
            help /= 100;
        }

        return true;
    }


    public static void main(String[] args) {
        int num = 1001;
        IsPalindrome solution = new IsPalindrome();
        boolean isPalindrome = solution.isPalindrome(num);
        System.out.println(isPalindrome);
    }
}
