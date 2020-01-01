package com.javafollower.leetcode;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class MinPathSumTest {

    private MinPathSum solution = new MinPathSum();

    @Test
    public void minPathSum() {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Assert.assertThat(solution.minPathSum(grid), Is.is(7));
    }
}