package com.cmm.leedcode.dynamicprogramming.hard._516longestPalindromeSubseq;

/**
 * @author cmm
 * @date 2020/7/23 4:01 PM
 * @desc 长回文子序列的长度
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * Input:
 * <p>
 * "bbbab"
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 * <p>
 * <p>
 * Example 2:
 * Input:
 * <p>
 * "cbbd"
 * Output:
 * 2
 * One possible longest palindromic subsequence is "bb".
 */
public class Solution {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        //  在子串 s[i..j] 中，最长回文子序列的长度为 dp[i][j]
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];

    }

    public static void main(String[] args) {
        new Solution().longestPalindromeSubseq("bbbab");
    }
}
