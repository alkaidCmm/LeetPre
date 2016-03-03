package com.cmm.leedcode.mergeTwoLists021;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoLists {
	// public mergeTwoLists()

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
			next = null;
		}
	}

	public ListNode merge2SortList(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;// 保证不破坏原始
		ListNode result = new ListNode(0);
		ListNode p = result;
		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}
			p = p.next;
		}
		if (p1 != null)
			p.next = p1;
		if (p2 != null)
			p.next = p2;
		return result.next;
	}

	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		ListNode l11=new ListNode(3);
		ListNode l12=new ListNode(5);
		ListNode l13=new ListNode(7);
		ListNode l14=new ListNode(9);
		l1.next=l11;
		l11.next=l12;
		l12.next=l13;
		l13.next=l14;
		
		ListNode l2=new ListNode(0);
		ListNode l21=new ListNode(2);
		ListNode l22=new ListNode(4);
		ListNode l23=new ListNode(6);
		ListNode l24=new ListNode(8);
		l2.next=l21;
		l21.next=l22;
		l22.next=l23;
		l23.next=l24;
		
		System.out.println(new MergeTwoLists().merge2SortList(l1, l2));
		
		
		
	}

}
