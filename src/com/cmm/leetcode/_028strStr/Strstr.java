package com.cmm.leetcode._028strStr;

/**
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * @author cmm
 *
 */
public class Strstr {

	public void getNext(int next[], String needle) {
		int i = 0, j = -1;
		next[i] = j;
		while (i < needle.length() - 1) {
			while (j != -1 && needle.charAt(i) != needle.charAt(j))
				j = next[j];
			++i;
			++j;
			// 特殊情况，这里即为优化之处。考虑下AAAAB, 防止4个A形成0123在匹配时多次迭代。
			if (needle.charAt(i) == needle.charAt(j))
				next[i] = next[j];
			else
				next[i] = j;
		}

	}

	public int strStr(String haystack, String needle) {
		if (haystack.length() == 0)
			return needle.length() == 0 ? 0 : -1;
		if (needle.length() == 0)
			return 0;
		int next[] = new int[needle.length()];
		getNext(next, needle);
		for (int k = 0; k < next.length; k++) {
			System.out.println("next[" + k + "]=" + next[k]);
		}
		System.out.println("needle.length()="+needle.length());
		int i = 0, j = 0;
		while (i != haystack.length()) {
			if (j != -1 && haystack.charAt(i) != needle.charAt(j)) {
				System.out.println("j=" + j + ",next[" + j + "]=" + next[j]);
				j = next[j];
			}
			++i;
			++j;
			if (j == needle.length())
				return i - j;
		}
		return -1;
	}

	public static void main(String[] args) {
		String haystack = "AAAACAAAAB";
		String needle = "AAAAB";
		Strstr ss = new Strstr();
		int k = ss.strStr(haystack, needle);
		System.out.println(k);
	}
}
