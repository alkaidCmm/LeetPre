package com.cmm.leetcode.array.easy._035searchInsert;

/**
 * @author caimingming02
 * @date 2021/3/9 11:52 PM
 * @desc https://leetcode.com/problems/search-insert-position/
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left++;
            } else if (nums[mid] > target) {
                right--;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return left;

    }
}
