package com.cmm.leedcode.tree.medium._094inorderTraversal;

import com.cmm.leedcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author cmm
 * @date 2020/7/24 9:08 AM
 * @desc 二叉树遍历 递归非递归
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        inOrder(root, ret);
        return ret;
    }

    private void inOrder(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        inOrder(root.left, ret);
        ret.add(root.val);
        inOrder(root.right, ret);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur=stack.pop();
                ret.add(cur.val);
                cur=cur.right;
            }
        }
        return ret;
    }
}
