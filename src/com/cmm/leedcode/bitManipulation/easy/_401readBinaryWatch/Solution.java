package com.cmm.leedcode.bitManipulation.easy._401readBinaryWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cmm
 * @Date: 2018/9/2 11:45 PM
 */
public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++)
            for (int m = 0; m < 60; m++)
                // Integer.bitCount(n) 计算二进制1的个数， 一个小时60分钟。小时和分钟需要错开64及以上的的2进制位数，避免两个位置数字相互影响。
                if (Integer.bitCount(h*128 + m) == num)
                    times.add(String.format("%d:%02d", h, m));
        return times;
    }

    public static void main(String[] args) {
        System.out.println(Integer.bitCount(8));
        System.out.println(Integer.bitCount(12));
        System.out.println(Integer.bitCount(14));
        System.out.println(Integer.bitCount(16));
        System.out.println(Integer.bitCount(5 * 64) + Integer.bitCount(38));
        Solution s = new Solution();
        System.out.println(s.readBinaryWatch(5));

    }
}
