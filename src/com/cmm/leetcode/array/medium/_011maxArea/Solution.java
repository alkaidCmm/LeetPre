package com.cmm.leetcode.array.medium._011maxArea;

/**
 * 题意：在一个坐标系中，给出若干点，每个点做x轴的垂直线，然后求任何两条线形成的容器中能盛下最多水的情况
 *
 * @author cmm
 */
public class Solution {
    public int containerWithMostWater(int height[]) {
        int length = height.length;
        int left = 0;
        int right = length - 1;
        int area;
        int maxArea = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                area = height[left] * (right - left);
                left++;
            } else {
                area = height[right] * (right - left);
                right--;
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int height[] = {8, 9, 10, 9, 8};
        Solution cwmw = new Solution();
        System.out.println(cwmw.containerWithMostWater(height));

    }
}
