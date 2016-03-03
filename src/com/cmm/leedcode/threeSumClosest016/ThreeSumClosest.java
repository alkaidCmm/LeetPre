package com.cmm.leedcode.threeSumClosest016;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution. For example,
 * 
 * given array S = {-1 2 1 -4}, and target = 1. The sum that is closest to the
 * target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author cmm
 * 
 */
public class ThreeSumClosest {
	public int FindThreeSumClosest(int[] num, int target) {
		int result = num[0] + num[1] + num[2];
		Arrays.sort(num);// 大小排序
		for (int i = 0; i <= num.length - 3; i++) {
			int second = i + 1;// 第二个数小标
			int third = num.length - 1;// 第三个数下标
			while (second < third) {
				int sum = num[i] + num[second] + num[third];
				if (Math.abs(target - sum) < Math.abs(target - result))
					result = sum;
				if (sum < target)
					second++;
				else if (sum > target)
					third--;
				else {
					second++;
					third--;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int num[] = { 2, 4, 6, 8, 0, -1, -3, -5, -7, -9 };
		System.out.println(new ThreeSumClosest().FindThreeSumClosest(num, -20));
	}

}
