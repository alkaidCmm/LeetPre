package com.cmm.leetcode.linkedlist.easy._876middleoflinkedlist;

import com.cmm.leetcode.linkedlist.ListNode;

/**
 * @Author: cmm
 * @Date: 2018/11/19 4:18 PM
 */
public class Solution {
    /**
     * 快慢指针同时从链表的表头开始向后移动，慢指针每次移动一个node，快指针每次移动两个node
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
