package com.cmm.leedcode.tree._101symmetricTree;

import com.cmm.leedcode.tree.TreeNode;

/**
 * @author cmm
 * @date 2020/6/27 6:49 PM
 * @desc 镜像二叉树判定
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);

    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }



}
