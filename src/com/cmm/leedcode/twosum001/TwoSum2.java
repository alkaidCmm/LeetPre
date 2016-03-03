package com.cmm.leedcode.twosum001;

import java.util.HashMap;

public class TwoSum2 {
	public int[] twoSum(int numbers[], int target) {
		int[] res = new int[2];
		HashMap<Integer, Integer> nums = new HashMap<Integer, Integer>();

		//这里注意是吧numbers数组值作为key，将下标值作为value
		for (int i = 0; i < numbers.length; i++) {
			//将所有不相同的数加入nums中
			Integer a = nums.get(numbers[i]);
			if (a == null)
				nums.put(numbers[i], i);
			//需找第二个值
			a = nums.get(target - numbers[i]);
			if (a != null && a < i) {
				res[0] = a + 1;
				res[1] = i + 1;
				break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int numbers[] = { 1, 3, 5, 7, 9, 2, 4, 6, 8, 0 };
		TwoSum ts = new TwoSum();
		int indexs[] = ts.twoSum(numbers, 11);
		for (int i = 0; i < indexs.length; i++) {
			System.out.println(indexs[i]);
		}
	}

}
