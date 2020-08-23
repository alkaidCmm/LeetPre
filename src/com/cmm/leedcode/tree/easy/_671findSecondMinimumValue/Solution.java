package com.cmm.leedcode.tree.easy._671findSecondMinimumValue;

import com.cmm.leedcode.tree.TreeNode;

/**
 * @author cmm
 * @date 2020/7/8 8:21 PM
 * @desc Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 * If no such second minimum value exists, output -1 instead.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 2
 * / \
 * 2   5
 * / \
 * 5   7
 * <p>
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input:
 * 2
 * / \
 * 2   2
 * <p>
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 */
public class Solution {


    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int min) {
        if (root == null) {
            return -1;
        }
        if (root.val > min) {
            return root.val;
        }
        int left = dfs(root.left, min);
        int right = dfs(root.right, min);
        return left == -1 || right == -1 ? Math.max(left, right) : Math.min(left, right);
    }
}
