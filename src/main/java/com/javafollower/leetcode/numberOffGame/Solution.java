package com.javafollower.leetcode.numberOffGame;

/**
 * 有n个人围成一圈，顺序编号。从第1个人开始报数（从1-m报数），凡报到m的人退出圈子，问最后留下的是原来第几号的那位？
 */
public class Solution {
    public String numberOffGame(int maxCount, int num) {

        if (num <= 1) {
            return "";
        }

        int leftCount = maxCount;
        int[] array = new int[maxCount];
        int flag = 0;

        while (leftCount >= num) {
            for (int i = 0; i < maxCount; i++) {
                if (array[i] == 0) {
                    flag++;
                }
                if (flag == num) {
                    flag = 0;
                    array[i] = 1;
                    leftCount--;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                result.append(",").append(i + 1);
            }
        }
        return result.substring(1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.numberOffGame(11, 10);
        System.out.println(result);
    }

}
