package com.cmm.leetcode.others._76minimumWindowSubstring;


/**
 * @Author: cmm
 * @Date: 2018/5/14 1:12 AM
 * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class Solution {
    /**
     * @param s
     * @param t
     * @return
     */

    public String minWindow(String s, String t) {
        if (null == s || "".equals(s) || s.length() < t.length()) {
            return "";
        }
        int[] ta = new int[128];
        int[] sa = new int[128];
        // TODO: 2018/5/14  
        return null;
    }
}
