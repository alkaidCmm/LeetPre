package com.cmm.leetcode._268missingNumber;

/**
 * @author cmm
 * @date 2020/6/20 12:04 PM
 * @desc Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        // 0与任何数异或都是那个数本身(异或：同值取0，异值取1)
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        // 数据下标最大位置n还没异或
        return xor ^ i;
    }
}
