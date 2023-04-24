package com.cmm.zcy.stackqueue.twostack2queue;

import java.util.Stack;

/**
 * @author cmm
 * @date 2020/6/24 1:11 AM
 * @desc 两个队栈实现队列
 */
public class Solution {

    public Stack<Integer> stackPush;

    public Stack<Integer> stackPop;

    public Solution() {
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    /**
     * 1.如果 stackPush 要往 stackPop 中压入数据，那么必须一次性把 stackPush 中的数据全部 压入。
     * 2.如果 stackPop 不为空，stackPush 绝对不能向 stackPop 中压入数据。
     */
    private void push2Pop() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int pushInt) {
        stackPush.push(pushInt);
        push2Pop();
    }

    /**
     * 弹出队列元素
     */
    public int poll() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("queue is Empty");
        }
        push2Pop();
        return stackPop.pop();
    }


    public int peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("queue is Empty");
        }
        push2Pop();
        return stackPop.peek();
    }
}
