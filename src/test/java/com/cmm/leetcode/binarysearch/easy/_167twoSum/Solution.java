package com.cmm.leetcode.binarysearch.easy._167twoSum;

/**
 * @author cmm
 * @date 2020/7/16 9:20 AM
 * @desc
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right=numbers.length-1;
        int[] ret=new int[2];
        while(left<=right){
            int sum=numbers[left]+numbers[right];
            if(sum==target){
                ret[0]=left+1;
                ret[1]=right+1;
                return ret;
            }else if(sum>target){
                right-=1;
            }else{
                left+=1;
            }
        }
        return ret;
    }
}
