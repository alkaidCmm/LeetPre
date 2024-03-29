package com.cmm.leetcode._014longestCommonPrefix;

/**
 * 先找出最短的字符串，再逐个匹配
 *
 * @author cmm
 */
public class Solution {
    public String longestCommonPrefix2(String[] str) {
        if (str.length == 0)
            return null;
        int minLen = str[0].length();
        // 获得最短字符串长度
        for (int i = 1; i < str.length; i++) {
            if (minLen >= str[i].length())
                minLen = str[i].length();
        }
        String result = "";
        int index = 0;
        while (index < minLen) {
            for (int i = 0; i < str.length; i++) {
                if (str[i].charAt(index) != str[0].charAt(index))
                    return result;
            }
            result += str[0].charAt(index);
            index++;
        }

        return result;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }

        int minLength = strs[0].length();
        for (String str : strs) {
            if (minLength >= str.length()) {
                minLength = str.length();
            }
        }

        String ret = "";
        int index = 0;
        while (index < minLength) {
            for (String str : strs) {
                if (str.charAt(index) != strs[0].charAt(index)) {
                    return ret;
                }
            }
            ret += strs[0].charAt(index++);
        }

        return ret;
    }

    public static void main(String[] args) {
//        String str[] = {"csmm", "csll", "cspp", "csww", "cszs"};
        String str[] = {"ab", "a"};

//        System.out.println(new Solution().longestCommonPrefix2(str));
        System.out.println(new Solution().longestCommonPrefix(str));

    }

}
