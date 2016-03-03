package com.cmm.leedcode._029divideTwoIntegers;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT
 * 
 * @author cmm
 *
 */
/**
 * 一个有趣的是 Math.abs(-2147483648) 结果还是 -2147483648. 在进行该运算前，要将其转化为long类型
 * 
 * @author cmm
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
