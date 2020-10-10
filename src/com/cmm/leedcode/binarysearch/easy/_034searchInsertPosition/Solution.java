package com.cmm.leedcode.binarysearch.easy._034searchInsertPosition;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 * @author cmm
 *
 */
public class Solution {
	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			// 当出现target与nums中的数相等时，位置指向其左边
			if (nums[mid] < target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return low;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		System.out.println(new Solution().searchInsert(nums, 5));
		System.out.println((int) 1.5);
	}

}
