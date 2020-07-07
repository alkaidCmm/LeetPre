package com.cmm.leedcode.tree._965isUnivalTree;

import com.cmm.leedcode.tree.TreeNode;

/**
 * @author cmm
 * @date 2020/7/7 9:55 AM
 * @desc 二叉树只有一个数值
 * A binary tree is univalued if every node in the tree has the same value.
 * <p>
 * Return true if and only if the given tree is univalued.
 */
public class Solution {
    public boolean isUnivalTree(TreeNode root) {
        int val = root.val;
        return dfs(root,val);
    }

    private boolean dfs(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            return false;
        }
        return dfs(root.left, val) && dfs(root.right, val);
    }
}
