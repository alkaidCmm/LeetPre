package com.cmm.leedcode._033searchForRange;

public class Solution {
	public int[] searchRange(int[] nums, int target) {
		int res[] = { -1, -1 };
		if (nums == null || nums.length == 0)
			return res;
		if (nums.length == 1) {
			if (nums[0] == target) {
				res[0] = 0;
				res[1] = 0;
				return res;
			} else
				return res;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			if (target == nums[left])
				res[0] = left;
			else if (target < nums[left])
				res[0] = -1;
			else
				left++;
			if (target == nums[right])
				res[1] = right;
			else if (target > nums[right])
				res[1] = -1;
			else
				right--;
			System.out.print("left=" + left + ",right=" + right);
			System.out.print(nums[left] == nums[right]);
			System.out.println("," + res[0] + "," + res[1]);
			if (nums[left] == nums[right]) {
				res[0] = left;
				res[1] = right;
				break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 6 };
		int res[] = new Solution().searchRange(nums, 8);
		System.out.println("qqq" + res.length);
		System.out.println(res[0] + "," + res[1]);
		/*
		 * for(int i=0;i<res.length-1;i++){ System.out.println(res[i]); }
		 */
	}

}
