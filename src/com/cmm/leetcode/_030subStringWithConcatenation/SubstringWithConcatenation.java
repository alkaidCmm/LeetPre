package com.cmm.leetcode._030subStringWithConcatenation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You are given a string, S, and a list of words, L, that are all of the same
 * length. Find all starting indices of substring(s) in S that is a
 * concatenation of each word in L exactly once and without any intervening
 * characters.
 * 
 * For example, given: S: "barfoothefoobarman" L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 * 题意：给定一个字符串S和一个字符串数组L，L中的字符串长度都相等，找出S中所有的子串恰好包含L中所有字符各一次，返回子串的起始位置
 * 
 * @author cmm
 *
 */
public class SubstringWithConcatenation {
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> ans = new ArrayList<Integer>();
		if (S.length() < 1 || L.length < 1)
			return ans;
		int len = L[0].length(); // 题目说L中每个单词长度一样
		// 初始化HashMap，注意L中可能包含多个相同的字符串，所以用value表示个数
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int j = 0; j < L.length; j++) {
			if (map.containsKey(L[j])) {
				map.put(L[j], map.get(L[j]) + 1);
			} else {
				map.put(L[j], 1);
			}
		}

		// i的范围很关键，如果直接到S.length()是会超时的
		for (int i = 0; i <= S.length() - L.length * len; i++) {
			int from = i;
			String str = S.substring(from, from + len);
			int cnt = 0;
			while (map.containsKey(str) && map.get(str) > 0) {
				map.put(str, map.get(str) - 1);
				cnt++;
				from += len;
				if (from + len > S.length())
					break; // 注意越界
				str = S.substring(from, from + len);
			}

			// L中每个单词恰好出现一次，加入到结果集
			if (cnt == L.length) {
				ans.add(i);
			}

			// 为下一次初始化HashMap
			if (cnt > 0) {
				map.clear();
				for (int j = 0; j < L.length; j++) {
					if (map.containsKey(L[j])) {
						map.put(L[j], map.get(L[j]) + 1);
					} else {
						map.put(L[j], 1);
					}
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
