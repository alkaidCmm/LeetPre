package com.cmm.leetcode.sort;

import java.util.Arrays;

/**
 * 希尔排序:也称递减增量排序算法，是插入排序的一种更高效的改进版本。但希尔排序是非稳定排序算法。
 * 希尔排序是基于插入排序的以下两点性质而提出改进方法的：
 * 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率；
 * 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位；
 * 希尔排序的基本思想是：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
 */
public class ShellSort {
    public static void shellSort(int[] num) {
        int i = 0;
        int j = 0;
        int current = 0;
        for (int d = num.length / 2; d > 0; d /= 2) {//分区
            for (i = d; i < num.length; i++) {
                current = num[i];
                for (j = i; j >= d; j -= d) {
                    if (current < num[j - d]) {
                        num[j] = num[j - d];
                    } else//可以直接跳出循环，一开始就已经做了比较了，不需要后续比较
                        break;
                }
                num[j] = current;
            }
        }
    }

	public int[] sort(int[] sourceArray) throws Exception {
		// 对 arr 进行拷贝，不改变参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

		int gap = 1;
		while (gap < arr.length/3) {
			gap = gap * 3 + 1;
		}

		while (gap > 0) {
			for (int i = gap; i < arr.length; i++) {
				int tmp = arr[i];
				int j = i - gap;
				while (j >= 0 && arr[j] > tmp) {
					arr[j + gap] = arr[j];
					j -= gap;
				}
				arr[j + gap] = tmp;
			}
			gap = (int) Math.floor(gap / 3);
		}

		return arr;
	}


}
