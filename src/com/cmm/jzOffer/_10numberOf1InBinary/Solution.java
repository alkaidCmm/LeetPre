package com.cmm.jzOffer._10numberOf1InBinary;

/**
 * 二进制中一的个数 思路：
 * 把一个整数减去1，在和原整数作与运算，会把最右边的一个1变成0，那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的运算
 * 
 * @author cmm
 *
 */
public class Solution {
	public int numberof1(int target) {
		int count = 0;
		while (target != 0) {
			count++;
			target = target & (target - 1);
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().numberof1(31));
	}
}
