package com.cmm.leetcode.string._336palindromePairs;

import java.util.*;

/**
 * @author caimingming02
 * @date 2020/12/15 12:52 AM
 * @desc
 * Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the concatenation of the two words words[i] + words[j] is a palindrome.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 *
 * Input: words = ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 * Example 3:
 *
 * Input: words = ["a",""]
 * Output: [[0,1],[1,0]]
 *
 *  参考：https://leetcode-cn.com/problems/palindrome-pairs/solution/hui-wen-dui-by-leetcode-solution/
 */
public class Solution {
    /**
     * 存放所有字符串对应的反转字符串
     */
    List<String> wordsRev = new ArrayList<String>();

    /**
     * 存放所有字符串对应的反转字符串与 下表对应数值
     */
    Map<String, Integer> indices = new HashMap<String, Integer>();

    /**
     *
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        for (String word: words) {
            wordsRev.add(new StringBuffer(word).reverse().toString());
        }
        for (int i = 0; i < n; ++i) {
            indices.put(wordsRev.get(i), i);
        }

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int m = word.length();
            if (m == 0) {
                continue;
            }
            for (int j = 0; j <= m; j++) {
                // 判断回文子串，从j->m-1
                if (isPalindrome(word, j, m - 1)) {
                    //
                    int leftId = findWord(word, 0, j - 1);
                    if (leftId != -1 && leftId != i) {
                        ret.add(Arrays.asList(i, leftId));
                    }
                }
                // 判断回文子串，从0->j-1
                if (j != 0 && isPalindrome(word, 0, j - 1)) {
                    int rightId = findWord(word, j, m - 1);
                    if (rightId != -1 && rightId != i) {
                        ret.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ret;
    }

    /**
     * 判断一个字符串是否是回文
     */
    public boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

    public int findWord(String s, int left, int right) {
        return indices.getOrDefault(s.substring(left, right + 1), -1);
    }

    public static void main(String[] args) {
        String[] words=new String[]{"abcd","dcba","lls","s","sssll"};
        new Solution().palindromePairs(words);
    }

}
