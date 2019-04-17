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
	boolean isScuess;

	public boolean isScuess() {
		return isScuess;
	}

	public void setScuess(boolean scuess) {
		isScuess = scuess;
	}

	public StackWithMin() {
		super();
		stack = new Stack<Integer>();
		stackHelp = new Stack<Integer>();
	}

	public void push(int value) {
		stack.push(value);
		if (stackHelp.size() == 0 || stackHelp.peek() > value)// 如果新插入的值，小于辅助栈的值，则添加
			stackHelp.push(value);
		else
			stackHelp.push(stackHelp.peek());// 否则，添加原来大小相等的元素
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
