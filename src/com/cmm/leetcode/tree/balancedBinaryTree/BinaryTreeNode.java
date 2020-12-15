package com.cmm.leetcode.tree.balancedBinaryTree;

public class BinaryTreeNode {
	private int value;
	private BinaryTreeNode leftNode;
	private BinaryTreeNode rightNode;
	private BinaryTreeNode parentNode;

	public BinaryTreeNode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BinaryTreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BinaryTreeNode leftNode) {
		this.leftNode = leftNode;
		if (leftNode != null) {
			leftNode.setParentNode(this);
		}
	}

	public BinaryTreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(BinaryTreeNode rightNode) {
		this.rightNode = rightNode;
		if (rightNode != null) {
			rightNode.setParentNode(this);
		}
	}

	public BinaryTreeNode getParentNode() {
		return parentNode;
	}

	public void setParentNode(BinaryTreeNode parentNode) {
		this.parentNode = parentNode;
	}

	/**
	 * 判定有无子节点
	 * 
	 * @return
	 */
	public boolean hasSubNode() {
		if (this.leftNode != null || this.rightNode != null) {
			return true;
		} else {
			return false;
		}
	}
}
