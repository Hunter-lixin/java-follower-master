package com.javafollower.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class RobTest {

    private Rob solution = new Rob();

    @Test
    public void testRob_1() {
        int[] nums = new int[]{1, 2, 3, 1};
        Assert.assertThat(solution.rob(nums), is(4));
    }

    @Test
    public void testRob_2() {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        Assert.assertThat(solution.rob(nums), is(12));
    }
}