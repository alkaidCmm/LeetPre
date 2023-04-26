package com.cmm.leetcode.others._56mergeInterval;

import com.cmm.leetcode.others.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cmm
 * @Date: 2018/5/14 1:05 AM
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            insert(result, intervals.get(i));
        }
        return result;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            // 新插入的interval小于当前左边界
            if (newInterval.end < cur.start) {
                intervals.add(newInterval);
                return intervals;
            }
            // 新插入的interval大于当前右边界
            else if (newInterval.start > cur.end) {
                ++i;
                continue;
            }
            // 存在边界交集
            else {
                newInterval.start = Math.min(cur.start, newInterval.start);
                newInterval.end = Math.min(cur.end, newInterval.end);
                // 删除原先交集部分
                intervals.remove(i);
            }
        }
        intervals.add(newInterval);
        return intervals;
    }
}
