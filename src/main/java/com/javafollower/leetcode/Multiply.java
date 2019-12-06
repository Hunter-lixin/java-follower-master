package com.javafollower.leetcode;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] arr1 = new int[num1.length()];
        int[] arr2 = new int[num2.length()];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = num1.charAt(i) - '0';
        }

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = num2.charAt(i) - '0';
        }

        int maxLength = num1.length() + num2.length() + 1;
        int[] res = new int[maxLength];
        int m = 0, temp, extra;
        for (int i = arr1.length - 1; i >= 0; i--) {
            for (int j = arr2.length - 1; j >= 0; j--) {
                temp = arr1[i] * arr2[j];
                m = (arr1.length - 1 - i) + (arr2.length - 1 - j);
                res[m] += temp;
                while (res[m] >= 10) {
                    extra = res[m] / 10;
                    res[m] = res[m] % 10;
                    m++;
                    res[m] += extra;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = m; i >= 0; i--) {
            result.append(res[i]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        Multiply solution = new Multiply();
        String result = solution.multiply(num1, num2);
        System.out.println(result);
    }
}
