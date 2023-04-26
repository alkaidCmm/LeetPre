package com.cmm.zcy.stackqueue.minstack;

import java.util.Stack;

/**
 * @author cmm
 * @date 2020/6/24 1:23 AM
 * @desc 两个栈实现一个最小栈
 */
public class Solution {

    public Stack<Integer> stackMin;
    public Stack<Integer> stackData;

    public Solution() {
        this.stackMin = new Stack<>();
        this.stackData = new Stack<>();
    }

    public void push(int data) {
        if (stackMin.isEmpty() || getMin() > data) {
            stackMin.push(data);
        }
        stackData.push(data);
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("min stack empty");
        }

        int k = stackData.pop();
        if (k == getMin()) {
            stackMin.pop();
        }
        return k;
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("min stack empty");
        }
        return stackMin.peek();
    }
}
