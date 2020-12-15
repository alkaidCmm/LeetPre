package com.cmm.leetcode._387firstUniqChar;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cmm
 * @date 2020/6/20 10:55 AM
 * @desc
 */
public class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
