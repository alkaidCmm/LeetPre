package com.cmm.leetcode.binarysearch.easy._367isPerfectSquare;

/**
 * @author cmm
 * @date 2020/7/16 10:05 AM
 * @desc
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Follow up: Do not use any built-in library function such as sqrt.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 16
 * Output: true
 * Example 2:
 *
 * Input: num = 14
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= num <= 2^31 - 1
 */
public class Solution {

    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            long mid = (left + right) / 2;

            if (mid*mid == num  ) {
                return true;
            } else if (mid*mid < num ) {
                left = (int)mid+1;
            } else {
                right = (int)mid-1;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution().isPerfectSquare(5);
    }
}
