package com.cmm.leetcode.sort;

/**
 * 堆排序：https://github.com/hustcc/JS-Sorting-Algorithm/blob/master/7.heapSort.md
 */
public class HeapSort {
	private static int[] buildMaxHeap(int[] num) {
		for (int i = (num.length - 2) / 2; i >= 0; i--) {// 这里从第一个非叶子节点开始
			adjustDownUp(num, i, num.length);
		}
		return num;
	}

	private static void adjustDownUp(int[] num, int i, int length) {
		// 保存第一个非叶子结点的元素
		int cur = num[i];
		// i为初始化为节点k的左孩子，沿节点序号较大的子节点向下调整
		for (int left = 2 * i + 1; left < length - 1; left = 2 * left + 1) {
			// 取节点较大的子节点的下标
			if (left < length && num[left] < num[left + 1])
				left++;
			// 如果节点的右孩子>左孩子，则取右孩子节点的下标
			if (cur >= num[left])// 根节点 >=左右子女中关键字较大者
				break;
			else {
				// 将左右子结点中较大值num[left]调整到双亲节点上
				num[i] = num[left];
				// 【关键】修改i值，以便继续向下调整(这里一定要注意，越靠近根节点的值需要与叶子结点比较)
				i = left;
			}
		}
		num[i] = cur;
	}

	// 堆排序
	public static int[] heapSort(int[] array) {
		// 初始建堆，array[0]为第一趟值最大的元素
		array = buildMaxHeap(array);
		// 每次调整跳过最后一个
		for (int i = array.length - 1; i > 0; i--) {
			// 将堆顶元素和堆低元素交换，即得到当前最大元素正确的排序位置
			int temp = array[0];
			array[0] = array[i];
			// 最后一个元素为最大值
			array[i] = temp;
			// 整理，将剩余的元素整理成堆，这里第二个参数直接从第一个元素开始，因为除了第一个元素，整个还是满足大根堆
			adjustDownUp(array, 0, i);
		}
		return array;
	}

	public static void main(String[] args) {
		// 87,45,78,32,17,65,53,9,122
		int num[] = { 1, 4, 8, 5, 3, 9, 20, 6, 25, 7, 48 };
		buildMaxHeap(num);
		heapSort(num);
	}

}
