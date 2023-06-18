package com.cmm.leetcode.array._57insertInterval;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2022/6/28 09:11
 * @Author caimingming
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];

        List<int[]> ret = new ArrayList();
        int i = 0;
        // 插入值左边界大于列表右边界，则直接插入
        while (i < intervals.length && intervals[i][1] < left) {
            ret.add(intervals[i++]);
        }

        // 插入值左边界小于等于列表右边界，
        // 且插入值 右边界大于等于列表左边界， 即存在交集
        // 此处可能存在多轮合并，但最终只有一个交集
        while (i < intervals.length && intervals[i][0] <= right) {
            left = Math.min(intervals[i][0], left);
            right = Math.max(intervals[i][1], right);
            i++;
        }
        ret.add(new int[]{left, right});
        while (i < intervals.length) {
            ret.add(intervals[i++]);
        }

        int[][] result = new int[ret.size()][2];
        for (int k = 0; k < ret.size(); k++) {
            result[k][0] = ret.get(k)[0];
            result[k][1] = ret.get(k)[1];
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().insert(new int[][]{{1, 2}, {3, 5}, {4, 8}, {12, 20}}, new int[]{7, 14});
    }
}
