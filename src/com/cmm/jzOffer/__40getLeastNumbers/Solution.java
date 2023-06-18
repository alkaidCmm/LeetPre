package com.cmm.jzOffer.__40getLeastNumbers;

import java.util.PriorityQueue;

/**
 * 最小的k个数
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ret = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x, y) -> y - x);

        for(int i=0;i<k;i++){
            pq.offer(arr[i]);
        }

        for(int i=k;i<arr.length;i++){
            if(pq.peek()>=arr[i]){
                pq.poll();
                pq.offer(arr[i]);
            }
        }

        for(int i=0;i<pq.size();i++){
            ret[i]=pq.poll();
        }

        return ret;
    }

    public static void main(String[] args) {
        new Solution().getLeastNumbers(new int[]{3,6,2,9,4,1,8,5,20},3);
    }
}
