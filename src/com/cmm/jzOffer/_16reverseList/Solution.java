package com.cmm.jzOffer._16reverseList;

import com.cmm.jzOffer._13deleteNodeList.ListNode;

/**
 * 对于一个链表，反转该链表并返回头节点
 * 
 * @author cmm 没怎么看懂,下次继续
 */
public class Solution {
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
		n7.setNext(null);
		ListNode reverseHead = new Solution().reverseList(head);
		ListNode temp = reverseHead;
		int count = 0;
		while (temp != null) {
			count++;
			System.out.println(temp.getValue() + ",count=" + count);
			temp = temp.getNext();
		}

	}

	/**
	 * 递归，在反转当前节点之前先反转后续节点
	 */
	public static ListNode reverse(ListNode head) {
		if (null == head || null == head.getNext()) {
			return head;
		}
		ListNode reversedHead = reverse(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);
		return reversedHead;
	}

	/**
	 * 遍历，将当前节点的下一个节点缓存后更改当前节点指针，例如1->2->3->4->5
	 */
	public ListNode reverseList(ListNode head) {
		ListNode reverseHead = null;// 保存反转后的新的链表的头节点
		ListNode pNode = head;
		ListNode pPrev = null;
		while (pNode != null) {
			ListNode pNext = pNode.getNext();// 获取原链表的节点的下一个节点
			if (pNext != null)
				reverseHead = pNode;
			pNode.setNext(pPrev);
			pPrev = pNode;//让prev指向下一个节点pNode
			pNode = pNext;//让pNode指向下一个节点pNext
		}
		return reverseHead;

	}
}
