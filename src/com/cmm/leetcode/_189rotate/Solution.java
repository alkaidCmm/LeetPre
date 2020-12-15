package com.cmm.leetcode._189rotate;

/**
 * @author cmm
 * @date 2020/6/20 1:07 PM
 * @desc
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }

    private void swap(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        s.rotate(nums, 3);
        System.out.println(nums);
    }
}
