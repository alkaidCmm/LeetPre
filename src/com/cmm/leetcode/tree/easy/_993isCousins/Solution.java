package com.cmm.leetcode.tree.easy._993isCousins;

import com.cmm.leetcode.tree.TreeNode;

/**
 * @author cmm
 * @date 2020/7/7 9:19 AM
 * @desc 二叉树
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * <p>
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * <p>
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * <p>
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 */
public class Solution {
    private TreeNode xParent;
    private TreeNode yParent;
    private int xDepth;
    private int yDepth;

    public boolean isCousins(TreeNode root, int x, int y) {
        getDepthAndParent(root, x, y, 0, null);
        return (xDepth == yDepth) && xParent != yParent;
    }

    private void getDepthAndParent(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            xDepth = depth;
            xParent = parent;
        } else if (root.val == y) {
            yDepth = depth;
            yParent = parent;
        }
        getDepthAndParent(root.left, x, y, depth + 1, root);
        getDepthAndParent(root.right, x, y, depth + 1, root);
    }
}
