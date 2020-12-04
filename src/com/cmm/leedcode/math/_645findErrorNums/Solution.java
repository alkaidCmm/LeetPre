package com.cmm.leedcode.math._645findErrorNums;

/**
 * @author cmm
 * @date 2020/6/24 3:59 PM
 * @desc 给一个长度为 N 的数组 nums，其中本来装着 [1..N] 这 N 个元素，无序。但是现在出现了一些错误，nums 中的一个元素出现了重复，也就同时导致了另一个元素的缺失。请你写一个算法，找到 nums 中的重复元素和缺失元素的值。
 */
public class Solution {

    /**
     * 通过将每个索引对应的元素变成负数，以表示这个索引被对应过一次了：
     *
     * @param nums
     * @return
     */
    public static int[] findErrorNums(int[] nums) {

        int dup = -1;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            // 第一轮被置相反的负数时，小于0即为负数
            if (nums[index] < 0) {
                dup = Math.abs(nums[i]);
            } else {
                nums[index] *= -1;
            }

        }
        System.out.println(dup);

        int miss = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                miss = i + 1;
            }
        }
        System.out.println(miss);
        return new int[]{dup, miss};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 8, 3, 4, 7, 6, 2, 8,8};
        findErrorNums(nums);
    }


}
