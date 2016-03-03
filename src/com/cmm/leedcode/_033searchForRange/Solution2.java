package com.cmm.leedcode._033searchForRange;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * @author cmm
 *
 */
public class Solution2 {
	public int[] searchRange(int[] A, int target) {
		int[] res = new int[2];
		res[0] = lowerbound(A, target);
		res[1] = upperbound(A, target);
		return res;
	}

	public static int upperbound(int[] num, int target) {// 上限
		// find last 2,
		int low = 0;
		int high = num.length - 1;
		int mid = low + (high - low + 1) / 2;

		while (low < high) {
			mid = low + (high - low + 1) / 2;
			if (num[mid] <= target) {
				low = mid;
			} else {
				high = mid - 1;
			}
		}
		return num[low] == target ? low : -1;
	}

	public static int lowerbound(int[] num, int target) {// 下限
		// find first 2.
		int low = 0;
		int high = num.length - 1;
		int mid = low + (high - low) / 2;

		while (low < high) {
			mid = low + (high - low) / 2;
			if (num[mid] >= target) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return num[high] == target ? high : -1;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int res[] = new Solution2().searchRange(nums, 8);
		// System.out.println("qqq" + res.length);
		System.out.println(res[0] + "," + res[1]);
	}

}
