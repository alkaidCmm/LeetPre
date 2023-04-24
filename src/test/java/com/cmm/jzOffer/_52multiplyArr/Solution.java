package com.cmm.jzOffer._52multiplyArr;

import java.util.Arrays;

public class Solution {
	public static int[] multiArr(int[] a) {
		if(a==null || a.length==0){
			return new int[0];
		}
		int[] ret = new int[a.length];
		ret[0] = 1;
		for(int i=1;i<a.length;i++){
			ret[i]=ret[i-1]*a[i-1];
		}

		int tmp=1;
		for(int i=a.length-2;i>=0; i--){
			tmp *=a[i+1];
			ret[i] *= tmp;
		}

		return ret;
	}

	public static void main(String[] args) {
		int[] array1 = { 2, 3, 4, 5 };
		System.out.println(Arrays.toString(multiArr(array1))); // double
																// expected[]
																// ={120, 60,
																// 40,30, 24};
	}
}
