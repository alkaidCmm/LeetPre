package com.cmm.leedcode.linkedlist.easy._234ispalindrome;

import com.cmm.leedcode.linkedlist.easy.ListNode;

/**
 * @Author: cmm
 * @Date: 2018/11/19 9:13 PM
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * 判断回文
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = p1.next;
        ListNode pre = p1;
        // TODO: 2018/11/19 理解难受，继续呀

        //find mid pointer, and reverse head half part
        while (p2.next != null && p2.next.next != null) {
            p2 = p2.next.next;
            pre = p1;
            p1 = p3;
            p3 = p3.next;
            p1.next = pre;
        }

        //odd number of elements, need left move p1 one step
        if (p2.next == null) {
            p1 = p1.next;
        } else {   //even number of elements, do nothing

        }
        //compare from mid to head/tail
        while (p3 != null) {
            if (p1.val != p3.val) {
                return false;
            }
            p1 = p1.next;
            p3 = p3.next;
        }
        return true;
    }
}
