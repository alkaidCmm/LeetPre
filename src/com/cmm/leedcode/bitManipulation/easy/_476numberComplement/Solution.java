package com.cmm.leedcode.bitManipulation.easy._476numberComplement;

/**
 * @Author: cmm
 * @Date: 2018/9/9 11:34 PM
 */
public class Solution {
    public int findComplement(int num) {
        int i = 0;
        int j = 0;

        while (i < num) {
            i += Math.pow(2, j);
            j++;
        }

        return i - num;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findComplement(13));
    }
}
