package com.cmm.leetcode._029divideTwoIntegers;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT
 * 
 * @author cmm
 * @desc
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 * Note:
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 *
 */
public class DivideTwoIntegers {
	/**
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public int divideTwoInteger(int dividend, int divisor) {
		boolean positive = (dividend > 0 && divisor > 0)
				|| (dividend < 0 && divisor < 0);
		long a = Math.abs(dividend);
		long b = Math.abs(divisor);
		long res = 0;
		while (a >= b) {
			long c = b;
			for (int i = 0; a >= c; i++, c <<= 1) {
				a -= c;
				res += 1 << i;
				System.out.println(
						"i=" + i + ",c=" + c + ",a=" + a + ",res=" + res);
			}
		}
		return (int) (!positive ? -res : res);
	}

	/**
	 * 维护一个一维数组multi，multi[i]存储除数扩大i倍的情况，然后用被除数减。
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public int divideTwoIntegerDemo2(int dividend, int divisor) {
		if (dividend == 0 || divisor == 1)
			return dividend;
		boolean positive = (dividend > 0 && divisor > 0)
				|| (dividend < 0 && divisor < 0);
		int result = 0;
		long divid = dividend;
		long divis = divisor;
		System.out.println("divis=" + divis + ",divid=" + divid);
		long multi[] = new long[32];
		for (int i = 0; i < 32; i++) {// 存储3，6，12，24，48，96，192
			multi[i] = (divis << i);
			System.out.println("multi[" + i + "]=" + multi[i]);
		}
		for (int i = 31; i >= 0; i--) {
			if (multi[i] <= divid) {
				result += 1 << i;
				divid -= multi[i];
			}
		}
		return positive ? result : -result;
	}

	public static void main(String[] args) {
		System.out.println(new DivideTwoIntegers().divideTwoInteger(166, 3));
	}
}
