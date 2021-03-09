package com.cmm.leetcode.string._005longestPalindromicSubstring;

/**
 * 最长回文串
 *
 * @author cmm
 */

public class LongestPalindromicSubstring {
    /**
     * 中心扩展就是把给定的字符串的每一个字母当做中心，向两边扩展，这样来找最长的子回文串。算法复杂度为O(N^2)。
     * 但是要考虑两种情况：
     * 1、像aba，这样长度为奇数。
     * 2、想abba，这样长度为偶数
     *
     * @param str
     * @return
     */

    public String longestPalindromicSubstring(String str) {
        String ret = "";
        for (int i = 0; i < str.length(); i++) {
            String s1 = subLongestPalindromicSubstring(str, i, i);
			String s2 = subLongestPalindromicSubstring(str, i, i+1);
			ret=s1.length()>ret.length()?s1:ret;
			ret=s2.length()>ret.length()?s2:ret;
		}
        return ret;
    }

    private String subLongestPalindromicSubstring(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left + 1, right);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String str = lps.longestPalindromicSubstring("abcddcbaef");
        System.out.println(str);
    }

}
