package com.cmm.leetcode.array.easy._001twoSum;
import java.util.Map;
/**
 * Created by cmm on 2016/12/26.
 */

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */


public class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                ret[0] = map.get(target - numbers[i]);
                ret[1] = i ;
                return ret;
            }
            map.put(numbers[i], i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int numbers[]={1,2,3,6,8,14,12,15,13,10};
        //int numbers[]={2,7,11,15};
        int []ret=twoSum(numbers,18);
        System.out.println("ret[0]="+ret[0]+",ret[1]="+ret[1]);
    }
}
