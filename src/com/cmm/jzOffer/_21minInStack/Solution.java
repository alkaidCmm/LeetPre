package com.cmm.jzOffer._21minInStack;

import java.util.Stack;

/**
 * 包含min函数 的栈，取最小值
 *
 * @author cmm 题目：
 */
public class Solution {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Solution() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getMin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }
        return value;
    }


    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(2);
        solution.push(4);
        solution.push(6);
        solution.push(8);
        solution.push(1);
        solution.push(3);
        solution.push(5);
        solution.push(7);
        System.out.println(solution.getMin());
//		swm.push(-1);
//		System.out.println(swm.min());

    }

}
