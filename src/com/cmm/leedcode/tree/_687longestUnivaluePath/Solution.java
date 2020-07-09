package com.cmm.leedcode.tree._687longestUnivaluePath;

import com.cmm.leedcode.tree.TreeNode;

/**
 * @author cmm
 * @date 2020/7/8 11:48 AM
 * @desc 二叉树 路径中连续数值相同的最大值
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
 * <p>
 * The length of path between two nodes is represented by the number of edges between them.
 * Input:
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * Output: 2
 * <p>
 * Input:
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * Output: 2
 * <p>
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */
public class Solution {

    /**
     * 后序遍历方式，数组缓存中间态最值
     */
    public int longestUnivaluePath(TreeNode root) {
        int[] ret = new int[1];
        if (root != null) {
            dfs(root, ret);
        }
        return ret[0];
    }


    private int dfs(TreeNode root, int[] ret) {
        int leftCur = root.left != null ? dfs(root.left, ret) : 0;
        int rightCur = root.right != null ? dfs(root.right, ret) : 0;
        int leftLength = root.left != null && root.val == root.left.val ? leftCur + 1 : 0;
        int rightLength = root.right != null && root.val == root.right.val ? rightCur + 1 : 0;
        ret[0] = Math.max(ret[0], leftLength + rightLength);
        return Math.max(leftLength, rightLength);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode l = new TreeNode(5);
        TreeNode r = new TreeNode(5);
        TreeNode ll = new TreeNode(4);
        TreeNode lr = new TreeNode(5);
        TreeNode rl = new TreeNode(5);
        TreeNode rr = new TreeNode(4);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.left = rl;
        r.right = rr;
        Solution s = new Solution();
        int ret = s.longestUnivaluePath(root);
        System.out.println(ret);
    }
}
