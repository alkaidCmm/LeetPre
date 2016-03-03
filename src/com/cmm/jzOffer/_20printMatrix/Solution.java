package com.cmm.jzOffer._20printMatrix;

/**
 * 顺时针打印矩阵
 * 
 * @author cmm
 *
 */
public class Solution {
	public void printMatixInCircle(int[][] matrix, int start) {
		int x = matrix[0].length - 1 - start;// 列数-1
		int y = matrix.length - 1 - start;// 行数-1
		System.out.println("x=" + x + ",y=" + y);

		for (int i = start; i <= x; i++)// 从左到右打印
			System.out.print(matrix[start][i] + ",");
		if (y > start)
			for (int i = start + 1; i <= y; i++)// 从上往下打印
				System.out.print(matrix[i][x] + ",");
		if (x > start && y > start)
			for (int i = x - 1; i >= start; i--)// 从右往左打印
				System.out.print(matrix[y][i] + ",");
		if (y - 1 > start && x > start)
			for (int i = y - 1; i >= start + 1; i--)// 从下往上打印
				System.out.print(matrix[i][start] + ",");
	}

	public void printMatrixClockWisely(int[][] matrix) {
		if (matrix == null || matrix.length <= 0 || matrix[0].length == 0)
			return;
		int start = 0;
		while (matrix.length > (start * 2) && matrix[0].length > (start * 2)) {
			printMatixInCircle(matrix, start);
			start++;
		}
	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
				{ 10, 11, 12 }, { 13, 14, 15 } };
		Solution s = new Solution();
		s.printMatrixClockWisely(matrix);
	}
}
