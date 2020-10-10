package com.cmm.leedcode.tree.easy._404sumOfLeftLeaves;

import com.cmm.leedcode.tree.TreeNode;

import java.util.Stack;

/**
 * @author caimingming02
 * @date 2020/9/29 9:50 AM
 * @desc
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    result += node.left.val;
                } else {
                    stack.push(node.left);
                }
            }
            if (node.right != null && (node.right.left != null || node.right.right != null)) {

                stack.push(node.right);
            }
        }
        return result;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                result += root.left.val;
            } else {
                result += sumOfLeftLeaves2(root.left);
            }
        }
        if (root.right != null) {
            result += sumOfLeftLeaves2(root.right);
        }
        return result;
    }



    }
