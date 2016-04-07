package com.cmm.leedcode.sort;

public class MergeSort {
	public static int [] mergetSort(int[] arr,int low,int high){
		if(low<high){
			mergetSort(arr, low, high);
		}
		return arr;
	}
}
