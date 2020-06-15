package com.cmm.jzOffer._43printProbability;

/**
 * @author cmm
 */
public class Solution {
	/**
	 * 基于通归求解，时间效率不够高。
	 * 
	 * @param number
	 *            色子个数
	 * @param max
	 *            色子的最大值
	 */
	public static void printProbability(int number, int max) {
		if (number < 1 || max < 1) {
			return;
		}
		int maxSum = number * max;
		int[] probabilities = new int[maxSum - number + 1];
		probability(number, probabilities, max);
		double total = 1;
		for (int i = 0; i < number; i++) {
			total *= max;
		}
		for (int i = number; i <= maxSum; i++) {
			double ratio = probabilities[i - number] / total;
			System.out.printf("%-8.4f", ratio);
		}
		System.out.println();
	}

	/**
	 * @param number
	 *            色子个数
	 * @param probabilities
	 *            不同色子数出现次数的计数数组
	 * @param max
	 *            色子的最大值
	 */
	private static void probability(int number, int[] probabilities, int max) {
		for (int i = 1; i <= max; i++) {
			probability(number, number, i, probabilities, max);
		}
	}

	/**
	 * @param original
	 *            总的色子数
	 * @param current
	 *            当前处理的是第几个
	 * @param sum
	 *            已经前面的色子数和
	 * @param probabilities
	 *            不同色子数出现次数的计数数组
	 * @param max
	 *            色子的最大值
	 */
	private static void probability(int original, int current, int sum,
			int[] probabilities, int max) {
		if (current == 1) {
			probabilities[sum - original]++;
		} else {
			for (int i = 1; i <= max; i++) {
				probability(original, current - 1, i + sum, probabilities, max);
			}
		}
	}

}
