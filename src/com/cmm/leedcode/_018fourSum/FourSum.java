package com.cmm.leedcode._018fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
		HashSet<List<Integer>> hashSet = new HashSet<List<Integer>>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num.length <= 3)
			return result;
		Arrays.sort(num);
		// i，j分别定义两个最左边和最右边的下标值
		for (int i = 0; i < num.length - 3; i++) {
			for (int j = num.length - 1; j > i + 2; j--) {
				int firstSum = num[i] + num[j];
				int d_value = target - firstSum;// 预期的差值,即可能的第二组和值
				int m = i + 1;// 第二组和的下标
				int n = j - 1;
				while (m < n) {
					int secondSum = num[m] + num[n];// 第二组和
					if (secondSum == d_value) {
						List<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]);
						temp.add(num[m]);
						temp.add(num[n]);
						temp.add(num[j]);
						if (!hashSet.contains(temp)) {
							hashSet.add(temp);
							result.add(temp);
						}
						m++;
						n--;
					} else if (secondSum < d_value)
						m++;
					else
						n--;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int num[] = { 1, -1, 0, 2, -2, 3, -3 };
		System.out.println(new FourSum().fourSum(num, 0));

	}

}
