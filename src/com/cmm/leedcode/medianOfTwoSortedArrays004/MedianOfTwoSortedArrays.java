package com.cmm.leedcode.medianOfTwoSortedArrays004;

public class MedianOfTwoSortedArrays {
	private double findKthSortedArrays(int A[], int astart, int aend, int B[],
			int bstart, int bend, int k) {
		int m = aend - astart;
		int n = bend - bstart;
		if (m < n) // 保证数组长度大的在前，小的在后
			return findKthSortedArrays(B, bstart, bend, A, astart, aend, k);
		if (n == 0)
			return A[astart + k - 1];// 即第二个数组为空
		if (k == 1)
			return Math.min(A[astart], B[bstart]);// 各个只有一个数组元素，返回较小的
		int pb = Math.min(k / 2, n);
		int pa = k - pb;
		if (A[astart + pa - 1] > B[bstart + pb - 1])
			return findKthSortedArrays(A, astart, aend, B, bstart + pb, bend, k
					- pb);
		else if (A[astart + pa - 1] < B[bstart + pb - 1])
			return findKthSortedArrays(A, astart + pa, aend, B, bstart, bend, k
					- pa);
		else
			return A[astart + pa - 1];
	}

	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		if ((m + n) % 2 == 1)
			return findKthSortedArrays(A, 0, m, B, 0, n, (m + n) / 2 + 1);
		else
			return (findKthSortedArrays(A, 0, m, B, 0, n, (m + n) / 2 + 1) + findKthSortedArrays(
					A, 0, m, B, 0, n, (m + n) / 2)) / 2.0;
	}

	public static void main(String[] args) {
		int A[] = { 1, 3, 5, 7, 9 };
		int B[] = { 2, 4, 6, 8 };
		MedianOfTwoSortedArrays mtsa = new MedianOfTwoSortedArrays();
		System.out.println(mtsa.findMedianSortedArrays(A, B));
	}
}
