package com.javafollower.leetcode;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class UniquePathsTest {

    @Test
    public void testUniquePaths_1() {
        int m = 3, n = 2;
        UniquePaths solution = new UniquePaths();
        Assert.assertThat(solution.uniquePaths(m, n), Is.is(3));
    }

    @Test
    public void testUniquePaths_2() {
        int m = 7, n = 3;
        UniquePaths solution = new UniquePaths();
        Assert.assertThat(solution.uniquePaths(m, n), Is.is(28));
    }
}