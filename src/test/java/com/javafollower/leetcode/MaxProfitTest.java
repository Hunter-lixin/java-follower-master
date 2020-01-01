package com.javafollower.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class MaxProfitTest {

    @Test
    public void testMaxProfit_1() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        MaxProfit maxProfit = new MaxProfit();
        Assert.assertThat(maxProfit.maxProfit(prices), is(5));
    }

    @Test
    public void testMaxProfit_2() {
        int[] prices = new int[]{7, 6, 4, 3, 1};

        MaxProfit maxProfit = new MaxProfit();
        Assert.assertThat(maxProfit.maxProfit(prices), is(0));
    }
}