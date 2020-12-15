package com.cmm.leetcode.bitManipulation.medium._187findRepeatedDnaSequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: cmm
 * @Date: 2018/9/2 11:21 PM
 * desc :
 * 所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * <p>
 * 编写一个函数来查找 DNA 分子中所有出现超多一次的10个字母长的序列（子串）。
 * <p>
 * 示例:
 * <p>
 * 输入: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * <p>
 * 输出: ["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class Solution {
    public List<String> findRepeatedDnaSequences2(String s) {
        Set<Integer> words = new HashSet<>();
        Set<Integer> doubleWords = new HashSet<>();
        List<String> rv = new ArrayList<>();
        char[] map = new char[26];
        //map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;

        for (int i = 0; i < s.length() - 9; i++) {
            int v = 0;
            for (int j = i; j < i + 10; j++) {
                v <<= 2;
                v |= map[s.charAt(j) - 'A'];
            }
            if (!words.add(v) && doubleWords.add(v)) {
                rv.add(s.substring(i, i + 10));
            }
        }
        return rv;
    }

    /**
     * 滑动窗口方式进行遍历
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet(), repeated = new HashSet();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            // seen 进行重复判定，
            if (!seen.add(ten)) {
                repeated.add(ten);
            }
        }
        return new ArrayList(repeated);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }
}
