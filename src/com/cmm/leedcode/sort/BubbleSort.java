package com.cmm.leedcode.sort;

public class BubbleSort {
	private static void bubuleSort(int[] num) {
		for(int i=0;i<num.length;i++){
			boolean isSorted=true;
			for(int j=0;j<num.length-1-i;j++){
				if(num[j]>num[j+1]){
					int temp=num[j];
					num[j]=num[j+1];
					num[j+1]=temp;
					isSorted=false;
				}
			}
			if(isSorted==true)
				break;
		}
	}
	public static void printArray(int[] array) {
		System.out.print("{");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}
	public static void main(String[] args) {
		int[] num = { 11, 36, 64, 9, 5, 8, 2, 21, 65, 43 };
		printArray(num);
		// quickSort(num, 0, num.length - 1);
		bubuleSort(num);
		printArray(num);
	}
}
