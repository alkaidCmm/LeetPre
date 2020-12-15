package com.cmm.leetcode.dynamicprogramming.hard._887superEggDrop;

/**
 * @author cmm
 * @date 2020/7/21 1:34 PM
 * @desc K个鸡蛋，从N层楼掉落，最少几次找出临别楼层（当前不破，上一层破）
 */
public class Solution {

    public int superEggDrop(int K, int N) {
        // dp [M] [K]表示，给定K个鸡蛋和M个动作， 我们可以检查的最大楼层数是多少？实质等价m、k固定，求最少楼层数量
        int[][] dp = new int[N + 1][K + 1];
        int m = 0;
        while (dp[m][K] < N) {
            ++m;
            for (int k = 1; k <= K; ++k) {
                dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
            }
        }
        return m;
    }
}