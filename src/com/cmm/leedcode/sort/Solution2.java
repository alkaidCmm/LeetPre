package com.cmm.leedcode.sort;

public class Solution2 {

	/**
	 * 快速排序
	 * 
	 * @param num
	 * @param low
	 * @param high
	 */
	public static void quickSort(int[] num, int low, int high) {
		if (low < high) {
			int partition = partitionElements(num, low, high);
			quickSort(num, low, partition - 1);
			quickSort(num, partition + 1, high);
		}
	}

	private static int partitionElements(int[] num, int low, int high) {
		int cur = num[low];// 基准元素
		while (low < high) {
			while (low < high && num[high] >= cur)
				high--;
			num[low] = num[high];
			System.out.println("num[low]=" + num[low]);
			while (low < high && num[low] <= cur)
				low++;
			num[high] = num[low];
			System.out.println("num[high]=" + num[high]);
		}
		num[low] = cur;
		return low;
	}

	/**
	 * 选择排序
	 * 
	 * @param num
	 */
	public static void selectSort(int[] num) {
		int length = num.length;

		for (int i = 0; i < length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < length; j++)
				if (num[min] > num[j])
					min = j;
			if (min != i) {// 最小值不在开始位置，开始位置与最小值位置互换
				int temp = num[min];
				num[min] = num[i];
				num[i] = temp;
			}

		}
	}

	/**
	 * 打印
	 * 
	 * @param array
	 */
	public static void printArray(int[] array) {
		System.out.print("{");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}

	public static int[] select(int num[]) {
		int i = 0;
		int j = 0;
		for (i = 0; i < num.length - 1; i++) {
			int minId = i;
			for (j = i; j < num.length - i; j++)
				if (num[minId] > num[j])
					minId = j;
			if (minId != i) {
				int temp = num[minId];
				num[minId] = num[i];
				num[i] = temp;
			}
		}
		return num;
	}

	/**
	 * 堆排序
	 */
	public static int[] buildMaxHeap(int[] num) {
		for (int i = (num.length - 2) / 2; i >= 0; i--)
			adjustFromupToDown(num, i, num.length);
		return num;
	}

	private static void adjustFromupToDown(int[] num, int i, int length) {
		int cur = num[i];
		for (int left = 2 * i + 1; left < num.length - 1; left = left * 2 + 1) {
			if (num[left] < num[left + 1])
				left++;
			if (cur > num[left])
				break;
			else {
				num[i] = num[left];
				i = left;
			}
		}
		num[i] = cur;
	}

	public static int[] heap(int[] num) {
		num = buildMaxHeap(num);
		for (int i = num.length - 1; i >= 0; i--) {
			int temp = num[0];
			num[0] = num[i];
			num[i] = temp;
			adjustFromupToDown(num, 0, i);
		}
		return num;
	}
}
