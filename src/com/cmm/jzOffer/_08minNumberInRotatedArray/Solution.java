package com.cmm.jzOffer._08minNumberInRotatedArray;

/**
 * 题意：旋转数组中最小的数 思路：其实旋转过后的数组是部分有序的，这样的数组依然可以使用折半查找的思路进行求解
 * 
 * @author cmm
 *
 */
public class Solution {
	public int findMinInRotatedArray(int array[]) {
		int low = 0;
		int high = array.length - 1;
		int mid = low;
		while (array[low] > array[high]) {
			if (high - low == 1) {// 最大的数与最小的数相邻
				mid = high;
				break;
			}
			mid = (low + high) / 2;
			// 如果中间位置对应的值在前一个排好序的部分，将low设置为新的处理位置 
			if (array[mid] >= array[low])
				low = mid;
			// 如果中间位置对应的值在后一个排好序的部分，将high设置为新的处理位置 
			else if (array[mid] <= array[high])
				high = mid;

		}
		return array[mid];
	}

	public static void main(String[] args) {
		int array[] = { 5, 6, 7, 0, 1, 2, 3, 4 };
		System.out.println(new Solution().findMinInRotatedArray(array));
	}
}
