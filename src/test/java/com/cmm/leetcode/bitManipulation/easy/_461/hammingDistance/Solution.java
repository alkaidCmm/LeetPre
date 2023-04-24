package com.cmm.leetcode.bitManipulation.easy._461.hammingDistance;

/**
 * @Author: cmm
 * @Date: 2018/9/9 11:24 PM
 */
public class Solution {
    /**
     * bitCount  统计参数i中1的个数
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.hammingDistance(1,4));
    }
}
