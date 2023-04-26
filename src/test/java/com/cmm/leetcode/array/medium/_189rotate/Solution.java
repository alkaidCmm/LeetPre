package com.cmm.leetcode.array.medium._189rotate;

/**
 * @author cmm
 * @date 2020/6/20 1:07 PM
 * @desc 将字符串 S 从第 K 位置分隔成两个子字符串，并交换这两个子字符串的位置。
 * Input:
 * S="abcXYZdef"
 * K=3
 *
 * Output:
 * "XYZdefabc"
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
