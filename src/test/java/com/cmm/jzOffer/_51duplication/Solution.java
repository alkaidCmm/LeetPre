package com.cmm.jzOffer._51duplication;

public class Solution {
    public static int duplication(int[] num) {
        if (num == null || num.length == -1)
            return -1;
        for (int i : num)
            if (i < 0 || i > num.length - 1)
                return -1;
        System.out.println("数组范围没问题");
        for (int i = 0; i < num.length; i++) {
            // 当number[i]与i不相同的时候一直交换
            while (num[i] != i) {
                if (num[i] == num[num[i]])
                    return num[i];
                else
                    swap(num, i, num[i]);
            }
        }
        return -1;
    }

    public static int duplication_v2(int[] num) {
        if (num == null || num.length == 0) {
            return -1;
        }

        for (int i : num) {
            if (i < 0 || i > num.length) {
                return -1;
            }
        }

        for (int i = 0; i < num.length - 1; i++) {
            while (i != num[i]) {
                if (num[i] == num[num[i]]) {
                    return num[i];
                } else {
                    swap(num, i, num[i]);
                }
            }
        }
        return -1;
    }

    private static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {

        int[] numbers0 = {2, 3, 1, 0, 4, 5, 3};
        System.out.println(duplication(numbers0));
        int[] numbers1 = {2, 1, 3, 1, 4};
        System.out.println(duplication(numbers1));
        int[] numbers2 = {2, 4, 3, 1, 4};
        System.out.println(duplication(numbers2));
        int[] numbers3 = {2, 4, 2, 1, 4};
        System.out.println(duplication(numbers3));
        int[] numbers4 = {2, 1, 3, 0, 4};
        System.out.println(duplication(numbers4));
        int[] numbers5 = {2, 1, 3, 5, 4};
        System.out.println(duplication(numbers5));
    }

}
