package com.cmm.leetcode.bitManipulation.medium._201rangeBitwiseAnd;

/**
 * @Author: cmm
 * @Date: 2018/8/30 2:08 AM
 * <p>
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: [0,1]
 * 输出: 0
 */
public class Solution {
    /**
     * The hardest part of this problem is to find the regular pattern.
     * For example, for number 26 to 30
     * Their binary form are:
     * 11010
     * 11011
     * 11100
     * 11101
     * 11110
     * <p>
     * Because we are trying to find bitwise AND, so if any bit there are at least one 0 and one 1, it always 0. In this case, it is 11000.
     * So we are go to cut all these bit that they are different. In this case we cut the right 3 bit.
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        // i means we have how many bits are 0 on the right
        int i = 0; //
        while (m != n) {
            m >>= 1;
            n >>= 1;
            i++;
        }
        return m << i;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(26 & 27 & 28 & 29 & 30);
        int result = s.rangeBitwiseAnd(26, 30);
        System.out.println(result);

    }
}
