package com.cmm.leedcode.linkedlist.medium._019remodeKthListNode;

import com.cmm.leedcode.linkedlist.ListNode;

public class RemoveKthListNode {

    public ListNode removeNth(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        ListNode myHead = head;
        ListNode myTail = head;
        for (int i = 0; i < n && myTail != null; i++) {
            myTail = myTail.next;
        }
        // 即要删除的元素下标大于链表长度
        if (null == myTail) {
            return head.next;
        }
        // 删除序号小于链表长度大前提下，然后指针指向最后一个节点为止
        while (myTail.next != null) {
            myHead = myHead.next;
            myTail = myTail.next;
        }
        // 删除第N个节点
        myHead.next = myHead.next.next;
        return head;
    }

    /**
     * 这里测试数据不怎么正确!!!!
     *
     * @param args
     */
    public static void main(String[] args) {
        RemoveKthListNode rkln = new RemoveKthListNode();
        // rkln.
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        ListNode l9 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
		/*l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		l8.next = l9;*/
        rkln.removeNth(l1, 4);
        //System.out.println("l5.next.val=" + l5.next.val);
    }
}
