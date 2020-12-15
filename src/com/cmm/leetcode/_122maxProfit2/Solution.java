package com.cmm.leetcode._122maxProfit2;

/**
 * @author cmm
 * @date 2020/6/20 3:12 PM
 * @desc
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, i = 0;
        while (i < prices.length) {
            // find next local minimum
            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                i++;
            }
            // need increment to avoid infinite loop for "[1]"
            int min = prices[i++];
            // find next local maximum
            while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
                i++;
            }
            profit += i < prices.length ? prices[i++] - min : 0;
        }
        return profit;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        int ret = s.maxProfit(prices);
        System.out.println(ret);
    }
}
