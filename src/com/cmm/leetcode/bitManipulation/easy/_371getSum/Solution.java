package com.cmm.leetcode.bitManipulation.easy._371getSum;

/**
 * @author cmm
 * @date 2019/11/18 5:03 PM
 * @desc 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * <p>
 * 示例 1:
 * 输入: a = 1, b = 2
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: a = -2, b = 3
 * 输出: 1
 * <p>
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 */
public class Solution {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public int getSubtract(int a, int b) {
        while (b != 0) {
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }
        return a;
    }
}
