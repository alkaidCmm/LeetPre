package com.cmm.leetcode.tree.easy._108sortedArrayToBST;

import com.cmm.leetcode.tree.TreeNode;

/**
 * @author cmm
 * @date 2020/6/27 8:51 PM
 * @desc Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted array: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * <p>
 * 排序的数组构建二叉树，可能存在多种可能
 */
public class Solution {


    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, low, mid - 1);
        node.right = helper(nums, mid + 1, high);
        return node;
    }
}
