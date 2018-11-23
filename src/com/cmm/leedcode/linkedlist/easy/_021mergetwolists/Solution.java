package com.cmm.leedcode.linkedlist.easy._021mergetwolists;

import com.cmm.leedcode.linkedlist.easy.ListNode;

public class Solution {

    /**
     * 递归方案
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(3);
        ListNode l12 = new ListNode(5);
        ListNode l13 = new ListNode(7);
        ListNode l14 = new ListNode(9);
        l1.next = l11;
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;

        ListNode l2 = new ListNode(0);
        ListNode l21 = new ListNode(2);
        ListNode l22 = new ListNode(4);
        ListNode l23 = new ListNode(6);
        ListNode l24 = new ListNode(8);
        l2.next = l21;
        l21.next = l22;
        l22.next = l23;
        l23.next = l24;

        System.out.println(new Solution().mergeTwoLists(l1, l2));


    }

}
