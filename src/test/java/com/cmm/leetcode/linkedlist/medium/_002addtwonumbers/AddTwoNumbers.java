package com.cmm.leetcode.linkedlist.medium._002addtwonumbers;

import com.cmm.leetcode.linkedlist.ListNode;

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
            // 保证下一轮求和大于10，/10取整
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // 保证填充到位置的数字>10,则%10求余数
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        //判断最后一位数字之和>10,则/10取整；
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
        System.out.println(ln);
    }
}
