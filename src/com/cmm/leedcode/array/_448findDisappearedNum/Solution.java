package com.cmm.leedcode._448findDisappearedNum;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * Example:
 * Input:  [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 */

/**
 * Created by cmm on 2016/12/23.
 */
public class Solution {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for( int i=0;i< nums.length; i++){
            int index = nums[i];
            if(nums[Math.abs(index)-1] > 0){
                nums[Math.abs(index)-1]= -nums[Math.abs(index)-1];
            }
        }

        for(int j =1 ;j <= nums.length ; j++){
            if(nums[j-1] > 0){
                result.add(j);
            }
        }
        return result;
    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for( int i=0;i< nums.length; i++){
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int j =1 ;j <= nums.length ; j++){
            if(nums[j-1] > 0){
                result.add(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int []nums=new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
