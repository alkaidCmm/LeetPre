package com.cmm.leetcode.bitManipulation.medium._397integerReplacement;

/**
 * @Author: cmm
 * @Date: 2018/8/30 1:32 AM
 * 给定一个正整数 n，你可以做如下操作：
 * <p>
 * 1. 如果 n 是偶数，则用 n / 2替换 n。
 * 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
 * n 变为 1 所需的最小替换次数是多少？
 * <p>
 * PS:
 * 1.表示是带符号的右移:按照二进制把数字右移指定数位，高位如符号位为正补零，符号位负补一，低位直接移除;
 * 2.表示无符号的右移:按照二进制把数字右移指定数位，高位直接补零，低位移除。
 */
public class Solution {

    public int integerReplacement(int n) {
        int c = 0;
        while (n != 1) {
            // 偶数，右移除以2
            if ((n & 1) == 0) {
                n >>>= 1;
                //奇数、数字为3或者数字除以/2的数值如果偶数
            } else if (n == 3 || ((n >>> 1) & 1) == 0) {
                --n;
                //奇数、数字除以/2的数值如果偶数
            } else {
                ++n;
            }
            ++c;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(7>>>1);
        System.out.println(9>>>1);

        System.out.println((7>>>1)&1);
        System.out.println((9>>>1)&1);
        System.out.println("----");
        Solution s=new Solution();
        System.out.println(s.integerReplacement(3));
        System.out.println(s.integerReplacement(5));
        System.out.println(s.integerReplacement(7));
        System.out.println(s.integerReplacement(9));
        System.out.println(s.integerReplacement(11));
        System.out.println(s.integerReplacement(13));
        System.out.println(s.integerReplacement(15));


    }
}
