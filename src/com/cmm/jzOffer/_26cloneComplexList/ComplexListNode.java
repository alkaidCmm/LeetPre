package com.cmm.jzOffer._26cloneComplexList;

public class ComplexListNode {
	private int value;
	private ComplexListNode next;
	private ComplexListNode sibling;// 指向任意节点

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public ComplexListNode getNext() {
		return next;
	}

	public void setNext(ComplexListNode next) {
		this.next = next;
	}

	public ComplexListNode getSibling() {
		return sibling;
	}

	public void setSibling(ComplexListNode sibling) {
		this.sibling = sibling;
	}

}
