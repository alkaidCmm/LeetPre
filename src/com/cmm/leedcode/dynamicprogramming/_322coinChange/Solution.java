package com.cmm.leedcode.dynamicprogramming._322coinChange;

/**
 * @author cmm
 * @date 2020/7/15 11:56 AM
 * @desc You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * https://leetcode.com/problems/coin-change/
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        // dp 数组的定义：当目标金额为 i 时，至少需要 dp[i] 枚硬币凑出。
        int[] dp = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = amount + 1;
        }
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                // 这里 表示计算出dp[i]中，dp最小值，1+dp[i-coin]表示，最理想状态下只需要一枚硬币即可满足要求
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        new Solution().coinChange(new int[]{1}, 1);
    }
}
