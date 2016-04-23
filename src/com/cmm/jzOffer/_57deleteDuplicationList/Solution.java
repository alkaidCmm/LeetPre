package com.cmm.jzOffer._57deleteDuplicationList;

public class Solution {
	/**
	 * 静态内部类，定义存储结构
	 * 
	 * @author cmm
	 *
	 */
	public static class ListNode {
		private int val;
		private ListNode next;

		public ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return val + "";
		}
	}

	public static ListNode deleteDuplicationList(ListNode head) {
		if (head == null)
			return null;
		ListNode root = new ListNode();
		root.next = head;
		ListNode prev = root;// 记录前驱
		ListNode node = head;// 记入当前结点
		while (node != null && node.next != null) {
			if (node.val == node.next.val) {
				while (node.next != null && node.val == node.next.val)
					node = node.next;
				prev.next = node.next;// 指向下一个节点，prev.next也可能是重复结点,
										// 所以prev不要移动到下一个结点
			} else {// 相邻两个值不同，说明node不可删除，要保留
				prev.next = node;
				prev = prev.next;
			}
			node = node.next;
		}
		return root.next;// 这里不能使用node或node.next
	}

	public static void main(String[] args) {
		test01();
		test02();
		test03();
		test04();
		test05();
		test06();
		test07();
		test08();
		test09();
		test10();
	}

	private static void print(ListNode head) {
		while (head != null) {
			System.out.print(head + "->");
			head = head.next;
		}
		System.out.println("null");
	}

	// 1->2->3->3->4->4->5
	private static void test01() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(4);
		ListNode n7 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		ListNode result = deleteDuplicationList(n1);
		print(result);
	}

	// 1->2->3->4->5->6->7
	private static void test02() {
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
		n5.next = n6;
		n6.next = n7;
		ListNode result = deleteDuplicationList(n1);
		print(result);
	}

	// 1->1->1->1->1->1->2
	private static void test03() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(1);
		ListNode n6 = new ListNode(1);
		ListNode n7 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		ListNode result = deleteDuplicationList(n1);
		print(result);
	}

	// 1->1->1->1->1->1->1
	private static void test04() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(1);
		ListNode n6 = new ListNode(1);
		ListNode n7 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		ListNode result = deleteDuplicationList(n1);
		print(result);
	}

	// 1->1->2->2->3->3->4->4
	private static void test05() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(3);
		ListNode n7 = new ListNode(4);
		ListNode n8 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		ListNode result = deleteDuplicationList(n1);
		print(result);
	}

	// 1->1->2->3->3->4->5->5
	private static void test06() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(4);
		ListNode n7 = new ListNode(5);
		ListNode n8 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		ListNode result = deleteDuplicationList(n1);
		print(result);
	}

	// 1->1->2->2->3->3->4->5->5
	private static void test07() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(3);
		ListNode n7 = new ListNode(4);
		ListNode n8 = new ListNode(5);
		ListNode n9 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		ListNode result = deleteDuplicationList(n1);
		print(result);
	}

	// 1->2
	private static void test08() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		ListNode result = deleteDuplicationList(n1);
		print(result);
	}

	// 1
	private static void test09() {
		ListNode n1 = new ListNode(1);
		ListNode result = deleteDuplicationList(n1);
		print(result);
	}

	// null
	private static void test10() {
		ListNode result = deleteDuplicationList(null);
		print(result);
	}
}
