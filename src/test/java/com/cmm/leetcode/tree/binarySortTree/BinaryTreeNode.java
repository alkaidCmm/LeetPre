package com.cmm.leetcode.tree.binarySortTree;

/**
 * 二叉搜索树
 */
public class BinaryTreeNode {
	private BinaryTreeNode leftChild;
	private BinaryTreeNode rightChild;
	private BinaryTreeNode parent;
	private int value;
	public BinaryTreeNode(int value) {
		this.value=value;
	}
	public BinaryTreeNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(BinaryTreeNode leftChild) {
		this.leftChild = leftChild;
	}
	public BinaryTreeNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(BinaryTreeNode rightChild) {
		this.rightChild = rightChild;
	}
	public BinaryTreeNode getParent() {
		return parent;
	}
	public void setParent(BinaryTreeNode parent) {
		this.parent = parent;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
