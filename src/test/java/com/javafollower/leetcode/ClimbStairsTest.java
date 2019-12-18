package com.javafollower.leetcode;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ClimbStairsTest {

    ClimbStairs solution = new ClimbStairs();

    @Test
    public void climbStairs() {
        assertThat(solution.climbStairs(1), is(1));
        assertThat(solution.climbStairs(2), is(2));
        assertThat(solution.climbStairs(3), is(3));
    }
}