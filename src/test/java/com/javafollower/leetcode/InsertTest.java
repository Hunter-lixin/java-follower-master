package com.javafollower.leetcode;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class InsertTest {

    /**
     * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
     * 输出: [[1,5],[6,9]]
     */
    @Test
    public void TestInsert_1() {
        int[][] intervals = new int[][]{{1, 5}};
        int[] newInterval = new int[]{6, 8};

        int[][] result = new int[][]{{1, 5}, {6, 8}};
        Insert insert = new Insert();
        Assert.assertThat(insert.insert(intervals, newInterval), Is.is(result));
    }

    @Test
    public void TestInsert_2() {
        int[][] intervals = new int[][]{{1, 5}};
        int[] newInterval = new int[]{0, 0};

        int[][] result = new int[][]{{0, 0}, {1, 5}};
        Insert insert = new Insert();
        Assert.assertThat(insert.insert(intervals, newInterval), Is.is(result));
    }

}