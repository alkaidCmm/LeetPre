package com.cmm.leedcode.linkedlist.medium._024swapPairs;

import com.cmm.leedcode.linkedlist.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head. 　　For
 * example, 　　Given 1->2->3->4, you should return the list as 2->1->4->3. 　　Your
 * algorithm should use only constant space. You may not modify the values in
 * the list, only nodes itself can be changed.
 *
 * @author cmm
 */
public class Solution {

    /**
     * 1->2->3->4->5->6
     * 每两个奇偶位呼唤
     *
     * @param head
     * @return 2->1->4->3->6->5
     */
    public ListNode swapPairs(ListNode head) {
        // TODO: 2018-11-26 没看明白，下次继续
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode LL = new Solution().swapPairs(l1);

    }
}
