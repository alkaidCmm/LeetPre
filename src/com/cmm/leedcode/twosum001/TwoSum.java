package com.cmm.leedcode.twosum001;

import java.util.Arrays;

public class TwoSum {
	class Pair implements Comparable<Pair> {
		private int value;
		private int index;

		public Pair(int value, int index) {
			this.value = value;
			this.index = index;
		}

		@Override
		public int compareTo(Pair o) {
			return this.value - o.value;
		}
	}

	public int[] twoSum(int number[], int target) {
		int[] res = new int[2];// 保存数组中和为指定值得两个数的下标值
		Pair[] pairs = new Pair[number.length];// 保存数组信息
		for (int i = 0; i < number.length; i++) {
			pairs[i] = new Pair(number[i], i + 1);
		}
		Arrays.sort(pairs);
		int left = 0;
		int right = number.length - 1;
		int sum = 0;
		// System.out.println("right="+right);
		while (left < right) {
			sum = pairs[left].value + pairs[right].value;
			// System.out.println("sum="+sum);

			if (sum == target) {
				res[0] = pairs[left].index;
				res[1] = pairs[right].index;
				if (res[0] > res[1]) {// 交换下标值
					res[0] ^= res[1];
					res[1] ^= res[0];
					res[0] ^= res[1];
				}
				break;
			} else if (sum > target) {
				right--;
			} else {
				left++;
			}
		}
		return res;

	}

	public static void main(String[] args) {
		int numbers[] = { 1, 3, 5, 7, 9, 2, 4, 6, 8, 0 };
		TwoSum ts = new TwoSum();
		int indexs[] = ts.twoSum(numbers, 11);
		for (int i = 0; i < indexs.length; i++) {
			System.out.println(indexs[i]);
		}
	}
}
