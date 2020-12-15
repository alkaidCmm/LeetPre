package com.cmm.leetcode._027removeElements;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * @author cmm
 *
 */
public class RemoveElements {
	public int removeElements(int a[], int val) {
		int ret = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != val)
				a[ret++] = a[i];
		}
		return ret;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5 };
		System.out.println(new RemoveElements().removeElements(a, 3));
	}

}
