package com.cmm.leedcode._876MiddleNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cmm
 * @Date: 2018/8/28 7:49 PM
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode a = head;
        ListNode b = head;
        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
        }
        return a;
    }

    public static void main(String[] args) {
//        MyLinkedList s = new MyLinkedList();
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        ListNode n6 = new ListNode(6);
//
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        ListNode result = s.middleNode(n1);
//        System.out.println(result);
        List a=new ArrayList();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);


        List b=new ArrayList();
        b.add(1);
        b.add(4);
        b.add(7);
        boolean result=a.containsAll(b);
        System.out.println(b);

    }
}
