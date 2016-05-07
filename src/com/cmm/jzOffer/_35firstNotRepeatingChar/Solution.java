package com.cmm.jzOffer._35firstNotRepeatingChar;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static char first(String str) {
		if (str == null || str.length() < 1)
			throw new IllegalArgumentException("字符串不能为空");
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {// 对所有字符出现次数进行计数
			char c = str.charAt(i);
			if (map.containsKey(c)) {// 修改值，作加一
				int value = map.get(c);
				map.remove(c);
				map.put(c, value + 1);
			} else// 否则，添加进去
				map.put(c, 1);
		}
		char result = 0;
		for (int i = 0; i < str.length(); i++) {// 遍历整个字符串
			// System.out.println(map.size());
			if (map.get(str.charAt(i)) == 1) {
				result = str.charAt(i);
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(first("google")); // l
		System.out.println(first("aabccdbd")); // '\0'
		System.out.println(first("abcdefg")); // a
		System.out.println(first("gfedcba")); // g
		System.out.println(first("zgfedcba")); // g
	}
}
