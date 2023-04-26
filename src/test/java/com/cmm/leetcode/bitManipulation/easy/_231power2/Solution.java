package com.cmm.leetcode.bitManipulation.easy._231power2;

/**
 * @Author: cmm
 * @Date: 2018/9/10 1:44 AM
 * Given an integer, write a function to determine if it is a power of two.
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
