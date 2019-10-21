package com.javafollower.leetcode.letterCombinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Solution {

    private String[] letterMap = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private List<String> result;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (Objects.equals(digits, "")) {
            return result;
        }

        findCombinations(digits, 0, "");

        return result;
    }

    private void findCombinations(String digists, int index, String string) {

        if (index == digists.length()) {
            result.add(string);
            return;
        }

        char character = digists.charAt(index);
        String letters = letterMap[character - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombinations(digists, index + 1, string + letters.charAt(i));
        }
    }

    public static void main(String[] args) {
        String digists = "13";
        Solution solution = new Solution();
        List<String> result = solution.letterCombinations(digists);
        System.out.println(result);
    }
}
