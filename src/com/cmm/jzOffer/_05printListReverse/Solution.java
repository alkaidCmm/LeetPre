package com.cmm.jzOffer._05printListReverse;

import java.util.Stack;

/**
 * 题目要求：输入一个链表的头节点，从尾部到头部打印每个节点的值
 * <p>
 * 思路：要求进行从尾部到头部输出，二链表的查找只能是顺序查找 ，栈的结构满足这样的条件：先进后出。同样可以使用递归的方式
 */
public class Solution {
    /**
     * 使用递归的方式进行遍历
     *
     * @param head
     */
    public void printListReverse(ListNode head) {
        if (head != null) {
            if (head.next != null)
                printListReverse(head.next);
            System.out.println(head.value);
        }
    }

    public void printListReverse_v2(ListNode head) {
        if (head != null) {
            if (head.next != null) {
                printListReverse_v2(head.next);
            }
            System.out.println(head.value);
        }
    }

    /**
     * 使用栈来模拟先进后出的过程
     *
     * @param head
     */
    public void printListReverse2(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.getValue());
            p = p.getNext();
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

    }

    public void printListReverse2_v2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        while(!stack.empty()){
			System.out.println(stack.pop().value);
		}
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(0);
        ListNode listOne = new ListNode(1);
        ListNode listTwo = new ListNode(2);
        ListNode listThree = new ListNode(3);
        ListNode listFour = new ListNode(4);
        ListNode listFive = new ListNode(5);
        list.setNext(listOne);
        listOne.setNext(listTwo);
        listTwo.setNext(listThree);
        listThree.setNext(listFour);
        listFour.setNext(listFive);
        new Solution().printListReverse2(list);
    }

}
