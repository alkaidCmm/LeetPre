package com.cmm.leetcode._888FairCandySwap;

import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * @Author: cmm
 * @Date: 2018/8/23 2:11 AM
 * <p>
 * desc:
 * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.
 * <p>
 * Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
 * <p>
 * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.
 * <p>
 * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
 */
public class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int diff = (IntStream.of(A).sum() - IntStream.of(B).sum()) / 2;
        HashSet<Integer> s = new HashSet<>();
        // a去重复
        for (int a : A) {
            s.add(a);
        }
        for (int b : B) {
            if (s.contains(b + diff)) {
                return new int[]{b, b + diff};
            }
        }
        return new int[0];
    }

    public int[] fairCandySwap1(int[] A, int[] B) {
        int dif = (IntStream.of(A).sum() - IntStream.of(B).sum()) / 2;
        HashSet<Integer> S = new HashSet<>();
        for (int a : A) S.add(a);
        for (int b : B) if (S.contains(b + dif)) return new int[] {b + dif, b};
        return new int[0];
    }
}
