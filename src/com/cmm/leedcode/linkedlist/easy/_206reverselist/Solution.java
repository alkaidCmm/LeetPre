package com.cmm.leedcode.linkedlist.easy._206reverselist;

import com.cmm.leedcode.linkedlist.easy.ListNode;

/**
 * @Author: cmm
 * @Date: 2018/11/19 7:52 PM
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        //
        while (head != null) {
            // 定位下一个节点
            ListNode next = head.next;
            // 头指针指向新头部
            head.next = newHead;
            // 尾插法
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        Solution s = new Solution();
        ListNode result = s.reverseList(l1);
    }
}
