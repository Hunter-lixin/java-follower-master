package com.javafollower.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MergeTest {

    /**
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     */
    @Test
    public void merge_1() {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = new int[][]{{1, 6}, {8, 10}, {15, 18}};
        Merge merge = new Merge();
        Assert.assertThat(merge.merge(intervals), is(result));
    }

    @Test
    public void merge_2() {
        int[][] intervals = new int[][]{{1, 4}, {4, 5}};
        int[][] result = new int[][]{{1, 5}};
        Merge merge = new Merge();
        Assert.assertThat(merge.merge(intervals), is(result));
    }
}