package com.cmm.leetcode.sort;

public class InsetSort {
	public static void insertSort(int[] num) {
		int i = 0;
		int j = 0;
		int cur = 0;
		for (i = 1; i < num.length; i++) {
			for (j = i - 1, cur = num[i]; j >= 0 && cur < num[j]; j--) {
				num[j + 1] = num[j];
			}
			num[j + 1] = cur;
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
		insertSort(num);
		printArray(num);
	}

	public static int[] insert(int[] num) {
		int i = 0;
		int j = 0;
		int cur = 0;
		for (i = 1; i < num.length; i++) {
			for (j = i - 1, cur = num[i]; j >= 0 && cur < num[j]; j--)
				num[j + 1] = num[j];
			num[j + 1] = cur;
		}
		return num;
	}
}
