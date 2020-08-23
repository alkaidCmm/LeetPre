package com.cmm.leedcode.tree.easy._1022sumRootToLeaf;

import com.cmm.leedcode.tree.TreeNode;

/**
 * @author cmm
 * @date 2020/7/3 8:47 PM
 * @desc
 * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 *
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 *
 * Return the sum of these numbers.
 *
 * Example 1:
 *
 * Input: [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 *
 * Note:
 *
 * The number of nodes in the tree is between 1 and 1000.
 * node.val is 0 or 1.
 * The answer will not exceed 2^31 - 1.
 */
public class Solution {

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }

        val = val * 2 + root.val;
        return root.left == null && root.right == null ? val : dfs(root.left, val) + dfs(root.right, val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(0);
        TreeNode r = new TreeNode(1);
        TreeNode ll = new TreeNode(0);
        TreeNode lr = new TreeNode(1);
        TreeNode rl = new TreeNode(0);
        TreeNode rr = new TreeNode(1);

        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.left = rl;
        r.right = rr;

        Solution s = new Solution();
        int ret = s.sumRootToLeaf(root);
        System.out.println(ret);


    }
}
