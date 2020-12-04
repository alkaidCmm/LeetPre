package com.cmm.leedcode.math._204countPrimes;

import java.util.Arrays;

/**
 * @author caimingming02
 * @date 2020/8/24 11:43 PM
 * @desc 计算n范围内的素数个数
 */
public class Solution {

    public int countPrimesV1(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                // 有其他整除因子
                return false;
            }
        }
        return true;
    }

    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);

        for (int i = 2; i * i < n; i++) {
            if (isPrim[i]) {
                // 如果 i 是 素数，i 的倍数不可能是素数了
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }

        int count = 0;

        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                count++;
            }
        }
        return count;
    }

}
