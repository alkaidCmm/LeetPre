package com.cmm.jzOffer._04replaceBlank;

import java.util.Arrays;

/**
 * 实现一个函数把字符串中的空格替换成%20
 * 
 * @author cmm
 *
 */
public class Solution {

	public String replaceBlank(String str) {

		char[] strOld = str.toCharArray();
		char[] strNew = new char[100];
		for (int i = 0; i < strOld.length; i++)
			strNew[i] = strOld[i];

		int blank = 0;
		for (int i = 0; i < strNew.length - 1; i++) {
			if (strNew[i] == ' ')
				blank++;
		}
		int m = strOld.length - 1;// 两个指针，
		int n = strOld.length + 2 * blank - 1;
		// 从后往前替换
		while (m >= 0 && n >= 0) {
			if (strNew[m] != ' ')
				strNew[n--] = strNew[m];
			else {
				strNew[n--] = '0';
				strNew[n--] = '2';
				strNew[n--] = '%';
			}
			m--;
		}
		return new String(strNew).trim();
	}

	public static void main(String[] args) {
		String str = "we are very happy.";
		System.out.println(new Solution().replaceBlank(str));
	}
}
