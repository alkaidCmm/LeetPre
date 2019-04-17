package com.cmm.leedcode.linkedlist.medium._002addtwonumbers;

import com.cmm.leedcode.linkedlist.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode cur = ret;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            //这里即为结果值
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        //将结果保存在单向链表中
        if (sum / 10 == 1) {
            cur.next = new ListNode(1);
        }
        return ret.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();

        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(5);

        l1.next = l12;
        l12.next = l13;
        l13.next = l14;

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        ListNode l24 = new ListNode(5);

        l2.next = l22;
        l22.next = l23;
        l23.next = l24;
        ListNode ln = atn.addTwoNumbers(l1, l2);
    }
}
