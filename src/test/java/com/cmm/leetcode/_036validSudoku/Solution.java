package com.cmm.leetcode._036validSudoku;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * 
 * http://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-
 * 20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png
 * 
 * A partially filled sudoku which is valid.
 * 
 * Note: A valid Sudoku board (partially filled) is not necessarily solvable.
 * Only the filled cells need to be validated.
 * 
 * @author cmm
 *
 */
public class Solution {
	public boolean isValidSudoku(char[][] board) {
		int[] count = new int[10];
		int i;
		int j;
		for (i = 0; i < 9; i++) {// 判断每一行是否正确
			for (j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					count[board[i][j] - '0']++;// 对每一列数出现次数进行计数
				}
			}
			for (j = 0; j < 10; j++) {
				if (count[j] > 1) // 次数大于一，表示重复出现
					return false;
				count[j] = 0;// 置零
			}
		}
		for (i = 0; i < 9; i++) {// 判断每一列是否正确
			for (j = 0; j < 9; j++) {
				if (board[j][i] != '.') {
					count[board[j][i] - '0']++;//
				}
			}
			for (j = 0; j < 10; j++) {
				if (count[j] > 1)
					return false;

				count[j] = 0;
			}
		}
		for (i = 0; i < 3; i++) {// 判断每个3*3方格是否正确
			for (j = 0; j < 3; j++) {
				for (int m = 0; m < 9; m++) {
					char temp = board[3 * i + m / 3][3 * j + m % 3];// 3*3宫格坐标表示
					if (temp != '.')
						count[temp - '0']++;// 对坐标里边数字进行计数
				}
				for (int m = 0; m < 10; m++) {
					if (count[m] > 1)
						return false;
					count[m] = 0;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {

	}

}
