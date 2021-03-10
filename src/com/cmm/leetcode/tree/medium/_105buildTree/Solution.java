package com.cmm.leetcode.tree.medium._105buildTree;

import com.cmm.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cmm
 * @date 2019/12/26 4:00 PM
 * @desc 前序、中序构造二叉树
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = inMap.get(root.val);
        int numsLeft = rootIndex - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, rootIndex - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, rootIndex + 1, inEnd, inMap);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{4, 2, 1, 3, 6, 5, 7};
        int[] inorder = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Solution().buildTree(preorder, inorder);
    }
}
