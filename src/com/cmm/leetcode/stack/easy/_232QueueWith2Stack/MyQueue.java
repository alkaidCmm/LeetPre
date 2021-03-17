package com.cmm.leetcode.stack.easy._232QueueWith2Stack;

import java.util.Stack;

/**
 * @author caimingming02
 * @date 2021/3/15 9:48 AM
 * @desc
 */
public class MyQueue {
    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        pushStack = new Stack();
        popStack = new Stack();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        pushStack.push(x);
        if (popStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (pushStack.isEmpty() && popStack.empty()) {
            throw new RuntimeException("队列为空");
        }
        if (popStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (pushStack.isEmpty() && popStack.empty()) {
            throw new RuntimeException("队列为空");
        }
        if (popStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.empty();
    }
}
