package com.cmm.leedcode.sort;

public class MergeSort {
	private static void mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			// 对左边进行递归
			mergeSort(a, left, middle);
			// 对右边进行递归
			mergeSort(a, middle + 1, right);
			// 合并
			merge(a, left, middle, right);
		}
	}

	private static void merge(int[] arr, int left, int middle, int right) {
		int[] tmpArr = new int[arr.length];
		int mid = middle + 1; // 右边的起始位置
		int tmp = left;
		int third = left;
		while (left <= middle && mid <= right) {
			// 从两个数组中选取较小的数放入中间数组
			if (arr[left] <= arr[mid]) {
				tmpArr[third++] = arr[left++];
			} else {
				tmpArr[third++] = arr[mid++];
			}
		}
		// 将剩余的部分放入中间数组
		while (left <= middle) {
			System.out.println("左边有多余");
			tmpArr[third++] = arr[left++];
		}
		while (mid <= right) {
			tmpArr[third++] = arr[mid++];
		}
		// 将中间数组复制回原数组
		while (tmp <= right) {
			arr[tmp] = tmpArr[tmp++];
		}

	}

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

	public static void main(String[] args) {
		int[] num = { 11, 36, 64, 9, 5, 8, 2, 21, 65, 43 };
		printArray(num);
		// quickSort(num, 0, num.length - 1);
		mergeSort(num, 0, num.length - 1);
		printArray(num);
	}
}
