package com.cmm.jzOffer._13movingCount;

class Solution {
    public int movingCount(int m, int n, int k) {
        if(k < 0 || m < 1 || n < 1){
            return 0;
        }

        boolean [][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                visited[i][j] = false;
            }
        }

        return movingCount(m, n, 0, 0, k, visited);
    }

    /**
     * 递归回溯方法
     *
     * @param threshold 约束值
     * @param rows      方格的行数
     * @param cols      方格的列数
     * @param row       当前处理的行号
     * @param col       当前处理的列号
     * @param visited   访问标记数组
     * @return 最多可走的方格
     */
    private int movingCount(int rows, int cols,int row, int col, int k,boolean[][] visited ){
        int count=0;
        if(check(rows, cols, row, col, k, visited)){
            visited[row][col] = true;
            count = 1
                    + movingCount(rows, cols, row + 1, col, k, visited)
                    + movingCount(rows, cols, row - 1, col, k, visited)
                    + movingCount(rows, cols, row, col + 1, k, visited)
                    + movingCount(rows, cols, row, col - 1, k, visited);
        }
        return count ;
    }

    /**
     * 判断机器人能否进入坐标为(row, col)的方格
     *
     * @param threshold 约束值
     * @param rows      方格的行数
     * @param cols      方格的列数
     * @param row       当前处理的行号
     * @param col       当前处理的列号
     * @param visited   访问标记数组
     * @return 是否可以进入，true是，false否
     */
    private boolean check(int rows, int cols,int row, int col, int k,boolean[][] visited){
        return col >= 0 && col < cols
                && row >= 0 && row < rows
                && !visited[row][col]
                && getBitSum(row)+ getBitSum(col) <=k;
    }

    /**
     * 位数和
     */
    private int getBitSum(int i){
        int ret=0;
        while(i>0){
            ret += (i%10);
            i/=10;
        }

        return ret;
    }

    public static void main(String[] args) {
        new Solution().movingCount(1, 2,1);
    }
}
