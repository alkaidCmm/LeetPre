package com.cmm.leetcode.array.medium.threeSum015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一个数组，查找存在三个数相加等于0
 * 
 * @author cmm
 * 
 */
public class ThreeSum {
	public List<List<Integer>> threeSumToZero(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int target = 0;// 和等于0
		if (num.length < 3)
			return result;
		Arrays.sort(num);// 排序
		for (int i = 0; i <= num.length - 3; i++) {
			// int firstNum=num[i];
			int second = i + 1;
			int third = num.length - 1;
			while (second < third) {
				if (num[i] + num[second] + num[third] < target)
					second++;// 第二个数右移
				else if (num[i] + num[second] + num[third] > target)
					third--;// 第三个数左移
				else {
					result.add(Arrays.asList(num[i], num[second], num[third]));// 相等则添加至List中
					/*System.out.println("num[i]=" + num[i] + ", num[second]="
							+ num[second] + ", num[third]=" + num[third]);*/
					second++;
					third--;

					while (second < third && num[second] == num[second - 1])
						second++;// 去重
					while (second < third && num[third] == num[third + 1])
						third--;
				}
			}
			while (i <= num.length - 3 && num[i] == num[i + 1])
				i++;
		}
		return result;
	}

	public static void main(String[] args) {
		int num[] = { 2, 4, 6, 8, 0, -1, -3, -5, -7, -9 };
		System.out.println(new ThreeSum().threeSumToZero(num));
	}
}
