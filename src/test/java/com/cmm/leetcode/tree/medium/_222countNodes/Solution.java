package com.cmm.leetcode.tree.medium._222countNodes;

import com.cmm.leetcode.tree.TreeNode;

/**
 * @author caimingming02
 * @date 2020/10/27 10:04 AM
 * @desc
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        return  countNodes(root.left)+countNodes(root.right)+1;
    }
}
