package com.javafollower.leetcode;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxSubArrayTest {

    MaxSubArray solution = new MaxSubArray();

    @Test
    public void maxSubArray() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertThat(solution.maxSubArray(nums), is(6));
    }

}