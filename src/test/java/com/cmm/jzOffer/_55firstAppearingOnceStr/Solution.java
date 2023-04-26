package com.cmm.jzOffer._55firstAppearingOnceStr;

public class Solution {
	private int index = 0;
	private int[] occurence = new int[256];

	public Solution() {
		for (int i = 0; i < occurence.length; i++) {
			occurence[i] = -1;// 赋初值
		}
	}

	public char firstAppearOnceStr(String str) {
		if (str == null || str.length() == 0)
			throw new IllegalArgumentException(str);
		for (int i = 0; i < str.length(); i++)
			insert(str.charAt(i));
		char ch = '\0';
		// 用于记录最小的索引，对应的就是第一个不重复的数字
		int minIndex = Integer.MAX_VALUE;
		for (int i = 0; i < occurence.length; i++) {
			if (occurence[i] >= 0 && occurence[i] < minIndex) {
				ch = (char) i;
				minIndex = occurence[i];
			}
		}
		return ch;
	}

	private void insert(char ch) {
		if (ch > 256)
			throw new IllegalArgumentException();
		if (occurence[ch] == -1)
			occurence[ch] = index;
		else
			occurence[ch] = -2;
		index++;// 标记出现一次的下标值
	}

	public static void main(String[] args) {
		//System.out.println(new MyLinkedList().firstAppearOnceStr("")); // '\0'
		System.out.println(new Solution().firstAppearOnceStr("g")); // 'g'
		System.out.println(new Solution().firstAppearOnceStr("go")); // 'g'
		System.out.println(new Solution().firstAppearOnceStr("goo")); // 'g'
		System.out.println(new Solution().firstAppearOnceStr("goog")); // '\0'
		System.out.println(new Solution().firstAppearOnceStr("googl")); // l
		System.out.println(new Solution().firstAppearOnceStr("google")); // l
	}

}
