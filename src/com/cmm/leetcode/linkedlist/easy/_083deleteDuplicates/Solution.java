package com.cmm.leetcode.linkedlist.easy._083deleteDuplicates;


import com.cmm.leetcode.linkedlist.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode root = head;
        while (root.next != null) {
            // 相邻节点数值相等,指向下下节点
            if (root.val == root.next.val) {
                root.next = root.next.next;
            } else {
                // 节点后移
                root = root.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(1);
        ListNode l3=new ListNode(2);
        ListNode l4=new ListNode(2);
        ListNode l5=new ListNode(3);
        head.next=l1;
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        new Solution().deleteDuplicates(head);
    }
}
