package com.cmm.leedcode.tree.medium._145postorderTraversal;

import com.cmm.leedcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caimingming02
 * @date 2020/10/27 9:05 AM
 * @desc
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();

        postorderTraversal(root, ret);
        return ret;
    }

    private void postorderTraversal(TreeNode root, List<Integer> ret) {
        if(root==null){
            return;
        }
        postorderTraversal(root.left, ret);
        postorderTraversal(root.right, ret);
        ret.add(root.val);
    }
}

