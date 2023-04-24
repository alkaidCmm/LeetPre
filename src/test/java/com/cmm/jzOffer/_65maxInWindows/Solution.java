package com.cmm.jzOffer._65maxInWindows;

import java.util.*;

public class Solution {
	private static List<Integer> maxInWindows(List<Integer> data, int size) {
		List<Integer> windowMax = new LinkedList<>();// 用于保存最大窗口值
		// 条件检查
		if (data == null || size < 1 || data.size() < 1) {// 边界值判定
			return windowMax;
		}
		Deque<Integer> idx = new LinkedList<>();
		// 窗口还没有被填满时，找最大值的索引
		for (int i = 0; i < size && i < data.size(); i++) {
			// 如果索引对应的值比之前存储的索引值对应的值大或者相等，就删除之前存储的值
			while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())) {
				idx.removeLast();
			}
			// 添加索引
			idx.addLast(i);
		}
		System.out.println(idx.toString());
		// 窗口已经被填满了
		for (int i = size; i < data.size(); i++) {
			// 第一个窗口的最大值保存
			windowMax.add(data.get(idx.getFirst()));
			// 如果索引对应的值比之前存储的索引值对应的值大或者相等，就删除之前存储的值
			while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())) {
				idx.removeLast();
			}
			// 删除已经滑出窗口的数据对应的下标(不在窗口范围内的数据)
			if (!idx.isEmpty() && idx.getFirst() <= (i - size)) {
				idx.removeFirst();
			}
			// 可能的最大的下标索引入队
			idx.addLast(i);
		}
		// 最后一个窗口最大值入队
		windowMax.add(data.get(idx.getFirst()));
		return windowMax;
	}

	private static List<Integer> arrayToCollection(int[] array) {
		List<Integer> result = new LinkedList<>();
		if (array != null) {
			for (int i : array) {
				result.add(i);
			}
		}
		return result;
	}


	/**
	 * 维护一个大小为窗口大小的大顶堆，顶堆元素则为当前窗口的最大值。
	 *
	 * 假设窗口的大小为 M，数组的长度为 N。
	 * 在窗口向右移动时，需要先在堆中删除离开窗口的元素，并将新到达的元素添加到堆中，
	 * 这两个操作的时间复杂度都为 log2M，因此算法的时间复杂度为 O(Nlog2M)，空间复杂度为 O(M)。
	 * @param num
	 * @param size
	 * @return
	 */
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> ret = new ArrayList<>();
		if (size > num.length || size < 1)
			return ret;
		/* 大顶堆 */
		PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		for (int i = 0; i < size; i++)
			heap.add(num[i]);
		// 堆顶数据即为该窗口最大值
		ret.add(heap.peek());
		/* 维护一个大小为 size 的大顶堆 */
		for (int i = 0, j = i + size; j < num.length; i++, j++) {
			heap.remove(num[i]);
			heap.add(num[j]);
			ret.add(heap.peek());
		}
		return ret;
	}

	public static void main(String[] args) {
		// expected {7};
		// List<Integer> data1 = arrayToCollection(
		// new int[] { 1, 3, -1, -3, 5, 3, 6, 7 });
		// System.out.println(data1 + "," + maxInWindows(data1, 10));
		// expected {3, 3, 5, 5, 6, 7};
		List<Integer> data2 = arrayToCollection(
				new int[] { 1, 3, -1, -3, 5, 3, 6, 7 });
		System.out.println(data2 + "," + maxInWindows(data2, 3));
		// expected {7, 9, 11, 13, 15};
		List<Integer> data3 = arrayToCollection(
				new int[] { 1, 3, 5, 7, 9, 11, 13, 15 });
		System.out.println(data3 + "," + maxInWindows(data3, 4));
		// expected {16, 14, 12};
		List<Integer> data5 = arrayToCollection(
				new int[] { 16, 14, 12, 10, 8, 6, 4 });
		System.out.println(data5 + "," + maxInWindows(data5, 5));
		// expected {10, 14, 12, 11};
		// List<Integer> data6 = arrayToCollection(new int[] { 10, 14, 12, 11
		// });
		// System.out.println(data6 + "," + maxInWindows(data6, 1));
		// // expected {14};
		// List<Integer> data7 = arrayToCollection(new int[] { 10, 14, 12, 11
		// });
		// System.out.println(data7 + "," + maxInWindows(data7, 4));
	}
}
