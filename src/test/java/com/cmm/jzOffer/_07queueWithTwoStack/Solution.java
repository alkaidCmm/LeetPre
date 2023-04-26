package com.cmm.jzOffer._07queueWithTwoStack;

/**
 * 题目： 两个栈实现队列的功能 思路：栈1实现添加，栈2实现删除
 * 
 * @author cmm
 *
 */
public class Solution {

	public static void main(String[] args) {
		CQueue<Integer> cq = new CQueue<Integer>();
		// 队列插入数据
		for (int i = 0; i < 7; i++)
			cq.appendTail(i);

		for (int i = 0; i < 7; i++)
			System.out.print(cq.deleteHead() + ",");
		System.out.println();
		cq.deleteHead();

	}

}
