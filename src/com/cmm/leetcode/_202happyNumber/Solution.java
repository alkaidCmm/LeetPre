package com.cmm.leetcode._202happyNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: cmm
 * @Date: 2018/5/14 1:40 AM
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例:
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            int result = 0;
            while (n != 0) {
                result += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (set.contains(result)) {
                return false;
            }
            set.add(result);
            n = result;
        }
        return true;
    }
}
