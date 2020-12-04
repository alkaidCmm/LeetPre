package com.cmm.leedcode.array._922sortArrayByParityII;

/**
 * @author caimingming02
 * @date 2020/11/17 10:01 AM
 * @desc Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 *
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 *
 * You may return any answer array that satisfies this condition.
 *
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 * Note:
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 */
public class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] ret=new int[A.length];

        int i=0;
        for (int x:A){
            if(x%2==0){
                ret[i]=x;
                i+=2;
            }
        }

        i=1;
        for (int x:A){
            if(x%2==1){
                ret[i]=x;
                i+=2;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        new Solution().sortArrayByParityII(new int[]{4,2,5,7});
    }
}
