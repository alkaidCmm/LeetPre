package com.cmm.leetcode.tree.medium._144preorderTraversal;

import com.cmm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caimingming02
 * @date 2020/10/27 8:38 AM
 * @desc
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret=new ArrayList<>();

        preorderTraversal(root,ret);
        return ret;
    }

    private void preorderTraversal(TreeNode root, List<Integer> ret) {
        if(root==null){
            return;
        }
        ret.add(root.val);
        preorderTraversal(root.left,ret);
        preorderTraversal(root.right,ret);
    }
}
