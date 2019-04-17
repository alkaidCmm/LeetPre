package com.cmm.leedcode.array._026RemoveDuplicatesfromSortedArray;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length. Do not allocate extra space for
 * another array, you must do this in place with constant memory. For example,
 * Given input array nums = [1,1,2], Your function should return length = 2,
 * with the first two elements of nums being 1 and 2 respectively. It doesn't
 * matter what you leave beyond the new length.
 *
 * @author cmm 给一个有序数列，删重复的元素
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] A) {
        if (A.length < 2) {
            return A.length;
        }
        int count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                A[count++] = A[i];
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int a[] = {1, 1, 2, 2, 3, 3, 4, 4, 4, 4};
        System.out.println(new RemoveDuplicates().removeDuplicates(a));
    }

}
