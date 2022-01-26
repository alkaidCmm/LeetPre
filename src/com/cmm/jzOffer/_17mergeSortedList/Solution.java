package com.cmm.jzOffer._17mergeSortedList;

public class Solution {
    public ListNode mergeSortedList(ListNode list1, ListNode list2) {
        ListNode head = null;
        if (list1 == null)
            head = list2;
        if (list2 == null)
            head = list1;
        if (list1 != null && list2 != null) {
            ListNode node1 = list1;
            ListNode node2 = list2;
            if (node1.getValue() < node2.getValue()) {
                head = node1;
                head.setNext(mergeSortedList(node1.getNext(), node2));
            } else {
                head = node2;
                head.setNext(mergeSortedList(node1, node2.getNext()));
            }
        }
        return head;
    }


    public ListNode mergeSortedList_v2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode l1 = list1;
        ListNode l2 = list2;

        ListNode ret = null;

        if (l1.getValue() <= l2.getValue()) {
            ret = l1;
            ret.setNext(mergeSortedList_v2(l1.getNext(), l2));
        } else {
            ret = l2;
            ret.setNext(mergeSortedList_v2(l1, l2.getNext()));
        }

        return ret;
    }

    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list1_2 = new ListNode(8);
        ListNode list1_3 = new ListNode(11);
        ListNode list1_4 = new ListNode(24);
        list1.setNext(list1_2);
        list1_2.setNext(list1_3);
        list1_3.setNext(list1_4);

        ListNode list2 = new ListNode(3);
        ListNode list2_2 = new ListNode(6);
        ListNode list2_3 = new ListNode(15);
        ListNode list2_4 = new ListNode(20);
        list2.setNext(list2_2);
        list2_2.setNext(list2_3);
        list2_3.setNext(list2_4);

        Solution s = new Solution();
        System.out.println("第一个链表");
        s.printList(list1);

        System.out.println("第二个链表");
        s.printList(list2);

        System.out.println("合并连个链表之后");
        ListNode head = s.mergeSortedList(list1, list2);
        s.printList(head);
    }
}
