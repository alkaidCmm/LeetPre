package com.cmm.leedcode.binarysearch.medium._240searchMatrix;

/**
 * @author cmm
 * @date 2020/7/17 11:14 AM
 * @desc
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int rows=matrix.length;
        int clos=matrix[0].length;
        int i=0;
        int j=clos-1;
        while(i<rows&&j>=0){
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]<target){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7},{10, 11, 16, 20},
                {23, 30, 34, 50}};
        new Solution().searchMatrix(matrix,3);

    }
}
