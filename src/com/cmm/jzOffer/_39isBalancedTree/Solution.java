package com.cmm.jzOffer._39isBalancedTree;

/**
 * 题目一：输入一棵二叉树的根结点，求该树的深度。从根结点到叶子点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 题目二：输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树中任意结点的左右子树的深度相差不超过 1 ，那么它就是一棵平衡二叉树。
 * 
 * @author cmm
 *
 */
public class Solution {
	/**
	 * 树深度
	 * 
	 * @param root
	 * @return
	 */
	public static int treeDepth(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		return left > right ? (left + 1) : (right + 1);
	}

	/**
	 * 判定树是否平衡，第一种解法
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isBalanced(BinaryTreeNode root) {
		if (root == null)
			return true;
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		int diff = left - right;
		if (diff > 1 || diff < -1)
			return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}

	public static boolean isBalanced2(BinaryTreeNode root) {
		int[] depth = new int[1];
		return isBalancedHelper(root, depth);
	}

	public static boolean isBalancedHelper(BinaryTreeNode root, int[] depth) {
		if (root == null) {
			depth[0] = 0;
			return true;
		}
		int[] left = new int[1];
		int[] right = new int[1];
		if (isBalancedHelper(root.left, left)
				&& isBalancedHelper(root.right, right)) {
			int diff = left[0] - right[0];
			if (diff >= -1 && diff <= 1) {
				depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
				return true;
			}
		}
		return false;
	}

}
