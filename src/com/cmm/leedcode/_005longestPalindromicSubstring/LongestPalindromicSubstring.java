package com.cmm.leedcode._005longestPalindromicSubstring;

/**
 * 最长回文串
 * 
 * @author cmm
 * 
 */

public class LongestPalindromicSubstring {
/**
 * 中心扩展就是把给定的字符串的每一个字母当做中心，向两边扩展，这样来找最长的子回文串。算法复杂度为O(N^2)。
但是要考虑两种情况：
1、像aba，这样长度为奇数。
2、想abba，这样长度为偶数
 * @param str
 * @return 
 */

	public String longestPalindromicSubstring(String str) {
		int n = str.length();
		int maxLength = 0;
		int start = 0;
		char strArray[] = str.toCharArray();
		for (int i = 0; i < n - 1; i++) {//长度为奇数
			int left = i - 1;
			int right = i + 1;
			while (left >= 0 && right <= n - 1
					&& strArray[left] == strArray[right]) {
				if (right - left + 1 > maxLength) {
					maxLength = right - left + 1;
					start = left;
				}
				left--;
				right++;
			}
		}
		for (int i = 0; i < n - 1; i++) {//长度为偶数
			int left = i;
			int right = i + 1;
			while (left >= 0 && right <= n - 1
					&& strArray[left] == strArray[right]) {
				if (right - left + 1 > maxLength) {
					maxLength = right - left + 1;
					start = left;
				}
				left--;
				right++;
			}
		}
		if(maxLength>0) return str.substring(start,maxLength);
		return null;
				
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		String str = lps.longestPalindromicSubstring("abcddcbaef");
		System.out.println(str);
	}

}
