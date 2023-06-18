package com.cmm.leetcode._1775minOperations;

import java.util.stream.IntStream;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2022/6/23 08:43
 * @Author caimingming
 */
public class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length * 6 < nums2.length || nums1.length > nums2.length * 6) {
            return -1;
        }
        int sum1 = IntStream.of(nums1).sum();
        int sum2 = IntStream.of(nums2).sum();
        if (sum1 > sum2) {
            return minOperations(nums2, nums1); // make sure the sum of 1st array <= sum of 2nd one.
        }
        int[] cnt = new int[6]; // array used to count the increases in nums1 and the decreases in nums2.
        IntStream.of(nums1).forEach(n -> ++cnt[6 - n]);
        IntStream.of(nums2).forEach(n -> ++cnt[n - 1]);
        int i = 5, operations = 0;
        while (sum2 > sum1) {
            while (cnt[i] == 0) { // skip 0 count of increases or decreases.
                --i;
            }
            sum1 += i; // located current biggest increase or decrease.
            --cnt[i]; // deduct the count.
            ++operations; // increase the operation counter.
        }
        return operations;
    }

    public static void main(String[] args) {
        new Solution().minOperations(new int[]{1,2,3,4,5,6}, new int[]{1,1,2,2,2,2});
    }
}
