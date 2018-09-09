package com.cmm.leedcode.array;

/**
 * @Author: cmm
 * @Date: 12/02/2018 2:26 PM
 * 描述
 * <p>
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
 * For example, given sorted array A = [1,1,1,2,2,3] , your function should return length =5 and A is now [1,1,2,2,3]
 * <p>
 */
public class RemoveDuplicate2 {
    /**
     * 分析：
     * 加一个变量记录一下元素出现的次数即可。这题因为是已经排序的数组，所以一个变量即可解决。如果是 没有排序的数组，则需要引入一个hashmap来记录出现次数。
     *
     * @param a
     * @return
     */
    public int removeDuplicate(int a[]) {
        if (a.length < 3) {
            return a.length;
        }
        int count = 2;
        for (int i = 2; i < a.length; i++) {
            if (a[i] != a[count - 2]) {
                a[count++] = a[i];
            }
        }
        return count;
    }

    public int removeDuplicate2(int a[]) {
        int n = a.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && i < n - 1 && a[i] == a[i - 1] && a[i] == a[i + 1]) {
                continue;
            }
            a[index++] = a[i];
        }
        return index;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        System.out.println("function 1");
        System.out.println(new RemoveDuplicate2().removeDuplicate(a));
        System.out.println("function 2");
        System.out.println(new RemoveDuplicate2().removeDuplicate2(a));
    }
}
