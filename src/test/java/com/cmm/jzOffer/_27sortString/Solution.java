package com.cmm.jzOffer._27sortString;

/**
 * 题目：例如输入字符串abc，则打印由字符a,b,c所能排列出来的所有字符串：abc，abc,bac,bca,cab,cba
 * 
 * @author cmm
 *
 */

public class Solution {
	public void swap(char[] arr, int idx1, int idx2) {
		char temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	/**
	 * 注：
	 * （a)把字符串分为两部分，一部分是字符串的第一个字符，另一部分是第一个字符以后的所有字符。接下来我们求阴影部分的字符串的排列。
	 * （b）拿第一个字符和它后面的字符逐个交换。
	 * 
	 * @param arr
	 * @param index
	 * @param size
	 */
	public void permutation(char[] arr, int index, int size) {
		if (index == size) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		} else {
			for (int i = index; i < size; i++) {
				if (i != index && arr[i] == arr[index])//
					continue;
				swap(arr, i, index);
				permutation(arr, index + 1, size);
				swap(arr, i, index);
			}
		}
	}

	public static void main(String[] args) {
		String str = "abcdef";
		char[] chs = str.toCharArray();
		new Solution().permutation(chs, 0, chs.length);
	}
}