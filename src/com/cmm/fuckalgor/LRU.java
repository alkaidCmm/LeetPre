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
        public void addFirst(Node x){

        }
    }

}
