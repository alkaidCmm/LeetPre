package com.cmm.jzOffer._30kMinInArr;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 找出数组中最小的K个数
 * 
 * @author cmm
 *
 */
public class Solution {

	public static void main(String[] args) {
		int[] num = { 4, 5, 1, 6, 2, 7, 3, 8 };
		final int k = 4;
		TreeSet<Integer> result = getLeastNumbers(num, k);
		Iterator<Integer> it = result.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static TreeSet<Integer> getLeastNumbers(int[] num, int k) {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		if (num == null || num.length == 0 || k < 0)
			return null;
		for (int i = 0; i < num.length; i++) {
			if (ts.size() < k) {// 如果ts元素个数小于K,直接插入
				ts.add(num[i]);
			} else {
				if (ts.last() > num[i]) {// 跟最大值比较
					ts.pollLast();// 剔除最大值
					ts.add(num[i]);
				}
			}
		}
		return ts;
	}
}
