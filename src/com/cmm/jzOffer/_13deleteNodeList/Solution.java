package com.cmm.jzOffer._13deleteNodeList;


/**
 * 在O（1）时间删除链表节点 题目：给定单向链表的头指针和一个节点指针，在O(1)删除该节点
 * 思路：--->i-->j要想删除i,先把i的下一个节点j的内容复制到i,然后再把i的指针指向节点j的下一节点，此时再删除节点j，其效果刚好是把节点i删除了
 * ;如果被删节点位于链表的尾部，我们需要表里获得被删节节点的前一个节点，并完成删除；如果链表只有一个节点，即头节点等于尾节点，要把头节点置空
 * 
 * @author cmm
 *
 */
public class Solution {

	public static void deleteNode(ListNode head, ListNode toBeDeleted) {
		if (head == null || toBeDeleted == null)
			return;
		if (toBeDeleted.getNext() != null) {// 要删除的节点不是尾节点
			ListNode p = toBeDeleted.getNext();// 保存被删除节点的下一个节点
			toBeDeleted.setValue(p.getValue());// 被删除节点的下一个节点的值赋值给被删除节点，
			toBeDeleted.setNext(p.getNext());// 被删除节点指向被删除节点的下一个节点的下一个节点
		} else if (head == toBeDeleted)// 被删除节点的下一个节点为空，即getNext为空，链表只有一个头节点
			head = null;
		else {
			// 删除尾节点
			ListNode currentNode = head;
			while (currentNode.getNext() != toBeDeleted)//
				currentNode = currentNode.getNext();// 后的被删节点的前一个节点
		}
	}

	public static void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.println(current.getValue());
			current = current.getNext();
		}
		System.out.println("---------");
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		head.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);

		System.out.println("原始链表");
		printList(head);

		deleteNode(head, n4);
		System.out.println("删除节点n4后");
		printList(head);

	}

}
