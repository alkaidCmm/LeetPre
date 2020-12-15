package com.cmm.leetcode._872LeafSimilar;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cmm
 * @Date: 2018/8/29 10:01 PM
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList();
        List<Integer> leaves2 = new ArrayList();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    /**
     * 递归找到所有的叶子结点
     *
     * @param node
     * @param leafValues
     */
    public void dfs(TreeNode node, List<Integer> leafValues) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                leafValues.add(node.val);
            }
            dfs(node.left, leafValues);
            dfs(node.right, leafValues);
        }
    }
}

