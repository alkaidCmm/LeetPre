package com.cmm.leetcode.longestSubString003;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cmm
 */
public class LongestSubString {
    public int lengthOfLongestSubString(String str) {
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
