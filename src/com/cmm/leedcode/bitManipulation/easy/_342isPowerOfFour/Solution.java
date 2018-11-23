package com.cmm.leedcode.bitManipulation.easy._342isPowerOfFour;

/**
 * @Author: cmm
 * @Date: 2018/11/7 4:13 PM
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }
}
