package com.cmm.leetcode.array._128longestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: cmm
 * @Date: 24/02/2018 3:26 PM
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * <p>
 * Your algorithm should run in O(n) complexity.
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set set = new HashSet<Integer>();
        for (int n : nums) {
            set.add(n);
        }
        int max = 1;
        for (int n : nums) {
            if (set.remove(n)) {
                int val = n;
                int sum = 1;
                while (set.remove(val - 1)) {
                    val--;
                }
                sum += n - val;
                while (set.remove(val + 1)) {
                    val++;
                }
                sum += val - n;
                max = Math.max(max, sum);
            }
        }
        return max;
    }



    public static void main(String[] args) {
        int nums[] = {2, 3, 4, 3, 3, 6, 6, 8, 9, 5, 4, 7, 11, 21, 23, 34};
        Solution s = new Solution();
        int result = s.longestConsecutive(nums);
        System.out.println(result);
    }
}