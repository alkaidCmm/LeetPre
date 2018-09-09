package com.cmm.leedcode.bitManipulation.easy._190reverseBits;

/**
 * @Author: cmm
 * @Date: 2018/9/10 12:00 AM
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100
 * return 964176192 (represented in binary as 00111001011110000010100101000000 ).
 */
public class Solution {
    /**
     * @param n
     * @return
     */
    // TODO: 2018/9/10 看不懂，难受
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            // CATCH: must do unsigned shift
            n >>>= 1;
            // CATCH: for last digit, don't shift!
            if (i < 31) {
                result <<= 1;
            }
        }
        return result;
    }

    /**
     * 左右不断交换位，直到相遇。
     *
     * @param n
     * @return
     */
    // TODO: 2018/9/10 看不懂，难受
    public int reverseBits2(int n) {
        int left = 0;
        int right = 31;
        while (left < right) {
            // swap bit
            // 不相同才交换，否则没必要交换
            int x = (n >> left) & 1;
            int y = (n >> right) & 1;

            if (x != y) {
                n ^= (1 << left) | (1 << right);
            }

            ++left;
            --right;
        }
        return n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseBits(123));
    }
}
