package com.cmm.jzOffer._21minInStack;

public class Solution {

	public static void main(String[] args) {
		StackWithMin swm = new StackWithMin();
		swm.push(2);
		swm.push(4);
		swm.push(6);
		swm.push(8);
		swm.push(1);
		swm.push(3);
		swm.push(5);
		swm.push(7);
		System.out.println(swm.min());
		swm.push(-1);
		System.out.println(swm.min());

	}

}
