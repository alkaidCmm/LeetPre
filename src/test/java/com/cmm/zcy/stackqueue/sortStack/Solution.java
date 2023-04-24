package com.cmm.zcy.stackqueue.sortStack;

import java.util.Stack;

/**
 * @author cmm
 * @date 2020/6/24 1:52 AM
 * @desc 一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一 个栈。除此之外，可以申请新的变量，但不能申请额外的数据结构。如何完成排序?
 */
public class Solution {

    /**
     * @param stack
     */
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()) {
            // 这里的核心是 可以拿出stack的栈顶元素与help的站定比较，并交换位置
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Stack stack = new Stack();
        stack.push(2);
        stack.push(1);
        stack.push(4);
        stack.push(3);
        stack.push(6);
        stack.push(5);
        sortStackByStack(stack);

    }

}
