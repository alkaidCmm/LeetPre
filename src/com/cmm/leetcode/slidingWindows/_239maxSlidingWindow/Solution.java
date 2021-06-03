package com.cmm.leetcode.slidingWindows._239maxSlidingWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author caimingming02
 * @date 2021/3/18 12:17 AM
 * @desc
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ret = new int[nums.length];
        if (nums.length < 1 || nums.length < k) {
            return ret;
        }
        List<Integer> retArr = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
        }
        ret[0] = priorityQueue.peek();
//        retArr.add(priorityQueue.peek());

        for (int i = 0, j = i + k; i < nums.length; i++) {
            priorityQueue.remove(nums[i]);
            priorityQueue.add(nums[j]);
//            retArr.add(priorityQueue.peek());
            ret[i] = priorityQueue.peek();
        }
        return ret;
    }
}
