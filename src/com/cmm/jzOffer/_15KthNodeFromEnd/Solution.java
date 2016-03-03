package com.cmm.jzOffer._15KthNodeFromEnd;

import com.cmm.jzOffer._13deleteNodeList.ListNode;

/**
 * 查找链表中倒数第K个节点
 * 思路：使用两个指针，第二个指针一开始右移K个位置，然后两个指针一起移动，直到第二个指针到达最后
 * @author cmm
 *
 */
public class Solution {
	public ListNode findKthToTail(ListNode head, int k) {
		if (head == null || k <= 0)
			return null;
		ListNode left = head;
		ListNode right = head;
		for (int i = 0; i < k - 1; i++) {
			if (right.getNext() != null) {
				right = right.getNext();
			} else
				return null;
		}
		while (right.getNext() != null) {
			left = left.getNext();
			right = right.getNext();
		}
		return left;
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
		System.out.println(new Solution().findKthToTail(head, 3).getValue());
	}

}
