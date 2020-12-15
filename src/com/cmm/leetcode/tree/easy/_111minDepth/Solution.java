package com.cmm.leetcode.tree.easy._111minDepth;

import com.cmm.leetcode.tree.TreeNode;

/**
 * @author cmm
 * @date 2020/6/28 2:04 PM
 * @desc Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its minimum depth = 2.
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        s.minDepth(root);

    }
}
