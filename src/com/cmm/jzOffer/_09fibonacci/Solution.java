package com.cmm.jzOffer._09fibonacci;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数列实现 思路：用递归实现的过程中会出现重复计算的情况，此时，可以利用动态规划的思想，保存中间结果，这样可以避免重复计算
 *
 * @author cmm
 */
public class Solution {


    public int fibonacci(int n) {
        if (n <= 0)
            return 0;
        else if (n == 1)
            return 1;
        else {
            // 由zero和one保存中间结果
            int zero = 0;
            int one = 1;
            int fn = 0;
            for (int i = 2; i <= n; i++) {
                fn = zero + one;
                zero = one;
                one = fn;
            }
            return fn;
        }
    }

    public int fibonacci_v2(int n) {
        int ret = 0;
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int first = 0;
        int second = 1;

        for (int i = 2; i <= n; i++) {
            ret = first + second;
            first = second;
            second = ret;
        }

        return ret;
    }

    public int fib(int n) {
        Map<Integer, Integer> m = new HashMap<>(n + 1);
        return fib(m, n);
    }

    private int fib(Map<Integer, Integer> m, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return m.getOrDefault(n, fib(m, n - 1) + fib(m, n - 2));
    }

    public static void main(String[] args) {
//		System.out.println(new Solution().fibonacci(-5));
        System.out.println(new Solution().fibonacci_v2(5));
    }

}
