package com.cmm.leedcode.sort;

public class QuickSort {
	public static void quickSort(int[] num, int left, int right) {
		if (left < right) {
			int mid = getMid(num, left, right);
			quickSort(num, left, mid);
			quickSort(num, mid, right);
		}
	}

	private static int getMid(int[] num, int left, int right) {
		int cur = num[left];
		while (left < right) {
			while (left < right && num[right] >= cur)
				right--;
			num[right] = num[left];
			while (left < right && num[left] <= cur)
				left++;
			num[right] = num[left];
		}
		num[left] = cur;// 让这一轮的最后一个值与这一轮第一个值交换
		return left;
	}

	public static void quick(int[] num, int left, int right) {
		if (left < right) {
			int mid = getmiddle(num, left, right);
			quick(num, left, mid - 1);
			quick(num, mid + 1, right);
		}
	}

	private static int getmiddle(int[] num, int left, int right) {
		int cur = num[left];
		while (left < right) {
			while (left < right && num[right] > cur)
				right--;
			num[left] = num[right];
			while (left < right && num[left] > cur)
				left++;
			num[right] = num[left];
		}
		num[left] = cur;
		return left;
	}

}
