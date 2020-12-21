package com.cmm.leetcode.linkedlist.test;

import com.cmm.leetcode.linkedlist.ListNode;

/**
 * @author caimingming02
 * @date 2020/12/17 9:25 AM
 * @desc
 */
public class GetDecimalValue {
    public int getDecimalValue(ListNode head) {
        ListNode root =head;
        // 第一个1开始
        while(root!=null){
            if(root.val==1){
                break;
            }
            root=root.next;
        }
        ListNode validRoot=root;
        ListNode reverseNode = null;
        while(validRoot!=null){
            ListNode next=validRoot.next;
            validRoot.next=reverseNode;
            reverseNode=validRoot;
            validRoot=next;
        }
        int ret=0;
        int cnt=0;
        while(reverseNode!=null){
            ret+=reverseNode.val*(Math.pow(2,cnt));
            reverseNode=reverseNode.next;
            cnt++;
        }
        return ret;


    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(0);
        ListNode n3=new ListNode(1);
        n1.next=n2;
        n2.next=n3;
        new GetDecimalValue().getDecimalValue(n1);

    }
}
