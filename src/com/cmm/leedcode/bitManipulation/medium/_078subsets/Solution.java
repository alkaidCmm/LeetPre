package com.cmm.leedcode.bitManipulation.medium._078subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: cmm
 * @Date: 2018/11/3 1:40 PM
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


    public static void main(String[] args) {
        int a[]={1,2,3,4};
        Solution s=new Solution();
        System.out.println(s.subsets(a));
    }
}
