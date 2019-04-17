package com.cmm.leedcode.linkedlist.easy._141linkedlistcycle;

import com.cmm.leedcode.linkedlist.ListNode;

/**
 * @Author: cmm
 * @Date: 2018/11/23 3:07 PM
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 */
public class Solution {

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
