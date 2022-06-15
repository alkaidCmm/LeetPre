package com.cmm.leetcode.array.easy._055canJump;

public class Solution {

    public boolean canJump(int[] nums){
        int length=nums.length-1;
        int rightMaxIndex=0;
        for(int i=0;i<length;i++){
            if(rightMaxIndex>i) {
                rightMaxIndex = Math.max(rightMaxIndex, i + nums[i]);
                if (rightMaxIndex >= length) {
                    return true;
                }
            }
        }
        return  false;
    }

    public static void main(String[] args) {
        new Solution().canJump(new int[]{3,2,1,0,4});
    }
}
