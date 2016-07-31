package com.cmm.leedcode._334reverseString;

public class Solution1 {
	public static void main(String[] args) {

	}

	/**
	 * 字符拼接
	 * 
	 * @param s
	 * @return
	 */
	public static String reverseString1(String s) {
		char array[] = s.toCharArray();
		char c;
		int j = array.length;
		for (int i = 0; i < j / 2; i++) {
			c = array[i];
			array[i] = array[j - i - 1];
			array[j - i - 1] = c;
		}
		return new String(array);
	}

}
