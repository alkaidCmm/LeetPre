package com.cmm.leetcode.tree.easy._538convertBST;

import com.cmm.leetcode.tree.TreeNode;

/**
 * @author cmm
 * @date 2020/7/13 2:05 PM
 * @desc
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 * Note: This question is the same as 1038: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 */
public class Solution {

    int sum=0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }

}
