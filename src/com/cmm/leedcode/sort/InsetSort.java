package com.cmm.leedcode.sort;

public class InsetSort {
	public static void insertSort(int[] num){
		int i=0;
		int j=0;
		int current=0;
		for(i=1;i<num.length;i++){
			for(j=i-1,current=num[i];j>=0&&current<num[j];j--){
				num[j+1]=num[j];
			}
			num[j+1]=current;
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
		insertSort(num);
		printArray(num);
	}
}
