package com.cmm.leetcode.linkedlist.easy._203removelinkedlistelements;

import com.cmm.leetcode.linkedlist.ListNode;

/**
 * @Author: cmm
 * @Date: 2018/11/23 2:36 PM
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (null == head) {
            return null;
        }
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        // 排除头部数值也是val的情况
        return head.val == val ? head.next : head;
    }

    /**
     * 递归方案,递归过程一开始就处理掉头部重复问题
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }
}
