package com.cmm.leedcode._002addtwonumbers;

public class AddTwoNumbers {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ret = new ListNode(0);
		ListNode cur = ret;
		int sum = 0;
		while (true) {
			if (l1 != null) {
				System.out.print("1l.val="+l1.val);
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				System.out.println(",12.val="+l2.val);
				sum += l2.val;
				l2 = l2.next;
			}
			cur.val = sum % 10;
					System.out.println("cur.val="+cur.val);//这里即为结果值
			sum /= 10;
			if (l1 != null || l2 != null || sum != 0) {
				System.out.println("ssssum="+sum);
				cur = (cur.next = new ListNode(0));//将结果保存在单向链表中
			} else
				break;
		}
		return cur;
	}

	public static void main(String[] args) {
		AddTwoNumbers atn = new AddTwoNumbers();

		ListNode l1 = new ListNode(2);
		ListNode l12 = new ListNode(4);
		ListNode l13 = new ListNode(3);
		l1.next =l12;
		l12.next=l13;

		ListNode l2 = new ListNode(5);
		ListNode l22 = new ListNode(6);
		ListNode l23 = new ListNode(4);
		l2.next = l22;
		l22.next = l23;
		ListNode ln=atn.addTwoNumbers(l1, l2);
	}
}
