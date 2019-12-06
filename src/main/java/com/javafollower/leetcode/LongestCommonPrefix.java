package com.javafollower.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 *
 * 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String result = "";
        for (int i = 1; i <= strs[0].length(); i++) {
            String prefix = strs[0].substring(0, i);

            for (String str : strs) {
                if (!str.startsWith(prefix)) {
                    return result;
                }
            }
            result = prefix;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String result = solution.longestCommonPrefix(strs);
        System.out.println(result);
    }

}
