package com.cmm.leedcode._868BinaryGap;

/**
 * @Author: cmm
 * @Date: 2018/8/29 10:17 PM
 */
public class Solution {
    public int binaryGap(int N) {
        int[] A = new int[32];
        int t = 0;
        for (int i = 0; i < 32; ++i) {
            if (((N >> i) & 1) != 0) {
                A[t++] = i;
            }
        }
        int ans = 0;
        for (int i = 0; i < t - 1; ++i) {
            ans = Math.max(ans, A[i + 1] - A[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int result = s.binaryGap(22);
        int result = s.binaryGap(36);

        System.out.println(result);
//        System.out.println((22 >> 1) & 1);
//        System.out.println((22 >> 2) & 1);

    }
}
