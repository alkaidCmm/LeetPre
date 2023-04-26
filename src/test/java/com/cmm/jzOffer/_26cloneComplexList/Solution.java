package com.cmm.jzOffer._26cloneComplexList;

/**
 * 题目：有一个复杂链表，其结点除了有一个m_pNext指针指向下一个结点外，还有一个m_pSibling指向链表中的任一结点或者NULL
 * 
 * @author cmm
 *
 */
public class Solution {
	// 复制复杂链表，第一部：新创建的每个结点N’链接在原先结点N的后面
	public void CloneNodes(ComplexListNode head) {
		// ComplexListNode tempHead = head;
		while (head != null) {
			ComplexListNode newHead = new ComplexListNode();
			newHead.setValue(head.getValue());
			newHead.setNext(head.getNext());
			newHead.setSibling(null);
			head.setNext(newHead);// //将新复制的结点链接在原始结点的后面
			head = newHead.getNext();// 头指针移到下一位
		}
	}

	// 复杂链表的复制，第二步：设置我们复制出来的链表上的结点的m_pSibling
	public void connectSiblingNodes(ComplexListNode head) {
		while (head != null) {
			ComplexListNode newHead = head.getNext();
			if (head.getSibling() != null)
				newHead.setSibling(head.getSibling().getNext());
			head = newHead.getNext();
		}
	}

	// 复杂链表的拆分：把奇数位置的结点链接起来就是原始链表，把偶数位置的结点链接出来就是复制出来的链表
	// 注意：这里代码可能出现问题，主要因为指针和引用问题，但是代码思路是正确的
	public ComplexListNode reConnectNodes(ComplexListNode head) {
		ComplexListNode ClonedHead = null;
		ComplexListNode ClonedNode = null;
		if (head != null) {
			ClonedHead = ClonedNode = head.getNext();
			head.setNext(ClonedNode.getNext());
			head = head.getNext();
		}
		while (head != null) {
			ClonedNode.setNext(head.getNext());
			ClonedNode = ClonedNode.getNext();
			head.setNext(ClonedNode.getNext());
			head = head.getNext();
		}
		return ClonedHead;
	}

	public static void main(String[] args) {

	}

}
