package com.cmm.leetcode._169majorityElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cmm
 * @date 2020/6/20 1:47 PM
 * @desc
 */
public class Solution {
    /**
     * 先排序，1/2读取
     *
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * hashMap
     *
     * @param nums
     * @return
     */

    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int ret = 0;
        for (int num : nums) {
//            if (!map.containsKey(num)) {
//                map.put(num, 1);
//            } else {
//                map.put(num, map.get(num) + 1);
//            }
//            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) {
                ret = num;
                break;
            }
        }
        return ret;
    }

    /**
     * 摩尔投票算法
     *
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        int count = 0, ret = 0;
        for (int num : nums) {
            if (count == 0) {
                ret = num;
            }
            if (num != ret) {
                count--;
            } else {
                count++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{2, 1, 2, 1, 2, 1, 2};
        int ret = s.majorityElement3(nums);
    }
}
