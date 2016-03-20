package com.cmm.jzOffer._11power;

/**
 * 实现函数double power（double base,int
 * exponent）,求base的exponent次方，不得使用库函数，同时不需要考虑大数问题
 * 思路：可以考虑对指数这般，这样只需要计算一半的值，若指数是奇数，则-1再折半，否则直接折半
 * 
 * @author cmm
 *
 */
public class Solution {

	public static void main(String[] args) {
		int base = 2;
		int exponent_1 = 9;
		int exponent_2 = 10;
		System.out.println(new Solution().power(base, exponent_1));
		System.out.println(new Solution().power(base, exponent_2));
	}

	public double power(double base, int exponent) {
		if (exponent == 0)
			return 1;
		if (exponent == 1)
			return base;
		System.out.println((9 & 1) == 0);
		if ((exponent & 1) == 0) {// 判定指数是偶数
			int exponent_1 = exponent >> 1;
			double temp = power(base, exponent_1);
			System.out.println("a----" + temp * temp);
			return temp * temp;
		} else {
			int exponent_2 = exponent - 1;
			double temp = power(base, exponent_2);
			System.out.println("b----" + temp * base);
			return temp * base;
		}
	}

}
