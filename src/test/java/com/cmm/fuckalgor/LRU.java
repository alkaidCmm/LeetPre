package com.cmm.fuckalgor;

/**
 * @author cmm
 * @date 2020/6/12 8:46 AM
 * @desc
 */
public class LRU {

    static class Node{
        int key;
        int value;
        public Node pre;
        public Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class DoubleList{
        // 在链表头部添加节点 x，时间 O(1)
        public void addFirst(Node x){

        }

        // 删除链表中的 x 节点（x 一定存在）
        // 由于是双链表且给的是目标 Node 节点，时间 O(1)
//        public void remove(Node x);
//
//        // 删除链表中最后一个节点，并返回该节点，时间 O(1)
//        public Node removeLast();
//
//        // 返回链表长度，时间 O(1)
//        public int size();
    }

}
