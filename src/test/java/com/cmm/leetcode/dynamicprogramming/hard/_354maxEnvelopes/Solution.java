package com.cmm.leetcode.dynamicprogramming.hard._354maxEnvelopes;

import java.util.Arrays;

/**
 * @author caimingming02
 * @date 2020/12/10 10:12 AM
 * @desc You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * <p>
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * <p>
 * Note:
 * Rotation is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * <p>
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * <p>
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 注意：不允许旋转信封。
 */
public class Solution {
    /**
     * https://github.com/labuladong/fucking-algorithm/blob/master/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/%E4%BF%A1%E5%B0%81%E5%B5%8C%E5%A5%97%E9%97%AE%E9%A2%98.md
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ?
                b[1] - a[1] : a[0] - b[0]);
        // 对高度数组寻找 LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }

        return lengthOfLIS(height);
    }

    /**
     * 返回 nums 中 LIS 的长度 最长递增子序列（Longes Increasing Subsequence，简写为 LIS）
     * 二分方式处理
     */
    public int lengthOfLIS(int[] nums) {
        int piles = 0, n = nums.length;
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            // 要处理的扑克牌
            int poker = nums[i];
            int left = 0, right = piles;
            // 二分查找插入位置
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] >= poker)
                    right = mid;
                else
                    left = mid + 1;
            }
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }

    /**
     * 动态规划方式 dp 解决处理
     */
    public int lengthOfLIS2(int[] nums) {
        // dp[i] 表示以 nums[i] 这个数结尾(即从num[0]....num[i])的最长递增子序列的长度。
        int[] dp = new int[nums.length];
        /*递增长度至少为1，即本身*/
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int ret = 0;
        for (int i : dp) {
            ret = Math.max(ret, i);
        }

        return ret;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{5, 4}, {5, 2}, {1, 8}, {6, 4}, {2, 3}, {6, 7}};
        new Solution().maxEnvelopes(a);
    }
}
