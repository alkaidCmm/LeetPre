package com.cmm.jzOffer._29moreThanHalfNum;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，找出这个数字
 * 
 * @author cmm
 *
 */
public class Solution {
	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		System.out.println(getMOreTahnHalfNum(num, num.length));
	}

	/**
	 *
	 * 保存一个数字， 一个是次数。遍历到下一个数字的时候，如果下一个数字和保存的数字相同，则次数加 l
	 * ：如果下一个数字和我们之前保存的数字，不同，则次数减 1 。如果次数为霉，我们需要保存下一个数字，并把次数设为 1
	 * 。由于我们要找的数字出现的次数比其他所有数字出现的次数之和还要多，那么要找的数字肯定是最后一次把次数设为 1 时对应的数字。
	 * 
	 * @param num
	 * @param length
	 * @return
	 */
	public static int getMOreTahnHalfNum(int[] num, int length) {
		if (num == null || num.length == 0 || num.length < length)
			return -1;
		int result = num[0];
		int times = 0;
		for (int i = 1; i < length; i++) {
			if (times == 0) {
				result = num[i];
				times = 1;
			} else if (result == num[i])
				times++;
			else
				times--;
		}
		if (!checkMoreThanHalf(num, length, result))
			result = -1;
		return result;
	}

	// 判定照出来的数字在数组中出现次数超过一半
	private static boolean checkMoreThanHalf(int[] num, int length,
			int result) {
		int times = 0;
		for (int i = 0; i < length; i++)
			if (num[i] == result)
				times++;
		boolean isMoreThanHalf = true;
		if (times * 2 < length)
			isMoreThanHalf = false;
		return isMoreThanHalf;
	}

}
