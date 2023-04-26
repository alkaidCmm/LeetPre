package com.cmm.leetcode.array.hard._004medianofTwoSortedArrays;

/**
 * Created by cmm on 2016/12/26.
 */

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int med1 = 0;
        int med2 = 0;
        for (int i = 0; i <= (nums1.length + nums2.length) / 2; i++) {
            med1 = med2;
            // 第一个数组下标越界，第二个数组中位
            if (index1 == nums1.length) {
                med2 = nums2[index2];
                index2++;
                // 判断第二个数组下标是否越界
            } else if (index2 == nums2.length) {
                med2 = nums1[index1];
                index1++;
                // 第一个数组下标对应数值<第二个数组下标对应数值，
            } else if (nums1[index1] < nums2[index2]) {
                med2 = nums1[index1];
                index1++;
            } else {
                med2 = nums2[index2];
                index2++;
            }
        }

        // the median is the average of two numbers
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (float) (med1 + med2) / 2;
        }

        return med2;
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{1, 3, 8};
        int[] n2 = new int[]{2, 5};
        System.out.println(findMedianSortedArrays(n1, n2));
    }
}
