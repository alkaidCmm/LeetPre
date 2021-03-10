package com.cmm.leetcode.array.easy._121bestTimetoBuyandSellStock;

/**
 * Created by cmm on 2016/12/28.
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int ret = 0;

        if (prices == null || prices.length == 0) {
            return ret;
        }
        //从0～i 之间最小数值；
        int bought = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > bought) {
                if (prices[i] - bought > ret) {
                    ret = prices[i] - bought;
                }
            } else {
                bought = prices[i];
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        new Solution().maxProfit(new int[]{7,1,5,3,6,4});
    }
}
