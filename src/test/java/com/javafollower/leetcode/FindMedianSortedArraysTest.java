package com.javafollower.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class FindMedianSortedArraysTest {

    FindMedianSortedArrays solution = new FindMedianSortedArrays();

    @Test
    public void testFindMedianSortedArrays_first() {
        int[] num1 = new int[]{1, 3};
        int[] num2 = new int[]{2};
        Assert.assertEquals(2.0, solution.findMedianSortedArrays(num1, num2), 0.0);
    }

    @Test
    public void testFindMedianSortedArrays_sencod() {
        int[] num1 = new int[]{1, 2};
        int[] num2 = new int[]{3, 4};
        Assert.assertEquals(2.5, solution.findMedianSortedArrays(num1, num2), 0.0);
    }
}
