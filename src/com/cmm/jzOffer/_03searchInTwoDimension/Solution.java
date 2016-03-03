package com.cmm.jzOffer._03searchInTwoDimension;

/**
 * 一个二维四数组，每行从左到右递增，每列从上到下递增 查找一个数是否则数组中，数组比如 1，2，8，9 2，4，9，12 4，7，10，13
 * 6，8，11，15
 * 
 * @author cmm
 *
 */
public class Solution {
	/**
	 * 这里比较从二维数组的右上角开始比较（同样可以从左下角开始）
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public boolean find(int nums[][], int target) {
		boolean flag = false;
		int rows = nums.length;// 二维数组的行数
		int columns = nums[0].length;// 二维数组的列数
		int row = 0;
		int column = columns - 1;
		while (row < rows && column >= 0) {
			if (nums[row][column] == target) {// 找到直接跳出，不存在两个一样大的数
				flag = true;
				break;
			} else if (nums[row][column] < target) {
				row++;//行变大
			} else
				column--;//列变小
		}
		return flag;
	}

	public static void main(String[] args) {

	}

}
