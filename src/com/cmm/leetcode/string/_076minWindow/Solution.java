package com.cmm.leetcode.string._076minWindow;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String minWindow(String s, String t) {
        Map<Character, Integer> map=new HashMap<Character, Integer>();

        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0) +1);
        }

        int minLeft=0;
        int minRight=0;
        // s的长度
        int minLength=s.length();
        // t的长度
        int count=t.length();
        boolean flag=false;

        int left=0;
        int right=0;

        while(right<s.length()){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                // 如果匹配到t中字符，对应count--, 直到完全count==0，说明完全匹配；

                if(map.get(c)>=0){
                    count--;
                }
            }
            // 说明left、right之间已经存在完全匹配到t的字符串
            while(left<=right && count==0){
                flag=true;
                int curLen=right-left+1;
                // 比较匹配到的长度，比替换对应的下标位置
                if(curLen<=minLength){
                    minLength = curLen;
                    minLeft=left;
                    minRight=right;
                }

                // 移动左指针之前的准备，需要对left原序
                char leftC = s.charAt(left);
                if(map.containsKey(leftC)){
                    // 这里类似需要对新加入的元素,当左指针右移，对应
                    map.put(leftC, map.get(leftC)+1);
                    if(map.get(leftC) >= 1) {
                        count++;
                    }
                }
                // 匹配完了之后，left指针右移动
                left ++;
            }
            right++;
        }

        return flag? s.substring(minLeft,minRight+1):"";
    }

    public static void main(String[] args) {
        new Solution().minWindow("ADOBECODEBANC","ABC");
    }
}
