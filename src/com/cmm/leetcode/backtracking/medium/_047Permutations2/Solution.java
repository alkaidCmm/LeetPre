package com.cmm.leetcode.backtracking.medium._047Permutations2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cmm
 * @date 2020/7/17 8:20 PM
 * @desc Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList();
        List<Integer> track = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(nums, track, isVisited, ret);
        return ret;
    }

    private void backTracking(int[] nums, List<Integer> track, boolean[] isVisited, List<List<Integer>> ret) {
        if (track.size() == nums.length) {
            ret.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !isVisited[i - 1]) {
                continue;
            }
            isVisited[i] = true;
            track.add(nums[i]);
            backTracking(nums, track, isVisited, ret);
            isVisited[i] = false;
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        new Solution().permuteUnique(nums);
    }
}
