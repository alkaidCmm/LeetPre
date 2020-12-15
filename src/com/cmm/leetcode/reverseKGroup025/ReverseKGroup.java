package com.cmm.leetcode.reverseKGroup025;

/**
 * 
 * 原题 　Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.If the number of nodes is not a multiple of k then
 * left-out nodes in the end should remain as it is. You may not alter the
 * values in the nodes, only nodes itself may be changed. Only constant memory
 * is allowed.For example,Given this linked list: 1->2->3->4->5 For k = 2, you
 * should return: 2->1->4->3->5For k = 3, you should return: 3->2->1->4->5 题目大意
 * 　　给定一个单链表，和一个分组数K，每K个结点进行反转，如果最后的结点数不足K个就保持原来的链接顺序不变
 * 
 */
public class ReverseKGroup {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (k <= 1) {
			return head;
		}
		ListNode root = new ListNode(0);
		ListNode groupHead = root;// 分组的头一个元素的前驱
		ListNode curr = head;// 当前要处理的结点
		ListNode groupTail = head;// 处理好的链表的尾结点
		ListNode next;// 当前要处理的结点的后继

		int count = 0;// 对每个组，处理了多少个结点
		while (curr != null) {
			if (count == 0)// 如果是分组的第一个元素就记录它
				groupTail = curr;
			count++;// 记录处理的元素个数
			next = curr.next;// 记录下一个待处理结点
			// 进行尾插法操作
			curr.next = groupHead.next;
			groupHead.next = curr;
			curr = next;
			// 已经处理完了k个结点，分组头的前驱移动到最后一个链接好的结点
			if (count == k) {
				groupHead = groupTail;
				// 计数器归零
				count = 0;
			}
		}
		// 说明结点个数不是k的整数倍，将最后不是整数倍的个元素的结点，
		// 再次使用尾插法进行还原
		if (count != 0) {
			curr = groupHead.next;
			groupHead.next = null;
			while (curr != null) {
				next = curr.next;
				curr.next = groupHead.next;
				groupHead.next = curr;
				curr = next;
			}
		}
		return root.next;
	}

	public static void main(String[] args) {
	
	}

}
