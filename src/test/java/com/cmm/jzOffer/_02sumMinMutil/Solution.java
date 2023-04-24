package com.cmm.jzOffer._02sumMinMutil;

/**
 * 题目:输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 
 * @author cmm
 *
 */
public class Solution {
	/**
	 * 该方法对任意的整数数组都适合，另外，要输出乘积最小的一组，没必要将所有的结果保存起来，
	 * 我们由下面我们高中时非常熟悉的数学公式可以证明最左边和最右边的两个符合要求的数的乘积最小。
	 * 
	 * @param nums
	 * @param target
	 */
	public void findSumMInMutil(int nums[], int target) {
		if (nums.length < 2)
			return;
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] == target) {
				System.out.println(nums[left] + "," + nums[right]);
				break;
			} else if (nums[left] + nums[right] < target)
				left++;
			else
				right--;
		}
	}

	public void findSumMInMutil_v2(int nums[], int target){
		if(nums.length<2){
			return;
		}
		int left=0;
		int right=nums.length-1;
		while(left<right){
			if(nums[left]+nums[right]==target){
				System.out.println();
				break;
			}else if(nums[left]+nums[right]>target){
				right--;
			}else{
				left++;
			}
		}
	}

	public void findSumMinMutil2(int nums[], int target) {
		if (nums.length < 2)
			return;
		boolean[] B = new boolean[target];
		System.out.println(B[0] + "--" + B[1]);
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > target)
				continue;// 跳过本次循环，继续执行下一次循环
			/**
			 * 注意下面操作:B[1]=false,B[10]=true;B[2]=false,B[9]=turre;B[4]=false,B[
			 * 10]=true,此时可以输出nums[1]、nums[10]的值,以此类推，
			 * 不需要顺序的同样可以求出两个和为target的所有数对
			 */
			if (B[nums[i]] == false)
				B[target - nums[i]] = true;
			else {
				System.out.println(nums[i] + "," + (target - nums[i]));
			}
		}
	}

	public static void main(String[] args) {
		int nums[] = { 1, 2, 4, 10, 3, 7, 5, 8, 9, 6 };
		new Solution().findSumMinMutil2(nums, 11);
	}
}
