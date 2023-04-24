package com.cmm.leetcode.sort;

/**
 * 冒泡排序
 * 原理：比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * <p>
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * <p>
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * <p>
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class BubbleSort {
    private static void bubuleSort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < num.length - 1 - i; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted == true)
                break;
        }
    }

    public static int[] bubbleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }

        return nums;
    }

    public static void printArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        int[] num = {11, 36, 64, 9, 5, 8, 2, 21, 65, 43};
        printArray(num);
        // quickSort(num, 0, num.length - 1);
        bubuleSort(num);
        printArray(num);
    }
}
