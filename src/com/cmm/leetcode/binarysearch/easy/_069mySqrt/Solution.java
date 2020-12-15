package com.cmm.leetcode.binarysearch.easy._069mySqrt;

/**
 * @author cmm
 * @date 2020/7/15 10:20 PM
 * @desc
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 */
public class Solution {

    public int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        int left=1;
        int right=x;
        while(true){
            int mid=(left+right)/2;
            if(mid>x/mid){
                right=mid-1;
            }else{
                // mid*mid>x&&(mid+1)*mid+1<x
                if((mid+1)>x/(mid+1)){
                    return mid;
                }
                left=mid+1;
            }
        }

    }
}
