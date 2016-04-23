package com.cmm.jzOffer._40findNumbersAppearanceOnce;

public class Solution {
	public static int[] findNumbersAppearanceOnce(int[] data) {
		int[] result = { 0, 0 };
		if (data == null || data.length < 2) {
			return result;
		}
		int xor = 0;
		for (int i : data) {
			xor ^= i;
			System.out.println("xor=" + xor);
		}
		// System.out.println("xor="+xor);
		int indexOf1 = findFirstBit1(xor);
		System.out.println("indexOf1=" + indexOf1);

		for (int i : data) {
			if (isBit1(i, indexOf1)) {
				result[0] ^= i;
			} else {
				result[1] ^= i;
			}
		}
		return result;
	}

	/**
	 * num从右到左找出第一个为1的数字，也就是数组元素异或操作，第一个只出现一次的点的下标
	 * 
	 * @param num
	 * @return
	 */
	private static int findFirstBit1(int num) {
		int index = 0;
		while ((num & 1) == 0 && index < 32) {
			num >>>= 1;// 无符号右移，忽略符号位，空位都以0补齐
			index++;
		}
		return index;
	}

	private static boolean isBit1(int num, int indexBit) {
		num >>>= indexBit;
		return (num & 1) == 1;
	}

	public static void main(String[] args) {
		int[] data1 = { 2, 4, 3, 6, 3, 2, 5, 5 };
		int[] result1 = findNumbersAppearanceOnce(data1);
		System.out.println(result1[0] + " " + result1[1]);
		// int[] data2 = {4, 6};
		// int[] result2 = findNumbersAppearanceOnce(data2);
		// System.out.println(result2[0] + " " + result2[1]);
		// int[] data3 = {4, 6, 1, 1, 1, 1};
		// int[] result3 = findNumbersAppearanceOnce(data3);
		// System.out.println(result3[0] + " " + result3[1]);
	}
}
