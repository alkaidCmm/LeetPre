package com.cmm.jzOffer._20printMatrix;

public class Solution2 {
	public void printMatrix(int[][] a, int width, int height) {
		// 起始打印坐标a[times][times],(0,0) (1,1) (2,2)...等
		int times = 0;
		while (times <= width - 1 - times && times <= height - 1 - times) {
			// 最右边的列号
			int colNum = width - 1 - times;
			// 最下边的行号
			int rowNum = height - 1 - times;
			// 第一步 打印上边的行(一定会打印)
			for (int col = times; col <= colNum; col++) {
				System.out.print(a[times][col] + " ");
			}
			// 第二步打印右边的列(两行以上才会打印)
			if (rowNum - times > 0) {
				for (int row = times + 1; row <= rowNum; row++) {
					System.out.print(a[row][colNum] + " ");
				}
			}
			// 第三步打印下边的行（两列且两行以上才会打印）
			if (colNum - times + 1 >= 2 && rowNum - times + 1 >= 2) {
				for (int col = colNum - 1; col >= times; col--) {
					System.out.print(a[rowNum][col] + " ");
				}
			}
			// 第四步打印左边的行(三行且两列以上)
			if (colNum - times + 1 >= 3 && rowNum - times + 1 >= 2) {
				for (int row = rowNum - 1; row >= times + 1; row--) {
					System.out.print(a[row][times] + " ");
				}
			}
			System.out.println();
			times++;
		}
	}

	public static void main(String[] args) {
		Solution2 cpm = new Solution2();
		int[][] a = { { -1, -2, 3, -4 }, { -1, -2, 3, -4 }, { -1, -2, 3, -4 } };
		cpm.printMatrix(a, a[0].length, a.length);
	}
}
