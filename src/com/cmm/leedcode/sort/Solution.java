package com.cmm.leedcode.sort;

import java.util.Arrays;

public class Solution {

	public static void print(int[] num) {
		for (int i = 0; i < num.length; i++)
			System.out.println(num[i]);
	}

	public static void main(String[] args) {
		int[] num = { 5, 4, 7, 9, 1, 8, 6, 10 };
		bubbleSort(num);
		print(num);
	}

	/**
	 * 直接插入排序：每一轮第i个元素跟前面的i-1个元素从后向前比较，一直比较到合适插入的位置 属于插入类排序
	 * 稳定的排序算法（每次插入元素时总是从后向前先比较再移动） 平均时间复杂度O(n*n) 最坏时间复杂度O(n*n) 空间复杂度O(1)
	 * 大部分有序时适用，适应于顺序存储和链式存储的线性表
	 * 
	 */
	public static void insertSort(int[] array, int off, int len) {
		System.out.println("InsertSort()");
		int i, j, current;// current记录当前插入元素
		for (i = off + 1; i < off + len; i++) {// array[i]待插入元素，j为比较元素的下标
			for (j = i - 1, current = array[i]; j >= off
					&& array[j] > current; j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = current;
		}
	}

	/**
	 * 希尔排序：分组交换的思想，先分组，后交换排序 属于交换类排序 不稳定的排序算法 ：分组之后交换打破了稳定性 平均时间复杂度O(n*log2n)
	 * 最坏时间复杂度O(n^s) 1<s<2 空间复杂度O(1) n较大时适用
	 */
	public static void shellSort(int[] array, int off, int len) {
		int d = len / 2;// 组内元素的间隔
		while (d >= 1) {// 直到退化到bubble为止
			shellSortDivision(d, array, off, len);
			d /= 2;
		}
	}

	private static void shellSortDivision(int d, int[] array, int off,
			int len) {
		for (int i = 0; i < d; i++) {// 第i个分组
			for (int j = 1; j <= (len - 1 - i) / d; j++) {// 分组内bubble
				boolean isSorted = true;
				for (int k = off + i; k + d <= off + len - (j - 1) * d
						- 1; k += d) {
					if (array[k] > array[k + d]) {
						swap(array, k, k + d);
						isSorted = false;
					}
				}
				if (isSorted == true)
					break;
			}
		}
	}

	/**
	 * 冒泡排序：一趟一趟的比较，比较相邻元素的大小，每趟有一个元素沉入最后面的位置, 属于交换类排序, 稳定的排序算法, 平均时间复杂度O(n*n)
	 * 最坏时间复杂度O(n*n) 空间复杂度O(1) n较小时适用
	 */
	public static void bubbleSort(int[] num) {
		System.out.println("BubbleSort()");
		for (int i = 0; i < num.length - 1; i++) {
			boolean isSort = true;
			for (int j = 0; j < num.length - 1 - i; j++)
				if (num[j] > num[j + 1]) {
					num[j] ^= num[j + 1];
					num[j + 1] ^= num[j];
					num[j] ^= num[j + 1];
					isSort = false;
				}
			if (isSort)
				break;
		}
	}

	/**
	 * 快速排序：递归算法，将较大的一组换到后面去，较小的一组在前面，前面和后面的分别再递归调用 属于交换类排序 不稳定的排序算法
	 * ：如35512第一轮时前面的5和后面的2换位置，后面的5和1换位置，位置顺序被破坏 平均时间复杂度O(n*log2n) 最坏时间复杂度O(n*n)
	 * 空间复杂度O(1) n较大 时适用
	 */
	public static void quickSort(int[] array, int off, int len) {
		if (len <= 1)
			return;
		if (len == 2)// 长度大于三才进行划分
			if (array[off] > array[off + 1]) {
				swap(array, off, off + 1);
				return;
			}
		int start = off + 1, end = off + len - 1;// 交换的开始和结束位置
		int middleV = array[off];// 可以将off和 off+len-1和off+(len-1)/2三个元素中间的赋值
		while (start < end) {
			while (array[start] < middleV && start < end)
				start++;
			while (array[end] > middleV && end > start)
				end--;
			if (start < end) {
				swap(array, start, end);
				start++;
				end--;
			}
		}
		int mid = off;
		if (array[off] > array[end]) {
			swap(array, end, off);
			mid = end;
		}
		quickSort(array, off, mid - off);
		quickSort(array, mid + 1, len - mid + off - 1);

	}

	public static int getMiddle(int[] list, int low, int high) {
		int tmp = list[low];// 数组的第一个作为中轴 
		while (low < high) {
			while (low < high && list[high] > tmp) {
				high--;
			}
			list[low] = list[high];// 比中轴小的记录移到低端 
			while (low < high && list[low] <= tmp) {
				low++;
			}
			list[high] = list[low];// 比中轴大的记录移到高端
		}
		list[low] = tmp;// 中轴记录到尾 
		return low;// 返回中轴的位置 
	}

	public static void quickSort2(int[] array, int low, int high) {
		if (low < high) {
			int middle = getMiddle(array, low, high);// 将list数组进行一分为二
			quickSort2(array, low, middle - 1);// 对低字表进行递归排序
			quickSort2(array, middle + 1, high);// 对高字表进行递归排序
		}
	}

	/**
	 * 归并算法：分而治之的思想 属于归并类排序 稳定的排序算法 平均时间复杂度O(n*log2n) 最坏时间复杂度O(n*log2n)
	 * 空间复杂度O(n) n较大时适用
	 */
	public static void MergeSort(int[] array, int off, int len) {
		if (len < 2)
			return;
		else if (len == 2) {
			if (array[off] > array[off + 1])
				swap(array, off, off + 1);
			return;
		} else {
			int middle = off + (len - 1) / 2;
			MergeSort(array, off, middle - off + 1);
			MergeSort(array, middle + 1, len - middle + off - 1);
			Merge(array, off, middle, off + len - 1);
		}
	}

	public static void Merge(int[] array, int left, int middle, int right) {
		int l = left, r = middle + 1, count = 0;
		int[] newArray = new int[right - left + 1];
		while (l <= middle && r <= right) {
			if (array[l] < array[r])
				newArray[count++] = array[l++];
			else
				newArray[count++] = array[r++];
		}
		while (l <= middle)
			newArray[count++] = array[l++];
		while (r <= right)
			newArray[count++] = array[r++];
		for (int i = left, j = 0; i <= right; i++) { // 把新数组中的数覆盖nums数组
			array[i] = newArray[j++];
		}

	}

	/**
	 * 直接选择排序：第i轮选择剩余最小的元素放入到第i的位置上 属于选择类排序 不稳定的排序算法
	 * ：如58529第一轮选择交换5和2，破换了原来两个5的顺序 平均时间复杂度O(n*n) 最坏时间复杂度O(n*n) 空间复杂度O(1)
	 * 当n较小时适用
	 */
	public static void selectSort(int[] array, int off, int len) {
		for (int i = off; i < off + len - 1; i++) {
			int minIndex = i, min = array[i];// 最小元素及下标
			for (int j = i; j < off + len; j++) {// j为所有待选择元素
				if (array[j] < min) {// array[j]更小
					min = array[j];
					minIndex = j;
				}
			}
			swap(array, minIndex, i);// 选择最小元素放入array[i]
		}
	}

	/**
	 * 堆算法：大根堆a[i] > a[2*i],a[i] > a[2*i+1]，先建大根堆，然后不断的：取最大的，调整 属于选择类排序
	 * 不稳定的排序算法：在调整位置时打破了稳定性 平均时间复杂度O(n*log2n) 最坏时间复杂度O(n*log2n) 空间复杂度O(1)
	 * n较大时适用，选择前i大时适用
	 */
	public static void heapSort(int[] array, int off, int len) {
		buildHeap(array, off, len);
		for (int i = 0; i < len; i++) {
			swap(array, off, off + len - i - 1);// 将大根堆最大元素与最后面的位置做交换
			shiftDown(array, off, len - i - 1, 0);// 始终调整第一个元素
		}
	}

	private static void buildHeap(int[] array, int left, int len) {
		int pos = len / 2 - 1;// 从第一个非叶子节点开始
		for (int i = pos; i >= 0; i--) {
			shiftDown(array, left, len, i); // 调整第i个非叶子节点
		}
	}

	private static void shiftDown(int[] array, int left, int len, int pos) {
		int tmp = array[left + pos];
		int indexLC = pos * 2 + 1, index;// 左孩子
		while (indexLC < len) {// 判断孩子是否存在
			if (indexLC + 1 < len
					&& array[left + indexLC] < array[left + indexLC + 1])
				index = indexLC + 1;// 右孩子大
			else
				index = indexLC;// 左孩子大
			if (tmp < array[left + index]) {// 交换
				array[left + pos] = array[left + index];
				pos = index;// 交换后大值继续跟孩子比较
				indexLC = pos * 2 + 1;
			} else
				break;
		}
		array[left + pos] = tmp;// 跟目标交换完成
	}

	/**
	 * 基数排序 稳定的排序算法 最差时间复杂度是 O(k·n) 空间复杂度O(k·n) 多个刻度指标时适用
	 * 
	 * @param array
	 * @param radix
	 *            基数
	 * @param distance
	 *            几遍
	 */
	private static void radixSort(int[] array, int radix, int distance) {
		// array为待排序数组
		// radix，代表基数
		// 代表排序元素的位数
		int length = array.length;
		int[] temp = new int[length];// 用于暂存元素
		int[] count = new int[radix];// 用于统计基数内元素个数
		int divide = 1;
		for (int i = 0; i < distance; i++) {
			System.arraycopy(array, 0, temp, 0, length);
			Arrays.fill(count, 0);
			for (int j = 0; j < length; j++) {
				int tempKey = (temp[j] / divide) % radix;
				count[tempKey]++; // 基数选中计数
			}

			for (int j = 1; j < radix; j++) {
				count[j] = count[j] + count[j - 1];// 累计计数
			}
			for (int j = length - 1; j >= 0; j--) {
				int tempKey = (temp[j] / divide) % radix;
				count[tempKey]--;// 从后往前赋值
				array[count[tempKey]] = temp[j];
			}

			divide = divide * radix;

		}

	}

	// 交换两个元素
	private static void swap(int[] array, int a, int b) {
		int t = array[a];
		array[a] = array[b];
		array[b] = t;
	}

	// 打印数组
	private static void printArray(String s, int[] array, int off, int len) {
		System.out.print(s);
		for (int i = off; i < off + len; i++) {
			if (i == off)
				System.out.print("[" + array[i] + ",");
			else if (i == off + len - 1)
				System.out.print(array[i]);
			else
				System.out.print(array[i] + ",");
		}
		System.out.println("]");
	}

	/**
	 * 获取三个数的中间元素
	 * 
	 * @param array
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private static int getMiddleIndexOfThreeElement(int[] array, int a, int b,
			int c) {
		if (array[a] < array[b]) {
			if (array[b] < array[c])
				return b;
			else if (array[c] < array[a])
				return a;
			else
				return c;
		} else {
			if (array[a] < array[c])
				return a;
			else if (array[c] < array[b])
				return b;
			else
				return c;
		}
	}

}