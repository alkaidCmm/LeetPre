package com.cmm;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Main{


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols= sc.nextInt();

        Main main= new Main(rows, cols);
        int baseStationCnt=  sc.nextInt();
        List<Pair> pairList=new ArrayList();
        for(int i=0;i<baseStationCnt;i++){
            pairList.add(new Pair(sc.nextInt()-1,sc.nextInt()-1));
        }
        main.init(pairList);
        System.out.print(sc.nextLine());
        main.delete(sc.nextInt() -1,  sc.nextInt() -1);
        System.out.print(sc.nextLine());
        main.add(sc.nextInt()-1,sc.nextInt()-1);
        System.out.print(sc.nextLine());
        main.delete(sc.nextInt()-1,sc.nextInt()-1);

        int result=main.getSignSum(main.matrix);
        System.out.println(result);

    }

    boolean[][] matrix;

    int baseStationCnt;

    public Main(int rows, int cols){
        this.matrix=new boolean[rows][cols];
    }

    public void init(List<Pair> pairList){
        for(int i=0;i<pairList.size();i++){
            Pair pair= pairList.get(i);
            matrix[pair.x][pair.y]=true;
        }
    }

    public void add(int x, int y){
        for(int i=x-1;i<=x+1;i++){
            for(int j=y-1;j<=y+1;j++){
                if(i>=0 &&i<matrix.length && j>=0 && j<matrix[0].length){
                    matrix[i][j]=true;
                }
            }
        }
    }

    public void delete(int x, int y){
        for(int i=x-1;i<=x+1;i++){
            for(int j=y-1;j<=y+1;j++){
                if(i>=0 &&i<matrix.length && j>=0 && j<matrix[0].length){
                    matrix[i][j]=false;
                }
            }
        }
    }

    public int getSignSum(boolean[][] matrix){
        Integer result=0;
        for(int x=0;x<matrix.length;x++){
            for(int y=0;y<matrix[0].length;y++){
                if(matrix[x][y]){
                    result += getSubSignSum(matrix, x, y);
                }
            }
        }

        return result;
    }

    public int getSubSignSum(boolean[][] matrix, int x,int y){
        int ret=0;
        for(int i=x-1;i<=x+1;i++){
            for(int j=y-1;j<=y+1;j++){
                if(i>=0 &&i<matrix.length && j>=0 && j<matrix[0].length && !matrix[x][y]){
                    ret+=1;
                }
            }
        }

        return ret;
    }

    public static class Pair{
        int x;
        int y;

        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}