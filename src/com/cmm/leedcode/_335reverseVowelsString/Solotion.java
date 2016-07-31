package com.cmm.leedcode._335reverseVowelsString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 这道题让我们翻转字符串中的元音字母，元音字母有五个a,e,i,o,u，需要注意的是大写的也算，所以总共有十个字母。
 * 我们写一个isVowel的函数来判断当前字符是否为元音字母，如果两边都是元音字母，那么我们交换，如果左边的不是，向右移动一位，如果右边的不是，
 * 则向左移动一位，
 * 
 * @author cmm
 *
 */
public class Solotion {
	public static String reverseVowels(String s) {
		Set<Character> set = new HashSet<Character>();// 保存所有元音字母
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');

		// Set<Character> vowels = new HashSet<>(Arrays.asList(new
		// Character[]{'a','e','i','o','u','A','E','I','O','U'}));
		char[] list = s.toCharArray();// 转字符串
		for (int i = 0, j = list.length - 1; i < j;) {
			if (!set.contains(list[i])) {
				i++;

			}
			if (!set.contains(list[j])) {
				j--;
			}
			char tmp = list[i];
			list[i] = list[j];
			list[j] = tmp;
			j--;
			i++;
		}
		return String.valueOf(list);
	}
}
