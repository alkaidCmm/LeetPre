package com.cmm.leetcode.tree.easy._110isBalanced;

import com.cmm.leetcode.tree.TreeNode;

/**
 * @author cmm
 * @date 2020/6/28 9:59 AM
 * @desc Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 *
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 * 平衡二叉树判定，不包括排序规则
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root) != -1;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        TreeNode root = new TreeNode(3);
//        TreeNode rl = new TreeNode(9);
//        TreeNode rr = new TreeNode(20);
//        TreeNode rrl = new TreeNode(15);
//        TreeNode rrr = new TreeNode(7);
//        root.left = rl;
//        root.right = rr;
//        rr.left = rrl;
//        rr.right = rrr;
        TreeNode root = new TreeNode(1);
        TreeNode rl = new TreeNode(2);
        TreeNode rr = new TreeNode(2);
        TreeNode rll = new TreeNode(3);
        TreeNode rlr = new TreeNode(3);
        TreeNode rlll = new TreeNode(4);
        TreeNode rllr = new TreeNode(4);
        root.left=rl;
        root.right=rr;
        rl.left=rll;
        rl.right=rlr;
        rll.left=rlll;
        rll.right=rllr;
        s.isBalanced(root);

    }
}
