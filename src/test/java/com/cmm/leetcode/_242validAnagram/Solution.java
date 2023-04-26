package com.cmm.leetcode._242validAnagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cmm
 * @date 2020/6/22 7:50 PM
 * @desc
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        if (map.values().size() == 0) {
            return true;
        }
        return map.values().stream().allMatch(e -> e == 0);

    }

    public boolean isAnagram2(String s, String t) {
        int[] ss = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ss[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            ss[t.charAt(i) - 'a']--;
        }
//        for (int i : ss) {
//            if (i != 0) {
//                return false;
//            }
//        }
//        return true;
        return Arrays.stream(ss).noneMatch(e->e!=0);
    }


    public static void main(String[] args) {
        String s = "a";
        String t = "b";
        System.out.println(new Solution().isAnagram2(s, t));
    }
}
