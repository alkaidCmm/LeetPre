package com.cmm.leetcode.tree.traversal;

public class Node<T> {
	private T value;
	private Node<T> left;
	private Node<T> right;

	public Node(T value) {
		super();
		this.value = value;
	}

	public Node(T value, Node<T> left, Node<T> right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

}
