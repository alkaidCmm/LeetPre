package com.cmm.leedcode.binarysearch.medium._034searchForRange;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non decreasing array.
 * -10^9 <= target <= 10^9
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ret[] = {-1, -1};

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 左值
        if (left >= nums.length || nums[left] != target) {
            return ret;
        }
        ret[0] = left;
        // right初始值重置
        right = nums.length-1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 右值
        if (right <0||nums[right] != target) {
            ret[1] = ret[0];
            return ret;
        }
        ret[1] = right;

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int res[] = new Solution().searchRange(nums, 8);
        System.out.println(res[0] + "," + res[1]);
    }

}
