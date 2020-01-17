package com.javafollower.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 *
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int[] merge = newInterval;
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[0] && interval[1] >= newInterval[0]
                    || interval[0] <= newInterval[1] && interval[1] >= newInterval[1]) {

                if (interval[0] <= newInterval[0] && interval[1] >= newInterval[0]) {
                    merge[0] = interval[0];
                }
                if (interval[0] <= newInterval[1] && interval[1] >= newInterval[1]) {
                    merge[1] = interval[1];
                }
            }
        }

        List<int[]> mergeList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] < merge[0]) {
                mergeList.add(interval);
                continue;
            } else {
                if (!mergeList.contains(merge)) {
                    mergeList.add(merge);
                }
            }
            if (interval[0] <= merge[1]) {
                if (!mergeList.contains(merge)) {
                    mergeList.add(merge);
                }
            } else {
                mergeList.add(interval);
            }
        }
        if (!mergeList.contains(merge)) {
            mergeList.add(merge);
        }
        return mergeList.toArray(new int[mergeList.size()][2]);
    }
}
