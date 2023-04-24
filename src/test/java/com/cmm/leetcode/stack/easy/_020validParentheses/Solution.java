package com.cmm.leetcode.stack.easy._020validParentheses;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * 判定括号的有效性
 *
 * @author cmm
 */
public class Solution {
    /**
     * 同类型括号必须同时出现，使用栈模拟
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
//        for (char c : s.toCharArray()) {
//            if (c == '(') {
//                stack.push(')');
//            } else if (c == '{') {
//                stack.push('}');
//            } else if (c == '[') {
//                stack.push(']');
//            } else if (stack.isEmpty() || stack.pop() != c) {
//                return false;
//            }
//        }
//        return stack.isEmpty();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        int length;
        do {
            length = s.length();
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        } while (length != s.length());
        return length == 0;
    }


    public static void main(String[] args) {
        String str = "()";
        Solution s = new Solution();
        s.isValid(str);
    }

}
