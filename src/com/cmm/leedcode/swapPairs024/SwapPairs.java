package com.cmm.leedcode.swapPairs024;

/**
 * Given a linked list, swap every two adjacent nodes and return its head. 　　For
 * example, 　　Given 1->2->3->4, you should return the list as 2->1->4->3. 　　Your
 * algorithm should use only constant space. You may not modify the values in
 * the list, only nodes itself can be changed.
 * 
 * @author cmm
 * 
 */
public class SwapPairs {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	/**
	 * 1->2->3->4->5->6
	 * 
	 * @param head
	 * @return 2->1->4->3->6->5
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode node = new ListNode(0); // 头结点
		node.next = head;

		// p指向新的链表的尾结点
		ListNode p = node;
		ListNode tmp;
		// 每两个进行操作
		while (p.next != null && p.next.next != null) {
			// 记录下一次要进行处理的位置
			tmp = p.next.next;//指向节点2
			System.out.println("tmp.val="+tmp.val);
			// 下面三句完成两个结点交换
			System.out.println("p.next.next="+p.next.next.val);
			System.out.println("tmp.next.val="+tmp.next.val);
			p.next.next = tmp.next;//2和3交换			
			tmp.next = p.next;//3->1
			p.next = tmp;
			// 指向返回链表的新的尾结点
			p = tmp.next;
		}

		head = node.next;
		node.next = null;

		return head;
	}
	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		ListNode l6=new ListNode(6);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l5.next=l6;
		ListNode LL=new SwapPairs().swapPairs(l1);
		/*while(LL!=null){
			System.out.println(LL.val);
			LL=LL.next;
		}*/
		
	}
}
