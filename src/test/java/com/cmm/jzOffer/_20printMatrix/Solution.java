package com.cmm.jzOffer._20printMatrix;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 *
 * @author cmm
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

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int r1 = 0;
        int r2 = matrix.length - 1;
        int c1 = 0;
        int c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
        	// 左到右
            for (int i = c1; i <= c2; i++) {
                ret.add(matrix[r1][i]);
            }
            // 上到下
            for (int i = r1 + 1; i <= r2; i++) {
                ret.add(matrix[i][c2]);
            }
            // 右到左
            if (r1 != r2) {
                for (int i = c2 - 1; i >= c1; i--) {
                    ret.add(matrix[r2][i]);
                }
            }
            // 下到上
            if (c1 != c2) {
                for (int i = r2 - 1; i > r1; i--) {
                    ret.add(matrix[i][c1]);
                }
            }
            r1++;r2--;c1++;c2--;
        }
        return ret;
    }

    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length==0){
            return new int[0];
        }
        int rows=matrix.length-1;
        int cols=matrix[0].length-1;

        int[] ret=new int[(rows+1)*(cols+1)];
        int index=0;
        int row=0;
        int col=0;
        while(index<ret.length){
            for(int i=col;i<=cols;i++){
                ret[index++]=matrix[row][i];
            }
            for(int i=row+1;i<=rows;i++){
                ret[index++]=matrix[i][cols];
            }
            if(row!=rows) {
                for (int i = cols - 1; i >= col; i--) {
                    ret[index++] = matrix[rows][i];
                }
            }
            // 这里i>row ，而不是i>=row,因为一开始左到右已经遍历了
            if(col !=cols) {
                for (int i = rows - 1; i > row; i--) {
                    ret[index++] = matrix[i][col];
                }
            }
            col++;
            row++;
            cols--;
            rows--;

        }

        return ret;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        Solution s = new Solution();
//		s.printMatrixClockWisely(matrix);
//        s.printMatrix(matrix);
        s.spiralOrder(matrix);
    }
}
