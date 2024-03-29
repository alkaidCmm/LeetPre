package com.cmm.jzOffer._11power;

/**
 * 实现函数double power（double base,int
 * exponent）,求base的exponent次方，不得使用库函数，同时不需要考虑大数问题
 * 思路：可以考虑对指数这般，这样只需要计算一半的值，若指数是奇数，则-1再折半，否则直接折半
 *
 * @author cmm
 */
public class Solution {

    public static void main(String[] args) {
//        int base = 2;
//        int exponent_1 = 9;
//        int exponent_2 = 10;
//        System.out.println(new Solution().power(base, exponent_1));
//        System.out.println(new Solution().power(base, exponent_2));

		int base=2;

		int exp1=3;
		int exp2=4;
		System.out.println(new Solution().power_v2(base,exp1));
		System.out.println(new Solution().power_v2(base,exp2));

	}

    public double power_v2(double base, int exponent) {
        if (base == 0) {
            return 0d;
        }
        if (exponent == 0) {
            return 1;
        }

        double temp = power_v2(base, exponent / 2);
        if (exponent % 2 == 1) {
            return base * temp * temp;
        } else {
            return temp * temp;
        }
    }

}
