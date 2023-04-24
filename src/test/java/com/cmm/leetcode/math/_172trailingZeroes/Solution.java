package com.cmm.leetcode.math._172trailingZeroes;

/**
 * @author caimingming02
 * @date 2020/11/26 4:17 PM
 * @desc Given an integer n, return the number of trailing zeroes in n!.
 *
 * Follow up: Could you write a solution that works in logarithmic time complexity?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 *
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Example 3:
 *
 * Input: n = 0
 * Output: 0
 *
 */
public class Solution {

    /**
     * https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/4.1-shu-xue-yun-suan-ji-qiao/jie-cheng-ti-mu
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int ret = 0;

        long divisor = 5;
        while (divisor <= n) {
            ret += n / divisor;
            divisor *= 5;
        }

        return ret;
    }

}
