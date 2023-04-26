package com.cmm.test;

/**
 * @description:
 * @author: cmm
 * @date: 2023/4/23
 **/
public record MyRecord(String username,Integer age,String ab,int c){

    public static void main(String[] args) {
        MyRecord m1=new MyRecord("cmm",1,"ab",1);
        MyRecord m2=new MyRecord("zyy",2,"cd",2);

        System.out.println(m1.equals(m2));

    }
}
