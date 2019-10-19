package com.javafollower.leetcode.threeSumClosest;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。<br/>
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.<br/>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).<br/>
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int threeSum = nums[i] + nums[l] + nums[r];
                if (Math.abs(threeSum - target) < Math.abs(closest - target)) {
                    closest = threeSum;
                }
                if (threeSum > target) {
                    r--;
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (threeSum < target) {
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                } else {
                    return threeSum;
                }
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        int target = 1;
        int[] nums = {-1, 2, 1, -4, 0};
        Solution solution = new Solution();
        int result = solution.threeSumClosest(nums, target);
        System.out.println(result);
    }
}
