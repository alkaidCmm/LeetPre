package com.cmm.leetcode.backtracking.medium._131partitions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret =new ArrayList();
        int length= s.length();

        if(length==0){
            return ret;
        }

        char[] sArr= s.toCharArray();
        // dp[i][j] 表示s[i][j] 是否为回文
        boolean[][] dp=new boolean[length][length];
        for(int right=0; right<length; right++){
            // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
            for(int left=0; left<=right; left++){
                // 满足条件：left、right字符相等，且要么相邻、要么上一轮为回文
                if(sArr[left] == sArr[right]&&(right - left <= 2|| dp[left+1][right-1] )){
                    dp[left][right] = true;
                }
            }
        }

        backtrack(s, 0, length, dp, new ArrayDeque<>(), ret);
        return ret;
    }

    private void backtrack(String s, int index, int length, boolean[][] dp, Deque<String> tracks, List<List<String>> ret) {
        if (index == length) {
            ret.add(new ArrayList(tracks));
            return;
        }

        for (int i = index; i < length; i++) {
            if (dp[index][i]) {
                tracks.addLast(s.substring(index, i + 1));
                backtrack(s, i + 1, length, dp, tracks, ret);
                tracks.removeLast();
            }
        }
    }



    public static void main(String[] args) {
        new Solution().partition("aab");
    }
}
