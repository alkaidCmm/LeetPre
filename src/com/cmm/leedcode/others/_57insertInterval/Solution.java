package com.cmm.leedcode.others._57insertInterval;

import com.cmm.leedcode.others.Interval;

import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * @Author: cmm
 * @Date: 2018/5/14 12:47 AM
 */
public class Solution {
    /**
     * 注意刚开始的存入List里面的集合是排序过的
     *
     * @param intervals
     * @param newInterval
     * @return
     */
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
