package com.cmm.jzOffer._52multiplyArr;

import java.util.Arrays;

public class Solution {
	public static double[] multiArr(double[] num) {
		if (num == null || num.length < 2)
			return null;
		double[] result = new double[num.length];// 保存结果的数组
		result[0] = 1;
		for (int i = 1; i < num.length; i++) {
			// 第一步每个result[i]都等于于data[0]*data[1]...data[i-1]
			// 当i=n-1时，此时result[n-1]的结果已经计算出来了【A】
			result[i] = result[i - 1] * num[i - 1];
		}
		System.out.println(Arrays.toString(result));
		// tmp保存data[n-1]*data[n-2]...data[i+1]的结果
		double tmp = 1;
		// 第二步求data[n-1]*data[n-2]...data[i+1]
		// 【A】result[n-1]的结果已经计算出来，所以从data.length-2开始操作
		for (int i = num.length - 2; i >= 0; i--) {
			tmp *= num[i + 1];
			result[i] *= tmp;
		}
		return result;
	}

	public static void main(String[] args) {
		double[] array1 = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(multiArr(array1))); // double
																// expected[]
																// ={120, 60,
																// 40,30, 24};
	}
}
