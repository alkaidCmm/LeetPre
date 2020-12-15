package com.cmm.leetcode.bitManipulation.medium._477totalHammingDistance;

/**
 * @Author: cmm
 * @Date: 2018/9/2 10:43 PM
 * <p>
 * desc:
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * <p>
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 * <p>
 * 示例:
 * <p>
 * 输入: 4, 14, 2
 * <p>
 * 输出: 6
 * <p>
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * 注意:
 * <p>
 * 数组中元素的范围为从 0到 10^9。
 * 数组的长度不超过 10^4。
 */
public class Solution {

    /**
     * 计算数组nums[](length为n)中，任意两个数之间汉明激励的总和，只需要计算各个数中，二进制表示时，
     * 第m位的数为1的个数微k，则对应当前位置不同个数的总数微k*（n-k）
     *
     * @param nums
     * @return
     */
    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int j = 0; j < 32; j++) {
            int bitCount = 0;
            for (int i = 0; i < n; i++) {
                bitCount += (nums[i] >> j) & 1;
            }
            total += bitCount * (n - bitCount);
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2, 4, 6, 8, 10};
        System.out.println(s.totalHammingDistance(nums));

    }
}
