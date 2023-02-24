package com.cmm.leetcode.bitManipulation.easy._136singleNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: cmm
 * @Date: 2018/9/10 12:51 AM
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class Solution {

    /**
     * A XOR A = 0
     *
     * @param A
     * @return
     */
    int singleNumber(int A[]) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result ^= A[i];
        }
        return result;
    }

    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for (Integer num : map.keySet()) {
            if (map.get(num) == 1) {
                return num;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int A[] = {4,1,2,1,2};

        s.singleNumber2(A);
    }
}
