package com.cmm.leetcode.array.medium._080removeDuplicates;


class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    public static void main(String[] args) {
        new Solution().removeDuplicates(new int[]{1,1,1,2,2,2,3,3,3});
    }
}