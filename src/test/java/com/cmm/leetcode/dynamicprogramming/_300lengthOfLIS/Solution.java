package com.cmm.leetcode.dynamicprogramming._300lengthOfLIS;

import java.util.Arrays;

/**
 * @author cmm
 * @date 2020/7/20 11:35 PM
 * @desc 最长递增子序列
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class Solution {


    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度。 dp数组应该全部初始化为1，因为至少包含自己
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // 最终问题转换为dp[i]的最大值
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = Math.max(ret, dp[i]);
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        new Solution().lengthOfLIS(nums);
    }
}
