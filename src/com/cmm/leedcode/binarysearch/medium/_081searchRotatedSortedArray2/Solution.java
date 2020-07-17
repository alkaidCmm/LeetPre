package com.cmm.leedcode.binarysearch.medium._081searchRotatedSortedArray2;

/**
 * @author cmm
 * @date 2020/7/17 11:47 AM
 * @desc Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 * <p>
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
public class Solution {


    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] < nums[mid]) {
                if (target<nums[mid]  && target>=nums[left]  ) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if(nums[left]>nums[mid]){
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }else {
                left++;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 1, 1, 1};
        new Solution().search(nums, 3);

    }
}
