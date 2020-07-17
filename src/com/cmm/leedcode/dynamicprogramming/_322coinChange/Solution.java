package com.cmm.leedcode.dynamicprogramming._322coinChange;

/**
 * @author cmm
 * @date 2020/7/15 11:56 AM
 * @desc
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        // todo
        if(amount==0){
            return 0;
        }
        if(amount<0){
            return -1;
        }

        return 0;
    }
}
