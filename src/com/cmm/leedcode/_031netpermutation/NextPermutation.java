package com.cmm.leedcode._031netpermutation;

import java.util.Arrays;

public class NextPermutation {
	public int[] nextPermutation(int nums[]) {
		if (nums.length <= 1)
			return nums;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				int j;
				for (j = nums.length - 1; j >= i; j--)
					if (nums[i] < nums[j])
						break;
				// swap the two numsbers.
				nums[i] = nums[i] ^ nums[j];
				nums[j] = nums[i] ^ nums[j];
				nums[i] = nums[i] ^ nums[j];
				// sort the rest of arrays after the swap point.
				Arrays.sort(nums, i + 1, nums.length);
				return nums;
			}
		}
		// 如果全倒序排序的话，进行逆转
		for (int i = 0; i < nums.length / 2; i++) {
			int tmp = nums[i];
			nums[i] = nums[nums.length - i - 1];
			nums[nums.length - i - 1] = tmp;
		}
		return nums;
	}

	public static void main(String[] args) {
		int[] nums = { 6, 5, 4, 3, 2, 1 };
		int numsber[] = new NextPermutation().nextPermutation(nums);
		for (int i = 0; i < numsber.length; i++) {
			System.out.print(numsber[i]);
		}

	}

}
