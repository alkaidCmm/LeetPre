package com.cmm.leedcode.tree._104maxDepth;

import com.cmm.leedcode.tree.TreeNode;

/**
 * @author cmm
 * @date 2020/6/27 7:46 PM
 * @desc
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = new TreeNode(3);

        TreeNode nine = new TreeNode(9);

        TreeNode twenty = new TreeNode(20);
        TreeNode fiveteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);

        root.left = nine;
        root.right = twenty;
        twenty.left = fiveteen;
        twenty.right = seven;

        s.maxDepth(root);

    }


}
