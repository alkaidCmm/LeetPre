package com.cmm.leetcode.sort;

public class ShellSort {
	public static void shellSort(int[] num) {
		int i =0;
		int j = 0;
		int current = 0;
		for (int d = num.length/2; d > 0; d /= 2) {//分区
			for (i = d; i < num.length; i++) {
				current = num[i];
				for (j = i; j >= d; j -= d) {
					if (current < num[j - d]) {
						num[j] = num[j - d];
					} else//可以直接跳出循环，一开始就已经做了比较了，不需要后续比较
						break;
				}
				num[j] = current;
			}
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
		shellSort(num);
		printArray(num);
	}
}
