package com.cmm.jzOffer._41findNumbersWithSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	/**
	 * 题目一：是两个数和为一个指定数，数组有序
	 * 
	 * @param data
	 * @param sum
	 * @return
	 */
	public static List<Integer> findNumbersWithSum(int[] data, int sum) {
		List<Integer> result = new ArrayList<>(2);
		if (data == null || data.length < 2) {
			return result;
		}
		int ahead = data.length - 1;
		int behind = 0;
		long curSum; // 统计和，取long是防止结果溢出
		while (behind < ahead) {
			curSum = data[behind] + data[ahead];
			if (curSum == sum) {
				result.add(data[behind]);
				result.add(data[ahead]);
				break;
			} else if (curSum < sum) {
				behind++;
			} else {
				ahead--;
			}
		}
		return result;
	}

	/**
	 * 题目二：输入一个正数s，打印出所有和为s 的连续正数序列（至少两个数）。
	 * 
	 * @param data
	 * @param sum
	 * @return
	 */
	public static List<List<Integer>> findContinuousSequence(int sum) {// 输入和为n,也就值在1，2，3，4.。。。（n-1）,n之前去找
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (sum < 3)
			return result;
		int small = 1;
		int big = 2;
		int middle = (1 + sum) / 2;
		int curSum = small + big;
		while (small < middle) {// 上界为最小值小于喝的一半
			if (curSum == sum) {
				List<Integer> list = new ArrayList<Integer>(2);// 避免默认大小10,没必要那么大
				for (int i = small; i <= big; i++)
					list.add(i);
				result.add(list);
			}
			while (curSum > sum && small < middle) {// 当前和大于需要求的和sum
				curSum -= small;// 减去最小的
				small++;// 最小下标后移
				if (curSum == sum) {
					List<Integer> list = new ArrayList<Integer>(2);// 避免默认大小10,没必要那么大
					for (int i = small; i <= big; i++)
						list.add(i);
					result.add(list);
				}
			}
			big++;
			curSum += big;
		}
		return result;
	}

	private static void test01() {
		int[] data1 = { 1, 2, 4, 7, 11, 15 };
		System.out.println(findNumbersWithSum(data1, 15));
		int[] data2 = { 1, 2, 4, 7, 11, 16 };
		System.out.println(findNumbersWithSum(data2, 17));
		int[] data3 = { 1, 2, 4, 7, 11, 16 };
		System.out.println(findNumbersWithSum(data3, 10));
	}

	public static void test02() {
		System.out.println(findContinuousSequence(1));
		System.out.println(findContinuousSequence(3));
		System.out.println(findContinuousSequence(4));
		System.out.println(findContinuousSequence(9));
		System.out.println(findContinuousSequence(15));
		System.out.println(findContinuousSequence(100));
	}

	public static void main(String[] args) {
		test01();
		System.out.println("---------------");
		test02();
	}
}
