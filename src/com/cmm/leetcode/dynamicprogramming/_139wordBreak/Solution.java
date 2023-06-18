package com.cmm.leetcode.dynamicprogramming._139wordBreak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set =new HashSet();
        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        int length=s.length();
        // s字符串中，从0～i, 对应是否包含所有wordDict
        boolean[] dp= new boolean[length];
        dp[0] =true;
        for(int i=1;i <= length;i++){
            for(int j=0;j<i;j++){
                //
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i]= true;
                    break;

                }
            }
        }

        return dp[length];
    }

    public static void main(String[] args) {
        new Solution().wordBreak("catsandog", Stream.of("cats", "dog", "sand", "and", "cat").collect(Collectors.toList()));
    }
}
