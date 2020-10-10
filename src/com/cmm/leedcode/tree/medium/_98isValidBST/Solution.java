package com.cmm.leedcode.tree.medium._98isValidBST;

import com.cmm.leedcode.tree.TreeNode;

import java.util.Stack;

/**
 * @author caimingming02
 * @date 2020/10/10 5:56 PM
 * @desc Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        return (min == null || root.val > min.val)
                && (max == null || root.val < max.val)
                && isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }

}
