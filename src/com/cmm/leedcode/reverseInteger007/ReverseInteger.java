package com.cmm.leedcode.reverseInteger007;

public class ReverseInteger {
    public int reverseInteger(int x) {
        int res = 0;
        while (Math.abs(x) != 0) {//读取到最后一位时 ，跳出操作
            res = 10 * res + x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverseInteger(1230));
    }

}