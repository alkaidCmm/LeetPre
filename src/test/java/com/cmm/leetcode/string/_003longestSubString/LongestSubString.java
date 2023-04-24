package com.cmm.leetcode.string._003longestSubString;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cmm
 */
public class LongestSubString {
    /**
     * 最长连续不重复子串
     * @param str
     * @return
     */
    public int lengthOfLongestSubString(String str) {
        // i 重复时对应下标；（慢指针）
        // j 不重复时下标数值（快指针）
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < str.length()) {
            if (!set.contains(str.charAt(j))) {
                set.add(str.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(str.charAt(i++));
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String str = "abcabcabd";
        LongestSubString lsb = new LongestSubString();
        System.out.println(lsb.lengthOfLongestSubString(str));
    }

}
