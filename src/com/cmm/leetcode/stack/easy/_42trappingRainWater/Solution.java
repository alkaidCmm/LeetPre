package com.cmm.leetcode.stack.easy._42trappingRainWater;

/**
 * @author cmm
 * @date 2019/11/25 9:47 PM
 * @desc 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 */
public class Solution {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int length = height.length;

        int ret = 0;

        // 从左到右的每个位置最大值
        int[] lMax = new int[length];
        lMax[0] = height[0];
        for (int i = 1; i < length - 1; i++) {
            lMax[i] = Math.max(lMax[i-1], height[i]);
        }
        // 从右到左的每个位置最大值
        int[] rMax = new int[length];
        rMax[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], height[i]);
        }

        for(int i=0;i<length-1;i++){
            ret+=Math.min(lMax[i],rMax[i])-height[i];
        }

        return ret;


    }

    public static void main(String[] args) {
        new Solution().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
