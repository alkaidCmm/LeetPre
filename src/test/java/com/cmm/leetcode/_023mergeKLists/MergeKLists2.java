package com.cmm.leetcode._023mergeKLists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists2 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	/**
	 * 方法一，通过比较器来比较
	 */
	private Comparator<ListNode> listNodeComparator = new Comparator<ListNode>() {// 定义比较器
		public int compare(ListNode o1, ListNode o2) {
			if (o1 == null)
				return 1;
			else if (o2 == null)
				return -1;
			return o1.val - o2.val;
		}
	};

	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists.size() == 0 || lists == null)
			return null;
		// 放入优先级队列进行比较
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(
				lists.size(), listNodeComparator);// 暂时队列还是空队列
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i) != null) {
				heap.add(lists.get(i));
			}
		}
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (!heap.isEmpty()) {
			ListNode head = heap.poll();// 获取头元素
			tail.next = head;
			tail = head;
			if (head.next != null) {
				heap.add(head.next);// 计入队列中
			}
		}
		return dummy.next;
	}

	/*
	 * 
	 * 通过链表之间两两合并
	 */
	private ListNode mergeTwoLists(ListNode a, ListNode b) {
		ListNode first = new ListNode(0);
		ListNode tail = first;
		while (a != null && b != null) {
			if (a.val <= b.val) {
				tail.next = a;
				a = a.next;
			} else {
				tail.next = b;
				b = b.next;
			}
			tail = tail.next;

		}
		if (a != null)
			tail.next = a;
		else
			tail.next = b;
		return first.next;
	}

	public ListNode mergeKLists2(List<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		while (lists.size() > 1) {// 当最终合并只剩下一个链表，合并结束
			List<ListNode> new_lists = new ArrayList<ListNode>();
			for (int i = 0; i + 1 < lists.size(); i += 2)
				new_lists.add(mergeTwoLists(lists.get(i), lists.get(i + 1)));
			if (lists.size() % 2 == 1)
				new_lists.add(lists.get(lists.size() - 1));
			lists=new_lists;
			
		}
		return lists.get(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
