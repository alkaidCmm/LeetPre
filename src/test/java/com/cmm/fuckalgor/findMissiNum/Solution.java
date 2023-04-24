package com.cmm.fuckalgor.findMissiNum;

/**
 * @author cmm
 * @date 2020/6/24 4:56 PM
 * @desc 如何寻找小时的元素
 * 给定包含0，1，2，3。。。n中n个数的序列，找出0。。。n中没有出现在序列中的那个数
 */
public class Solution {

    public static int getMissNum(int[] nums) {
        int ret = nums.length;
        for (int i = 0; i < nums.length; i++) {
            ret ^= i ^ nums[i];
        }
        return ret;
    }

    public static int getMissNum2(int[] nums) {
        int ret =nums.length;
        for (int i = 0; i < nums.length; i++) {
            ret +=i-nums[i];
        }
        return ret;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 2, 1, 5, 7, 6};
        int ret = getMissNum2(nums);
    }
}
