package com.javafollower.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void sort(int[] nums) {
        int length = nums.length;

        if (length <= 1) return;

        for (int i = 1; i < length; i++) {

            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (nums[j] > value) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = value;
        }

    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 4, 6, 1, 8, 3, 7};
        System.out.println(Arrays.toString(nums));

        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
