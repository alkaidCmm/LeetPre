package com.cmm.leetcode.stack.easy._155minStack;

import java.util.Stack;

/**
 * @author caimingming02
 * @date 2021/3/17 1:48 PM
 * @desc
 */
public class MinStack {
    Stack<Integer> curStack;
    Stack<Integer> minStack;
    /**
     * initialize your data structure here.
     */
    public MinStack() {
        curStack=new Stack<>();
        minStack=new Stack<>();
    }

    public void push(int x) {
        if(minStack.isEmpty()){
            minStack.push(x);
        }else if(x<=getMin()){
            minStack.push(x);
        }
        curStack.push(x);
    }

    public void pop() {
        if(curStack.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }
        int value=curStack.pop();
        if(value==getMin()){
            minStack.pop();
        }
    }

    public int top() {
        if(curStack.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }
        return curStack.peek();
    }

    public int getMin() {
        if(minStack.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }
        return minStack.peek();
    }
}
