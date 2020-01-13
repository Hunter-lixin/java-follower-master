package com.javafollower.leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Merge {
    private static class InterVal {
        int start;
        int end;

        InterVal(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }

        int[] toArray() {
            return new int[]{this.start, this.end};
        }
    }

    private static class InterValComparator implements Comparator<InterVal> {
        @Override
        public int compare(InterVal a, InterVal b) {
            return Integer.compare(a.start, b.start);
        }
    }

    public int[][] merge(int[][] intervals) {
        List<InterVal> interValList = new LinkedList<>();
        for (int[] interval : intervals) {
            interValList.add(new InterVal(interval));
        }
        interValList.sort(new InterValComparator());

        LinkedList<InterVal> merged = new LinkedList<>();
        for (InterVal interVal : interValList) {
            if (merged.isEmpty() || merged.getLast().end < interVal.start) {
                merged.add(interVal);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, interVal.end);
            }
        }

        int i = 0;
        int[][] result = new int[merged.size()][2];
        for (InterVal interVal : merged) {
            result[i] = interVal.toArray();
            i++;
        }
        return result;
    }

}
