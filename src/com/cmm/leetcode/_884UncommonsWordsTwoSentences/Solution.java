package com.cmm.leetcode._884UncommonsWordsTwoSentences;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: cmm
 * @Date: 2018/8/23 3:06 AM
 * description:
 * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
 * <p>
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 * <p>
 * Return a list of all uncommon words.
 * <p>
 * You may return the list in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * Example 2:
 * <p>
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 */
class Solution {
    /**
     * 先按照空格split，存在相同，count=2，不相同
     * @param A
     * @param B
     * @return
     */
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap();
        for (String word : A.split(" ")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        for (String word : B.split(" ")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> ans = new LinkedList();
        for (String word : count.keySet()) {
            if (count.get(word) == 1) {
                ans.add(word);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        String a="apple apple";
        String b= "banana";
        System.out.println(s.uncommonFromSentences(a,b).length);
    }
}