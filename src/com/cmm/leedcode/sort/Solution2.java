package com.cmm.leedcode.sort;

public class Solution2 {
	/**
	 * 希尔排序
	 * 
	 * @param num
	 */
	private static void shellSortDivsion(int[] num) {
		int j = 0;
		int current = 0;
		for (int d = num.length/2; d > 0; d /= 2) {
			for (int i = d; i < num.length; i++) {
				current = num[i];
				for (j = i; j >= d; j -= d) {
					if (current < num[j - d]) {
						//System.out.println(num[j - d] + "," + current);
						num[j] = num[j - d];
					} else
						break;
				}
				num[j] = current;
			}
		}
	}

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

	public static void main(String[] args) {
		int[] num = { 11, 36, 64, 9, 5, 8, 2, 21, 65, 43 };
		printArray(num);
		// quickSort(num, 0, num.length - 1);
		//selectSort(num);
		shellSortDivsion(num);
		printArray(num);
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
}
