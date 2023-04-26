package com.cmm.jzOffer._44isContinuous;

import java.util.Arrays;

public class Solution {
	/**
	 * 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子， 即这5张牌是不是连续的。 2～10为数字本身， A为1。 J为11、Q为12、
	 * 为13。小王可以看成任意数字。
	 * 
	 * @param numbers
	 *            数组
	 * @return
	 */
	public static boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length != 5) {
			return false;
		}
		// 对元素进行排序
		Arrays.sort(numbers);
		int numberOfZero = 0;// 在排序之后，0的个数
		int numberOfGap = 0;
		for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {// 0计数
			numberOfZero++;
		}
		// 第一个非0元素的位置
		int small = numberOfZero;
		int big = small + 1;
		while (big < numbers.length) {
			if (numbers[small] == numbers[big]) {
				return false;
			}
			numberOfGap += (numbers[big] - numbers[small] - 1);// 求出相邻两个数值之间可以填补的数，比如4，7，中间缺5，6两个数
			small = big;// 左边标签右移
			big++;// 右边标签右移
		}
		System.out.println(
				"numberOfGap=" + numberOfGap + ",numberOfZero=" + numberOfZero);
		return numberOfGap <= numberOfZero;
	}

	public static void main(String[] args) {
		int[] numbers1 = { 1, 3, 2, 5, 4 };
		System.out.println(isContinuous(numbers1));
		int[] numbers2 = { 1, 3, 2, 6, 4 };
		System.out.println(isContinuous(numbers2));
		int[] numbers3 = { 0, 3, 2, 6, 4 };
		System.out.println(isContinuous(numbers3));
		int[] numbers4 = { 0, 3, 1, 6, 4 };
		System.out.println(isContinuous(numbers4));
		int[] numbers5 = { 1, 3, 0, 5, 0 };
		System.out.println(isContinuous(numbers5));
		int[] numbers6 = { 1, 3, 0, 7, 0 };
		System.out.println(isContinuous(numbers6));
		int[] numbers7 = { 1, 0, 0, 5, 0 };
		System.out.println(isContinuous(numbers7));
		int[] numbers8 = { 1, 0, 0, 7, 0 };
		System.out.println(isContinuous(numbers8));
		int[] numbers9 = { 3, 0, 0, 0, 0 };
		System.out.println(isContinuous(numbers9));
		int[] numbers10 = { 0, 0, 0, 0, 0 };
		System.out.println(isContinuous(numbers10));
		int[] numbers11 = { 1, 0, 0, 1, 0 };
		System.out.println(isContinuous(numbers11));
	}
}
