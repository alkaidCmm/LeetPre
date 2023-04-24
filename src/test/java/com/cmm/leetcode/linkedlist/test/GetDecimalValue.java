package com.cmm.leetcode.linkedlist.test;

import com.cmm.leetcode.linkedlist.ListNode;

/**
 * @author caimingming02
 * @date 2020/12/17 9:25 AM
 * @desc
 */
public class GetDecimalValue {
    public int getDecimalValue(ListNode head) {
        ListNode root = head;
        // 第一个1开始
        while (root != null) {
            if (root.val == 1) {
                break;
            }
            root = root.next;
        }
        ListNode validRoot = root;
        ListNode reverseNode = null;
        while (validRoot != null) {
            ListNode next = validRoot.next;
            validRoot.next = reverseNode;
            reverseNode = validRoot;
            validRoot = next;
        }
        int ret = 0;
        int cnt = 0;
        while (reverseNode != null) {
            ret += reverseNode.val * (Math.pow(2, cnt));
            reverseNode = reverseNode.next;
            cnt++;
        }
        return ret;


    }

    public static void main(String[] args) {
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(0);
//        ListNode n3 = new ListNode(1);
//        n1.next = n2;
//        n2.next = n3;
//        new GetDecimalValue().getDecimalValue(n1);

//        wordPattern("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd", "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t");

    }

    public static String addBinary(String a, String b) {
        String ret = "";

        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;

        // 进位标志，0不进位，1进位
        int carry = 0;
        while (aIndex >= 0 || bIndex >= 0) {
            // char 转 int
            int aCur = aIndex >= 0 ? a.charAt(aIndex) - '0' : 0;
            int bCur = bIndex >= 0 ? b.charAt(bIndex) - '0' : 0;
            // 对应位置 相加
            int sum = aCur + bCur + carry;
            // 求位置数字
            ret = sum % 2 + ret;
            // 求进位
            carry = sum / 2;
        }

        // 位置时，最高位append '1'
        if (carry == 1) {
            ret = 1 + ret;
        }

        return ret;
    }
}
