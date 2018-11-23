package com.cmm.leedcode.array._905sortArrayByParity;

/**
 * @Author: cmm
 * @Date: 2018/11/7 3:06 PM
 */
public class Solution {
    public int[] sortArrayByParity(int[] A) {
        for (int i = 0, j = 0; j < A.length; j++) {
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }

    public static void main(String[] args) {

    }
}
