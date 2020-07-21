package com.cmm.leedcode.backtracking.medium._046Permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cmm
 * @date 2020/7/17 5:29 PM
 * @desc Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Solution {

    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new LinkedList<>();
        backTracking(nums, track);
        return ret;
    }

    private void backTracking(int[] nums, List<Integer> track) {
        if (track.size() == nums.length) {
            ret.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backTracking(nums, track);
            track.remove(track.size() - 1);
        }
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Solution().permute(nums);
    }
}
