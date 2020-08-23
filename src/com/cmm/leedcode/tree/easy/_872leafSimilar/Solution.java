package com.cmm.leedcode.tree.easy._872leafSimilar;

import com.cmm.leedcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cmm
 * @date 2020/7/7 11:56 AM
 * @desc 判断两个二叉树 叶子结点数值是否一致
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 * <p>
 * <p>
 * <p>
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * <p>
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * <p>
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * Both of the given trees will have between 1 and 200 nodes.
 * Both of the given trees will have values between 0 and 200
 */
public class Solution {


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new ArrayList<Integer>();
        List<Integer> leafs2 = new ArrayList<Integer>();
        dfs(root1, leafs1);
        dfs(root2, leafs2);
        return leafs1.equals(leafs2);
    }

    public void dfs(TreeNode root, List leafs) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafs.add(root.val);
        }
        dfs(root.right, leafs);
        dfs(root.left, leafs);
    }
}
