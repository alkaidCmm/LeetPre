package com.cmm.leedcode.tree._783minDiffInBST;

import com.cmm.leedcode.tree.TreeNode;

/**
 * @author cmm
 * @date 2020/7/7 5:39 PM
 * @desc 计算二叉搜索树中，相邻节点之间最小的数值差
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.
 * <p>
 * Example :
 * <p>
 * Input: root = [4,2,6,1,3,null,null]
 * Output: 1
 * Explanation:
 * Note that root is a TreeNode object, not an array.
 * <p>
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
 * <p>
 * 4
 * /   \
 * 2      6
 * / \
 * 1   3
 * <p>
 * while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
 * Note:
 * <p>
 * The size of the BST will be between 2 and 100.
 * The BST is always valid, each node's value is an integer, and each node's value is different.
 * This question is the same as 530: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
public class Solution {

    Integer pre;
    Integer min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root.left != null) {
            minDiffInBST(root.left);
        }
        if (pre != null) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        if (root.right != null) {
            minDiffInBST(root.right);
        }
        return min;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode l = new TreeNode(5);
        TreeNode r = new TreeNode(15);
        TreeNode ll = new TreeNode(3);
        TreeNode lr = new TreeNode(7);
        TreeNode rr = new TreeNode(18);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.right = rr;
        Solution s = new Solution();
        int ret = s.minDiffInBST(root);
        System.out.println(ret);
    }

}
