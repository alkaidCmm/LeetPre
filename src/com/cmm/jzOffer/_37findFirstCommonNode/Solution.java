package com.cmm.jzOffer._37findFirstCommonNode;

public class Solution {
	private static class ListNode {
		int val;
		ListNode next;

		public ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
		}

		public String toString() {
			return val + "";
		}
	}

	private static int getListLength(ListNode head) {
		int result = 0;
		while (head != null) {
			result++;
			head = head.next;
		}
		return result;
	}

	public static ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
		int length1 = getListLength(head1);
		int length2 = getListLength(head2);
		int diff = length1 - length2;
		ListNode longListHead = head1;// 长为1
		ListNode shortListHead = head2;// 短为2
		if (diff < 0) {
			longListHead = head2;
			shortListHead = head1;
			diff = length2 - length1;
		}
		for (int i = 0; i < diff; i++) {// 保证在两个头指针一起移动的时候，可以最后在公共节点相遇
			longListHead = longListHead.next;
		}
		while (longListHead != null && shortListHead != null
				&& longListHead != shortListHead) {
			longListHead = longListHead.next;
			shortListHead = shortListHead.next;
		}
		// 返回第一个相同的公共结点，如果没有返回null
		return longListHead;
	}

	private static void test1() {
		// 第一个公共结点在链表中间
		// 1 - 2 - 3 \
		//           6 - 7
		//    4 - 5 /
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n6;
		n6.next = n7;
		n4.next = n5;
		n5.next = n6;
		System.out.println(findFirstCommonNode(n1, n4)); // 6
	}

	private static void test2() {
		// 没有公共结点
		// 1 - 2 - 3 - 4
		//
		// 5 - 6 - 7
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n5.next = n6;
		n6.next = n7;
		System.out.println(findFirstCommonNode(n1, n5)); // null
	}

	private static void test3() {
		// 公共结点是最后一个结点
		// 1 - 2 - 3 - 4 \
		// 7
		// 5 - 6 /
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n7;
		n5.next = n6;
		n6.next = n7;
		System.out.println(findFirstCommonNode(n1, n5)); // 7
	}

	private static void test4() {
		// 公共结点是第一个结点
		// 1 - 2 - 3 - 4 - 5
		// 两个链表完全重合
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		System.out.println(findFirstCommonNode(n1, n1)); // 1
	}

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}
}
