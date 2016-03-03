package com.cmm.jzOffer._22StackPushPopOrder;

import java.util.*;

/**
 * 栈的压入，弹出序列
 * 
 * @author cmm 题目：输入两个整数序列，第一个列表示栈的压入顺序，判断第二个序列是否为栈的弹出序列
 */
public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println("第一组测试数据：");
		int pushOrder[] = { 1, 2, 3, 4, 5 };
		int popOrder[] = { 4, 5, 3, 2, 1 };
		System.out.println(s.isPopOrder(pushOrder, popOrder));
		System.out.println("第二组数据：");
		int pushOrder2[] = { 1, 2, 3, 4, 5 };
		int popOrder2[] = { 4, 3, 5, 2, 1 };
		System.out.println(s.isPopOrder(pushOrder2, popOrder2));
		System.out.println("第三组数据：");
		int pushOrder3[] = { 1, 2, 3, 4, 5 };
		int popOrder3[] = { 4, 5, 3 };
		System.out.println(s.isPopOrder(pushOrder3, popOrder3));
	}

	public boolean isPopOrder(int pushOrder[], int popOrder[]) {
		boolean flag = false;
		// 能够执行的条件是序列不为空，而且长度相等
		if (pushOrder.length > 0 && pushOrder.length == popOrder.length) {
			//
			Stack<Integer> stackHelp = new Stack<Integer>();
			int i = 0;
			int j = 0;
			// 保证入栈序列全进入栈
			while (i < pushOrder.length) {
				// 当栈非空时，若栈顶元素与出栈元素相同，则出栈
				if (stackHelp.size() > 0 && stackHelp.peek() == popOrder[j]) {
					stackHelp.pop();
					j++;
				} else {// 若不同或者栈非空，则在入栈序列中继续添加
					stackHelp.push(pushOrder[i]);
					i++;
				}
				// 此时栈中还有元素需要与出栈序列对比,即比较完之后，入栈序列数组中元素已经全部入栈了一次
			}
			while (stackHelp.size() > 0) {
				if (stackHelp.peek() == popOrder[j]) {
					stackHelp.pop();
					j++;
				} else
					break;
			}
			// 最终栈是空的，而且popOrder中的所有数都遍历了，则是出栈序列
			if (stackHelp.empty() && j == popOrder.length)
				flag = true;
		}
		return flag;

	}

}
