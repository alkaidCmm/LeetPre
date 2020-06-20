package com.cmm.fuckalgor;

import java.util.Stack;

/**
 * @author cmm
 * @date 2020/6/16 9:35 AM
 * @desc
 */
public class StackModule {

    /**
     * 给你一个数组，返回一个等长的数组，对应索引存储着下一个更大元素，如果没有更大的元素，就存 -1。不好用语言解释清楚，直接上一个例子：
     * <p>
     * 给你一个数组 [2,1,2,4,3]，你返回数组 [4,2,4,-1,-1]。
     *
     * @param nums
     * @return
     */
    public static int[] nextGreaterElement(int[] nums) {
        int[] ret = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            ret[i] = stack.empty() ? -1 : stack.pop();
            stack.push(nums[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 2, 4, 3};
        int[] ret = nextGreaterElement(nums);
        System.out.println(ret);
    }
}
