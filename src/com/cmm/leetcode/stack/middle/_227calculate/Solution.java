package com.cmm.leetcode.stack.middle._227calculate;

import java.util.Stack;

public class Solution {

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                // 可能数字连续，需要做加和计算
                num = num * 10 + s.charAt(i) - '0';
            }
            // i == s.length() - 1 需保障最后一轮必须得到计算
            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == s.length() - 1) {
                if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '+') {
                    stack.push(num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                // 计算完 num重置为0
                num = 0;
                // 这里很关键，需要保存默认上一轮的计算符
                sign = s.charAt(i);
            }
        }

        int ret = 0;
        while (!stack.isEmpty()) {
            ret += stack.pop();
        }
        return ret;

    }

    public static void main(String[] args) {
        new Solution().calculate("3+2*2");
    }
}
