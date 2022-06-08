package com.cmm.leetcode.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 原理：1. 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 * 2. 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 3. 重复第二步，直到所有元素均排序完毕。
 *
 * @author caimingming
 */
public class SelectSort {

    public int[] selectSort(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);

        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; i++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }

        return arr;
    }
}
