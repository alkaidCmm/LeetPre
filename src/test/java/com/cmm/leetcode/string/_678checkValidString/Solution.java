package com.cmm.leetcode.string._678checkValidString;

/**
 * @author caimingming02
 * @date 2020/12/17 10:03 AM
 * @desc
 *  Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 */
public class Solution {
    /**
     * It's quite straight forward actually.
     * When you met "(", you know you need one only one ")", cmin = 1 and cmax = 1.
     * When you met "(*(", you know you need one/two/three ")", cmin = 1 and cmax = 3.
     *
     * The string is valid for 2 condition:
     * cmax will never be negative.
     * cmin is 0 at the end.
     *
     */
    public boolean checkValidString(String s) {
        int cmin = 0, cmax = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cmax++;
                cmin++;
            } else if (c == ')') {
                cmax--;
                cmin--;
            } else if (c == '*') {
                cmax++;
                cmin--;
            }
            // 保证“)(”这种情况直接退出
            if (cmax < 0) return false;
            cmin = Math.max(cmin, 0);
        }
        return cmin == 0;
    }
}
