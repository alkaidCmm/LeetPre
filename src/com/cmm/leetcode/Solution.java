package com.cmm.leetcode;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2022/6/23 16:09
 * @Author caimingming
 */
public class Solution {

    static class ListNode{
        int val;
        ListNode next;
        public ListNode(){

        }

        public ListNode (int val) {
            this.val = val;
        }

        public ListNode (int val, ListNode next){
            this.val=val;
            this.next=next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left,int right){
        ListNode prev=new ListNode(-1);
        prev.next=head;
        ListNode cur= prev;
        for(int i=0;i<left-1;i++){
            cur=cur.next;
        }

        ListNode rightNode =cur;
        for(int i=0;i<right-(left-1);i++){
            rightNode =rightNode.next;
        }

        ListNode leftPartNode =cur.next;
        ListNode curr=rightNode.next;

        cur.next=null;
        rightNode.next=null;
        reverse(leftPartNode);
        cur.next=rightNode;
        leftPartNode.next=curr;
        return prev.next;
    }

    private ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode root=head;
        if(root !=null){
            ListNode tmp =root.next;
            root.next=pre;
            pre=root;
            root=tmp;
        }

        return pre;
    }
}
