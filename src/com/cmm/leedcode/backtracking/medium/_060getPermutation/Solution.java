package com.cmm.leedcode.backtracking.medium._060getPermutation;

import java.util.LinkedList;
import java.util.List;

/**
 * @author cmm
 * @date 2020/7/17 9:30 PM
 * @desc The set [1,2,3,...,n] contains a total of n! unique permutations. By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note:
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 * Input: n = 4, k = 9
 * Output: "2314"
 */
public class Solution {


    /**
     * example:
     * n = 4, k = 14:  We have {1, 2, 3, 4}, find the 14th permutation.
     * List out all the permutations:
     * 1 + (permutations of 2, 3, 4)
     * 2 + (permutations of 1, 3, 4)
     * 3 + (permutations of 1, 2, 4)
     * 4 + (permutations of 1, 2, 3)
     * To find the 14th, we can see it falling to range 3 + (permutations of 1, 2, 4), since 1 + (permutations of 2, 3, 4) and 2 + (permutations of 1, 3, 4) could take the first 2 * (3!) = 12 permutations. So we can know the first number of result is 3.
     * <p>
     * Then the question turn to be a smaller problem.
     * {1, 2, 4}, find the 2nd permutation.
     * List out all the permutations:
     * 1 + (permutations of 2, 4)
     * 2 + (permutations of 1, 4)
     * 4 + (permutations of 1, 2)
     * <p>
     * There are 2! + 2! + 2!, 6 permutation. The 2nd must be in range 1 + (permutations of 2, 4). So we can know the second number of result is 1.
     * <p>
     * So the question turn be a smaller problem.
     * {2, 4}, find the 2nd permutation. The answer is (4, 2).
     * So the final result is (3, 1, 4, 2)
     */
    public String getPermutation(int n, int k) {
        List<Integer> nums = new LinkedList();
        StringBuilder res = new StringBuilder();

        // n个元素对应的组合个数，n！
        int[] f = new int[n];
        // 0's factorial is 1
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            nums.add(i);
            f[i] = f[i - 1] * i;
        }
        nums.add(n);
        // 14th count from 1, turn to be 13th count from 0.
        k--;

        for (int i = n; i > 0; i--) {
            // 计算每一轮第一个数字对应的下表
            int idx = k / f[i - 1];
            k = k % f[i - 1];

            res.append(nums.get(idx));
            nums.remove(idx);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String ret=new Solution().getPermutation(4,14);
        System.out.println(ret);
    }
}
