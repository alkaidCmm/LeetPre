package com.cmm.leedcode.tree.easy._100sameTree;

import com.cmm.leedcode.tree.TreeNode;

/**
 * @author cmm
 * @date 2020/6/27 6:36 PM
 * @desc
 */
public class Solution {


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}


