package com.cmm.jzOffer._14reOrderArray;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 
 * @author cmm 思路：可以使用双指针的方式，一个指针指向数组的头部i，一个指针指向数组的尾部，如果头部的数为偶数且尾部的数为奇数则交换，
 *         否则头部的指针右移，尾部的指针左移，知道两个指针相遇
 */
public class Solution {
	/**
	 * 这里把判定奇偶性分离出来，提高了代码的重用性，为可扩展提供便利，比如如果需求上，把负数移到非负数的前面，
	 * 或者把能被3整出的移到不能被3整出的前面等等需求
	 * 
	 * @param n
	 * @return
	 */
	public boolean isEven(int n) {// 判断n的奇偶性
		return (n & 1) == 0;
	}

	public int[] reOrderArray(int arr[]) {
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			if (isEven(arr[low]) && !isEven(arr[high])) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				low++;
				high--;
			} else if (!isEven(arr[low]))
				low++;
			else
				high--;
		}
		return arr;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 4, 6, 8, 0, 1, 3, 5, 9 };
		System.out.println(Arrays.toString(new Solution().reOrderArray(arr)));
	}
}
