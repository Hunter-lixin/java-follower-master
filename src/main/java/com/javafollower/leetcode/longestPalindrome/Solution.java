package com.javafollower.leetcode.longestPalindrome;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        String result = s.substring(0, 1);
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len + 1; j++) {
                String temp = s.substring(i, j);
                if (isPalindrime(temp) && temp.length() > max) {
                    result = temp;
                    max = Math.max(max, temp.length());
                }
            }
        }
        return result;
    }

    private boolean isPalindrime(String s) {
        for (int j = 0; j < s.length() / 2; j++) {
            if (s.charAt(j) != s.charAt(s.length() - j - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abab";
        Solution solution = new Solution();
        String result = solution.longestPalindrome(s);
        System.out.println(result);
    }
}
