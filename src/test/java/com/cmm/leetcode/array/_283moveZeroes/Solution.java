package com.cmm.leetcode.array._283moveZeroes;

/**
 * Created by cmm on 2016/12/26.
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while ((index < nums.length)) {
            nums[index++] = 0;
        }
    }
}
