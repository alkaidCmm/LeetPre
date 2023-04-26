package com.cmm.leetcode.binarysearch.easy._350intersect;

import java.util.Arrays;

/**
 * @author cmm
 * @date 2020/6/22 6:19 PM
 * @desc Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 * <p>
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            return new int[0];
        }
        if (nums2 == null) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k++] = nums2[j];
                i++;
                j++;
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        int[] num1=new int[]{4,9,5};
        int[] num2=new int[]{9,4,9,8,4};
        int []ret=s.intersect(num1,num2);

        System.out.println(ret);
    }
}
