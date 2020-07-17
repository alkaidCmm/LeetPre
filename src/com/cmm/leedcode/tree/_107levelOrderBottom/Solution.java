package com.cmm.leedcode.tree._107levelOrderBottom;

import com.cmm.leedcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author cmm
 * @date 2020/6/27 8:15 PM
 * @desc Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * <p>
 * 层序遍历并存入list
 */
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // todo
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> storeStack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curTreeNode = stack.pop();
            if (curTreeNode.left != null) {
                stack.push(curTreeNode.left);
            }
        }
        return ret;
    }

}

