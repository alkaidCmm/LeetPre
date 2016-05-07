package com.cmm.jzOffer._07queueWithTwoStack;

import java.util.Stack;

/**
 * 
 * @author cmm
 *
 * @param <T>
 *            泛型
 */
public class CQueue<T> {
	private Stack<T> stack1;
	private Stack<T> stack2;

	public CQueue() {
		this.stack1 = new Stack<T>();
		this.stack2 = new Stack<T>();
	}

	/**
	 * 模拟在队列的末尾添加数据
	 * 
	 * @param node
	 */
	public void appendTail(T node) {
		stack1.push(node);
	}

	/**
	 * 模拟删除队列的头部
	 * stack1压入数据，stack2删除数据，当需要删除数据时，先把stack1的数据全部压入stack2，然后再从stack2的头部删除
	 */
	public T deleteHead() {
		if (!stack2.empty())
			return stack2.pop();
		else {
			if (stack1.size() == 0) {
				try {
					throw new Exception("队列为空");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			while (stack1.size() > 0)
				stack2.push(stack1.pop());
		}
		return stack2.pop();
	}
}
