package com.javafollower.leetcode;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if ("".equals(s) || s == null) {
            return 0;
        }
        int i = 0, j, k, max = 0, size;
        String[] array = s.split("");
        size = array.length;
        for (j = 0; j < size; j++) {
            for (k = i; k < j; k++) {
                if (array[j].equals(array[k])) {
                    i = k + 1;
                    break;
                }
            }
            if (j - i + 1 > max) {
                max = j - i + 1;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        int max = solution.lengthOfLongestSubstring(s);
        System.out.println(max);

    }
}
