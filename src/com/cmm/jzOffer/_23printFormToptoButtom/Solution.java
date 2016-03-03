package com.cmm.jzOffer._23printFormToptoButtom;

import java.util.LinkedList;
import java.util.Queue;

import com.cmm.jzOffer._19mirrorofBinaryTree.BinaryTreeNode;
/**
 * 二叉搜索树的层序遍历
 * @author cmm
 *
 */
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		BinaryTreeNode b1 = new BinaryTreeNode(8);
		BinaryTreeNode b2 = new BinaryTreeNode(6);
		BinaryTreeNode b3 = new BinaryTreeNode(10);
		BinaryTreeNode b4 = new BinaryTreeNode(5);
		BinaryTreeNode b5 = new BinaryTreeNode(7);
		BinaryTreeNode b6 = new BinaryTreeNode(9);
		BinaryTreeNode b7 = new BinaryTreeNode(11);
		b1.setLeft(b2);
		b1.setRight(b3);
		b2.setLeft(b4);
		b2.setRight(b5);
		b3.setLeft(b6);
		b3.setRight(b7);
		s.printFromToptoButtom(b1);
	}

	public void printFromToptoButtom(BinaryTreeNode root) {
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		if (root != null)
			q.add(root);
		while (!q.isEmpty()) {
			BinaryTreeNode btn = q.poll();
			System.out.println(btn.getValue());
			if (btn.getLeft() != null)
				q.add(btn.getLeft());
			if (btn.getRight() != null)
				q.add(btn.getRight());
		}
	}
}
