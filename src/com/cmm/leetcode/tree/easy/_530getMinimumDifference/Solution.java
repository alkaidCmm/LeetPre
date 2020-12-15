package com.cmm.leetcode.tree.easy._530getMinimumDifference;

import com.cmm.leetcode.tree.TreeNode;

/**
 * @author cmm
 * @date 2020/7/13 2:23 PM
 * @desc
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * Output:
 * 1
 *
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 *
 *
 * Note:
 *
 * There are at least two nodes in this BST.
 * This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 */
public class Solution {
    Integer pre;
    Integer min= Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if(root.left!=null){
             getMinimumDifference(root.left);
        }

        if(pre!=null){
            min=Math.min(min, root.val-pre);
        }
        pre=root.val;

        if(root.right!=null){
             getMinimumDifference(root.right);
        }
        return min;
    }
}
