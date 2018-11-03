package com.cmm.leedcode.bitManipulation.medium._260singleNumber3;

/**
 * @Author: cmm
 * @Date: 2018/9/10 1:20 AM
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int result[] = new int[2];
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }
        // TODO: 2018/9/10 why,shit
        int bit = xor & ~(xor - 1);
        int num1 = 0;
        int num2 = 0;

        for (int num : nums) {
            if ((num & bit) > 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        result[0] = num1;
        result[1] = num2;
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int a[] = {3, 1, 3, 2, 4, 5, 4, 5};
        System.out.println(s.singleNumber(a));
    }
}
