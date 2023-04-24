package com.cmm.jzOffer._47add;

public class Solution {
	public static int add(int a, int b) {
		int sum = 0;
		int carry = 0;
		do {
			sum = a ^ b;
			carry = (a & b) << 1;
			a = sum;
			b = carry;
			System.out.println("a=" + a + ",b=" + b);
		} while (b != 0);
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(add(5, 17));
		System.out.println(add(7, 13));
	}
}
