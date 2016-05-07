package com.cmm.jzOffer._09fibonacci;

/**
 * 斐波那契数列实现 思路：用递归实现的过程中会出现重复计算的情况，此时，可以利用动态规划的思想，保存中间结果，这样可以避免重复计算
 * 
 * @author cmm
 *
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().fibonacci(-5));
	}

	public int fibonacci(int n) {
		if (n <= 0)
			return 0;
		else if (n == 1)
			return 1;
		else {
			// 由zero和one保存中间结果
			int zero = 0;
			int one = 1;
			int fn = 0;
			for (int i = 2; i <= n; i++) {
				fn = zero + one;
				zero = one;
				one = fn;
			}
			return fn;
		}
	}
}
