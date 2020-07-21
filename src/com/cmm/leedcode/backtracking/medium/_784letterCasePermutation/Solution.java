package com.cmm.leedcode.backtracking.medium._784letterCasePermutation;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cmm
 * @date 2020/7/18 4:11 PM
 * @desc Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
 * <p>
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * <p>
 * Input: S = "12345"
 * Output: ["12345"]
 * Note:
 * <p>
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 */
public class Solution {

    /**
     * BFS
     */
    public List<String> letterCasePermutation1(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) {
                continue;
            }
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();

                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));
                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));

            }

        }

        return new LinkedList<>(queue);
    }

    //dfs
    public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }

        List<String> res = new LinkedList<>();
        helper(S.toCharArray(), res, 0);
        return res;
    }

    public void helper(char[] chs, List<String> res, int pos) {
        if (pos == chs.length) {
            res.add(new String(chs));
            return;
        }
        if (chs[pos] >= '0' && chs[pos] <= '9') {
            helper(chs, res, pos + 1);
            return;
        }

        chs[pos] = Character.toLowerCase(chs[pos]);
        helper(chs, res, pos + 1);

        chs[pos] = Character.toUpperCase(chs[pos]);
        helper(chs, res, pos + 1);
    }

    public static void main(String[] args) {
//        new Solution().letterCasePermutation1("a1b1c1");
        new Solution().letterCasePermutation("a1b1c1");

    }
}
