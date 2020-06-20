package com.cmm.leedcode._217containsDuplicate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author cmm
 * @date 2020/6/20 12:39 PM
 * @desc Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class Solution {

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        return map.values().stream().anyMatch(e->e>1);
    }

    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[]nums=new int[]{1,2,3,1};
        boolean ret= containsDuplicate(nums);
        System.out.println(ret);
    }
}
