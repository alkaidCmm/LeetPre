package com.cmm.jzOffer._12print1ToNDigits;

/**
 * 打印1到最大的N位数 题目：输入数字n，按顺序打印出从1到最大的n位十进制数，比如输入3，打印出1，2，3...999
 * 
 * @author cmm 这题有难度，下次继续
 */
public class Solution {
	public static void printOneToNthDigits(int n) {
		if (n < 1)
			try {
				throw new Exception("输入的数必须大于1");
			} catch (Exception e) {
				e.printStackTrace();
			}
		int arr[] = new int[n];
		// 对数组元素初始赋值
		for (int i = 0; i < arr.length; i++)
			arr[i] = 0;
		while (addOne(arr) == 0)// 如果最高位没有进位，就一直处理，这里是addOne与printArray交替执行
			printArray(arr);
	}

	public static void printArray(int arr[]) {
		int index = 0;
		// 从第一个非0值开始输出到最后的元素
		while (index < arr.length && arr[index] == 0)
			index++;
		for (int i = index; i < arr.length; i++)
			System.out.print(arr[i]);
		if (index < arr.length)// 条件成立，说明数组中有非零元素，所以需要换行
			System.out.println();
	}

	public static int addOne(int arr[]) {
		int carry = 1;
		int index = arr.length;
		do {
			index--;// 指向上一个处理位置
			arr[index] += carry;// 处理位置上的值加上进位的值
			carry = arr[index] / 10;// 求处理位置的进位
			arr[index] %= 10;// 球处理位置的值
			System.out.println(index + "," + carry);
		} while (carry != 0 && index > 0);
		if (carry > 0 && index == 0) {// 如果index=0说明已经处理了最高位，carry>0说明最高位有进位，返回1
			return 1;
		}
		return 0; // 无进位返回0
	}

	public static void main(String[] args) {
		printOneToNthDigits(4);
	}
}
