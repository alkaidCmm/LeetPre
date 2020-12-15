package com.cmm.leetcode.binarysearch.medium._032SearchRotatedSortedArray;

/**
 * 题意：旋转数组中查找一个数
 *
 * @author cmm
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if ((nums[mid]) == target)
                return mid;
            else {
                if (nums[left] <= nums[mid]) {// 左半部分有序，右半部份无序 5，6，7，8，9，3，4
                    if (target >= nums[left] && target < nums[mid])
                        right = mid - 1;
                    else
                        left = mid + 1;
                } else {// 右半部有序，左半部无序 8.9，1，2，3，4，5，6

                    if (target > nums[mid] && target <= nums[right]) {// 在右半部份
                        left = mid + 1;
                    } else
                        right = mid - 1;// 在左半部分
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1};
        System.out.println(new Solution().search(nums, 1));
    }
}
