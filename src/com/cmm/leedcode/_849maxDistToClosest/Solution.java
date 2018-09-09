package com.cmm.leedcode._849maxDistToClosest;

import java.util.Arrays;

/**
 * @Author: cmm
 * @Date: 2018/8/30 1:04 AM
 */
public class Solution {
    public int maxDistToClosest(int[] seats) {
        int res = 0, n = seats.length;
        for (int i = 0, zero = 0; i < n; ++i) {
            if (seats[i] == 1) {
                zero = 0;
            } else {
                res = Math.max(res, (++zero + 1) / 2);
            }
        }
        for (int i = 0, zero = 0; seats[i] == 0; ++i) {
            res = Math.max(res, ++zero);
        }
        for (int i = n - 1, zero = 0; seats[i] == 0; --i) {
            res = Math.max(res, ++zero);
        }
        return res;
    }

    public int maxDistToClosest2(int[] seats) {
        int N = seats.length;
        int[] left = new int[N], right = new int[N];
        Arrays.fill(left, N);
        Arrays.fill(right, N);

        // 从左到右，0位置到相邻左边第一个1的距离
        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) left[i] = 0;
            else if (i > 0) left[i] = left[i - 1] + 1;
        }

        // 从右到左，0位置到相邻右边第一个1的距离
        for (int i = N - 1; i >= 0; --i) {
            if (seats[i] == 1) right[i] = 0;
            else if (i < N - 1) right[i] = right[i + 1] + 1;
        }

        int ans = 0;
        for (int i = 0; i < N; ++i)
            // 对比各个空位左右相邻的1的最小值，并取得这些最小值里边的最大值
            if (seats[i] == 0)
                ans = Math.max(ans, Math.min(left[i], right[i]));
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1, 0, 0, 0, 1, 0, 1};
        s.maxDistToClosest2(a);
    }
}
