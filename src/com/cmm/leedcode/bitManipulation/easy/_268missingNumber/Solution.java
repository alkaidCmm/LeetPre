package com.cmm.leedcode.bitManipulation.easy._268missingNumber;

/**
 * @Author: cmm
 * @Date: 2018/9/10 1:49 AM
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class Solution {
    /**
     * The basic idea is to use XOR operation. We all know that a^b^b =a,
     * which means two xor operations with the same number will eliminate the number and reveal the original number.
     * In this solution, I apply XOR operation to both the index and value of the array.
     * In a complete array with no missing numbers,
     * the index and value should be perfectly corresponding( nums[index] = index),
     * so in a missing array, what left finally is the missing number.
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        // 0与任何数异或都是那个数本身
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        // 数据下标最大位置n还没异或
        return xor ^ i;
    }

    public static void main(String[] args) {
        int[] a = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        Solution s = new Solution();
        System.out.println(s.missingNumber(a));
    }
}
