package com.cmm.leedcode.tree._437pathSum;

import com.cmm.leedcode.tree.TreeNode;

import java.util.HashMap;

/**
 * @author cmm
 * @date 2020/7/13 8:28 PM
 * @desc
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class Solution {


    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }

    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode l = new TreeNode(5);
        TreeNode r = new TreeNode(-3);
        TreeNode ll = new TreeNode(3);
        TreeNode lr = new TreeNode(2);
        TreeNode rr = new TreeNode(11);
        TreeNode lll = new TreeNode(3);
        TreeNode llr = new TreeNode(-2);
        TreeNode lrr = new TreeNode(1);

        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.right = rr;
        ll.left = lll;
        ll.right = llr;
        lr.right = lrr;
        Solution s = new Solution();
        int ret = s.pathSum(root, 8);
        System.out.println(ret);
    }
}
