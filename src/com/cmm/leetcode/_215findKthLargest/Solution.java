package com.cmm.leetcode._215findKthLargest;

import java.util.PriorityQueue;

public class Solution {

    public int findKthLargest(int[] nums, int k) {
        // if(k==0){
        //     return ret;
        // }
        // 默认大根堆
        PriorityQueue<Integer> pq= new PriorityQueue<Integer>((x, y)-> x-y);

        for(int i=0;i<k;i++){
            pq.offer(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(pq.peek()>nums[i]){
                pq.poll();
                pq.offer(nums[i]);
            }
        }


        return  pq.peek();
    }

    public static void main(String[] args) {
        new Solution().findKthLargest(new int[]{3,2,1,5,6,4 },2);
    }

}
