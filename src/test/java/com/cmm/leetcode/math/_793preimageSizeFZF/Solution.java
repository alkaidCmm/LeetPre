package com.cmm.leetcode.math._793preimageSizeFZF;

/**
 * @author caimingming02
 * @date 2020/11/26 4:43 PM
 * @desc Let f(x) be the number of zeroes at the end of x!. (Recall that x! = 1 * 2 * 3 * ... * x, and by convention, 0! = 1.)
 *
 * For example, f(3) = 0 because 3! = 6 has no zeroes at the end, while f(11) = 2 because 11! = 39916800 has 2 zeroes at the end. Given K, find how many non-negative integers x have the property that f(x) = K.
 *
 * Example 1:
 * Input: K = 0
 * Output: 5
 * Explanation: 0!, 1!, 2!, 3!, and 4! end with K = 0 zeroes.
 *
 * Example 2:
 * Input: K = 5
 * Output: 0
 * Explanation: There is no x such that x! ends in K = 5 zeroes.
 *
 * 输入一个非负整数 K，请你计算有多少个 n，满足 n! 的结果末尾恰好有 K 个 0。
 */
public class Solution {
    public int preimageSizeFZF(int K) {
        return Long.valueOf(right_bound(K) - left_bound(K) + 1).intValue();
    }


    private long left_bound(int target) {
        long left = 0;
        long right = Long.MAX_VALUE;

        while (left < right) {
            long mid = (left + right) / 2;
            if (trailingZeroes(mid) == target) {
                right = mid;
            } else if (trailingZeroes(mid) < target) {
                left = mid + 1;
            } else if (trailingZeroes(mid) > target) {
                right = mid;
            }
        }
        return left;
    }

    private long right_bound(int target) {
        long left = 0, right = Long.MAX_VALUE;

        while (left < right) {
            Long mid = (left + right) / 2;
            if (trailingZeroes(mid) == target) {
                left = mid + 1;
            } else if (trailingZeroes(mid) < target) {
                left = mid + 1;
            } else if (trailingZeroes(mid) > target) {
                right = mid;
            }
        }
        return left - 1;
    }


    private long trailingZeroes(long n) {
        long ret = 0;

        long divisor = 5;
        while (divisor <= n) {
            ret += n / divisor;
            divisor *= 5;
        }

        return ret;
    }
}