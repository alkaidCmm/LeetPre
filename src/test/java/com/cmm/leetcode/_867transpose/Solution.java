package com.cmm.leetcode._867transpose;

/**
 * @Author: cmm
 * @Date: 2018/8/30 12:01 AM
 */
class Solution {
    public int[][] transpose(int[][] A) {
        int R = A.length, C = A[0].length;
        int[][] ans = new int[C][R];
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                ans[c][r] = A[r][c];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        int[][] a={{1,2,3},{4,5,6}};
        s.transpose(a);
    }
}