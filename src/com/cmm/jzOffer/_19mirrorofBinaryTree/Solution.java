package com.cmm.jzOffer._19mirrorofBinaryTree;

/**
 * 题目：二叉树的镜像
 * 
 * @author cmm
 *
 */
public class Solution {
	/**
	 * 输入一棵二叉树，该函数输出它的镜像
	 * 
	 * @param root
	 */
	public void mirrorRecursively(BinaryTreeNode root) {
		if (root == null)// 头节点为空
			return;
		if (root.getLeft() == null && root.getRight() == null)// 只有跟结点
			return;
		BinaryTreeNode temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);
		BinaryTreeNode newHead = root;
		if (root.getLeft() != null)
			mirrorRecursively(root.getLeft());
		if (root.getRight() != null)
			mirrorRecursively(root.getRight());
	}

	public BinaryTreeNode mirrorRecursively_v2(BinaryTreeNode root){
		if(root==null){
			return null;
		}
		BinaryTreeNode tmp=root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(tmp);

		root.setLeft(mirrorRecursively_v2(root.getLeft()));
		root.setRight(mirrorRecursively_v2(root.getRight()));

		return root;
	}

	public void printPreOrder(BinaryTreeNode root) {
		if (root != null) {
			System.out.println(root.getValue());
			printPreOrder(root.getLeft());
			printPreOrder(root.getRight());
		}
	}

	public static void main(String[] args) {
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

		Solution s = new Solution();
		System.out.println("开始前序");
		s.printPreOrder(b1);
		System.out.println("镜像");
		s.mirrorRecursively(b1);
		s.printPreOrder(b1);
	}

}
