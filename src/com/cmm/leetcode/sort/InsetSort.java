package com.cmm.leetcode.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 原理：将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 * 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
 * （如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 */
public class InsetSort {
    public static void insertSort(int[] num) {
        int i = 0;
        int j = 0;
        int cur = 0;
        for (i = 1; i < num.length; i++) {
            for (j = i - 1, cur = num[i]; j >= 0 && cur < num[j]; j--) {
                num[j + 1] = num[j];
            }
            num[j + 1] = cur;
        }
    }

    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {

            // 记录要插入的数据
            int tmp = arr[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }

        }
        return arr;
    }

    public int[] sort_2(int[] nums){
        for(int i=1;i<nums.length;i++){

            int tmp = nums[i];
            int j=i;
            // tmp 一定是跟j-1 进行比较
            while(j>0 && tmp < nums[j-1]){
                nums[j]=nums[j-1];
                j--;
            }

            if(j != i){
                nums[j] = tmp;
            }
        }
        return nums;
    }

    public static void main(String[] args) throws Exception {
//        new InsetSort().sort(new int[]{4,3,8,2,1,9,5});
        new InsetSort().sort_2(new int[]{4,3,8,2,1,9,5});

    }
}
