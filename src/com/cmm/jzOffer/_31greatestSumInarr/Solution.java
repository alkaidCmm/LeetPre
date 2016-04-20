package com.cmm.jzOffer._31greatestSumInarr;

/**
 * 计算连续子数组的和
 * 
 * @author cmm
 *
 */
public class Solution {
	public static void main(String[] args) {
		int num[] = { 1, -2, 3, 7, -5, 3, 4, 6, -2, 8, 5 };
		int result = findGreatSumofSubArray(num);
		System.out.println("子数组的最大和为：" + result);
	}

	public static int findGreatSumofSubArray(int[] num) {
		int currentSum = 0;
		int finalSum = 0;
		for (int i = 0; i < num.length; i++) {
			currentSum += num[i];
			if (currentSum > 0) {
				if (currentSum > finalSum) {
					finalSum = currentSum;
					System.out.println("finalSum=" + finalSum);
				}
			} else {
				currentSum = 0;
			}
		}
		return finalSum;
	}
}
