package com.cmm.leedcode.tree._543diameterOfBinaryTree;

import com.cmm.leedcode.tree.TreeNode;

/**
 * @author cmm
 * @date 2020/7/10 9:33 PM
 * @desc 给定二叉树，您需要计算树直径的长度。二叉树的直径是一棵树中任何两个节点之间的最长路径的长度。此路径可能会也可能不会通过根。
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * Example:
 * Given a binary tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class Solution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }


}
