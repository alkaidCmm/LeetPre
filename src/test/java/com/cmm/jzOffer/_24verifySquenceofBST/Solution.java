package com.cmm.jzOffer._24verifySquenceofBST;

import java.util.Arrays;

/**
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回 true。否则返回
 * false。假设输入的数组的任意两个数字都互不相同。
 *
 * @author cmm 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树：
 * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 它的左、右子树也分别为二叉排序树。
 */
public class Solution {
    /**
     * @param nums
     * @return
     */
    public boolean verifySquenceofBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int root = nums[nums.length - 1];// 根节点

        int i = 0;
        // 获得左子树边界
        for (i = 0; i < nums.length - 1; i++)
            if (nums[i] >= root)
                break;
        // 判定右子树与根节点大小关系，确定有效性
        for (int j = i; j < nums.length; j++)
            if (nums[j] < root)
                return false;
        // 重新构建左子树和右子树的新序列
        int[] leftNums = Arrays.copyOfRange(nums, 0, i);// 第一个参数表示原始数组，第二个参数表示开始位置，第三个表示结束位置，左闭右开
        int[] rightNums = Arrays.copyOfRange(nums, i, nums.length - 1);
        System.out.println("leftNums。length=" + leftNums.length
                + ",rightNUm.size=" + rightNums.length);
        boolean leftFlag = true;
        boolean rightFlag = true;
        if (leftNums.length > 0)
            leftFlag = verifySquenceofBST(leftNums);
        if (rightNums.length > 0)
            rightFlag = verifySquenceofBST(rightNums);
        return leftFlag && rightFlag;

    }

    public boolean verifySquenceofBST_v2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int length = nums.length;
        int root = nums[length - 1];

        int i = 0;
        for (; i < length - 1; i++) {
            if (nums[i] > root) {
                break;
            }
        }

        for (int j = i; j < length; j++) {
            if (nums[j] < root) {
                return false;
            }
        }

        int[] leftArr = Arrays.copyOfRange(nums, 0, i);
        int[] rightArr = Arrays.copyOfRange(nums, i + 1, length - 1);

        boolean leftFlag = true;
        boolean rightFlag = true;
        if (leftArr.length > 0) {
            leftFlag = verifySquenceofBST_v2(leftArr);
        }
        if (rightArr.length > 0) {
            rightFlag = verifySquenceofBST_v2(rightArr);
        }

        return leftFlag && rightFlag;

    }

    public static void main(String[] args) {
        int[] nums = {2, 9, 5, 16, 17, 15, 19, 18, 12};
        System.out.println(new Solution().verifySquenceofBST(nums));
    }
}
