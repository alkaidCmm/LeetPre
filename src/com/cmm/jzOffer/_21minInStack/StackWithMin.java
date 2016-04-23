package com.cmm.jzOffer._21minInStack;

import java.util.Stack;

/**
 * 包含min函数 的栈，取最小值
 * 
 * @author cmm 题目：
 */
public class StackWithMin {
	private Stack<Integer> stack;
	private Stack<Integer> stackHelp;// 辅助栈，方便存储当前情况下栈中最小的元素

	public StackWithMin() {
		super();
		stack = new Stack<Integer>();
		stackHelp = new Stack<Integer>();
	}

	public void push(int value) {
		stack.push(value);
		if (stackHelp.size() == 0 || stackHelp.peek() > value)
			stackHelp.push(value);
		else
			stackHelp.push(stackHelp.peek());
	}

	public int pop() {
		assert (stack.size() > 0 && stackHelp.size() > 0) : "必须两个站都不为空";
		stackHelp.pop();
		return stack.pop();
	}

	public int min() {
		assert (stack.size() > 0 && stackHelp.size() > 0) : "必须两个栈都不为空";
		System.out.println(stackHelp.size());
		System.out.println(stackHelp);
		return stackHelp.peek();
	}

}
