package com.cmm.leetcode._032longestValidParentheses;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * <p>
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * <p>
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 *
 * @author cmm
 */
public class Solution {
    /**
     * 栈
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        char[] schar = s.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        int maxLength = 0;
        int match_pos = -1;
        for (int i = 0; i < schar.length; i++) {
            if (schar[i] == '(')
                stack.push(i);
            else {
                if (stack.empty())// 左边没有匹配
                    match_pos = i;
                else {// 匹配了左边
                    stack.pop();
                    if (stack.empty())
                        maxLength = Math.max(maxLength, i - match_pos);// ()()
                    else {
                        maxLength = Math.max(maxLength, i - stack.peek());
                    }
                }
            }
        }
        stack.clear();
        return maxLength;
    }

    /**
     * 动态规划法将大问题化为小问题，我们不一定要一下子计算出整个字符串中最长括号对，我们可以先“从后向前” ，一点一点计算。
     * 假设d[i]是从下标i开始到字符串结尾最长 “括号对” 长度，s[i]是字符串下标为i的括号。如果s[i-1]是左括号，如果i + d[i] +
     * 1是右括号的话，那d[i-1] = d[i] + 1。如果不是则为0。如果s[i-1]是右括号，因为不可能有右括号开头的括号对，所以d[i-1]
     * = 0。
     *
     * @param s
     * @return
     */
    public int longestValidParenthesesMethodTwo(String s) {
        int[] dp = new int[s.length()];
        int maxLen = 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                int end = i + dp[i + 1] + 1;
                System.out.println(i + ",dp[" + (i + 1) + "]=" + dp[i + 1]
                        + ",end=" + end);
                if (end < s.length() && s.charAt(end) == ')') {
                    dp[i] = dp[i + 1] + 2;
                    if (end + 1 < s.length()) {
                        dp[i] += dp[end + 1];
                    }
                    System.out.println("dp[" + i + "]=" + dp[i]);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public int longestValidParentheses3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        //  dp[i] 表示以 i 结尾的最长有效括号；
        // 1. 当 s[i] 为 (,dp[i] 必然等于 0，因为不可能组成有效的括号；
        // 那么 s[i] 为 )
        //      2.1 当 s[i-1] 为 (，那么 dp[i] = dp[i-2] + 2；
        //      2.2 当 s[i-1] 为 ) 并且 s[i-dp[i-1] - 1] 为 (，那么 dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2]；
        int[] dp= new int[s.length()];
        for(int i=0; i<s.length(); i++){
            // 对于当前位为 ) 的情况：
            if(i>0 && s.charAt(i)==')'){
                // 如果前一位是 (
                if(s.charAt(i-1)=='('){
                    // i-2<0,   dp[i] = 2
                    // i-2>=0 ，dp[i] = dp[i-2] + 2
                    dp[i] = i-2 >= 0 ? dp[i-2]+2:2;
                }
                // 如果前一位是 ) 且s.charAt(i-1-dp[i-1])=='('
                else if (s.charAt(i - 1) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution().longestValidParentheses3("((()())))"));

    }

}
