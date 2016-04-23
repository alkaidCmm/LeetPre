package com.cmm.jzOffer._50getLastCommonParent;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	/**
	 * 树的结点定义
	 */
	private static class TreeNode {
		int val;
		List<TreeNode> children = new LinkedList<>();

		public TreeNode() {
		}

		public TreeNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return val + "";
		}
	}

	public static void getNodePath(TreeNode root, TreeNode target,
			List<TreeNode> path) {
		if (root == null)// 根节点为空
			return;
		path.add(root);
		
	}
}
