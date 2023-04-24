package com.cmm.jzOffer._45lastRemaining;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	/**
	 * 
	 * @param round
	 *            圈子大小
	 * @param circle
	 *            删除节点周期
	 * @return
	 */
	public static int lastRemain(int round, int circle) {
		if (round < 1 || circle < 1)
			return -1;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < round; i++)
			list.add(i);// 将0到round加入list链表
		System.out.println(list);
		int idx = 0;// 要删除元素的位置
		while (list.size() > 1) {
			for (int i = 1; i < circle; i++)// 从一开始每次只走circle-1（周期）的步数
				idx = (idx + 1) % list.size();// 删除第circle个
			list.remove(idx);
		}
		return list.get(0);

	}

	public static int lastRemain2(int round, int circle) {
		if (round < 1 || circle < 1)
			return -1;
		int last = 0;
		for (int i = 2; i <= round; i++)
			last = (last + circle) % i;
		return last;
	}

	public static void main(String[] args) {
		test01();
		System.out.println();
		test02();
	}

	private static void test01() {
		System.out.println(lastRemain(5, 3)); // 最后余下3
		System.out.println(lastRemain(5, 2)); // 最后余下2
		System.out.println(lastRemain(6, 7)); // 最后余下4
		System.out.println(lastRemain(6, 6)); // 最后余下3
		System.out.println(lastRemain(0, 0)); // 最后余下-1
	}

	private static void test02() {
		System.out.println(lastRemain2(5, 3)); // 最后余下3
		System.out.println(lastRemain2(5, 2)); // 最后余下2
		System.out.println(lastRemain2(6, 7)); // 最后余下4
		System.out.println(lastRemain2(6, 6)); // 最后余下3
		System.out.println(lastRemain2(0, 0)); // 最后余下-1
	}
}