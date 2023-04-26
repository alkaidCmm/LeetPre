package com.cmm.leetcode.tree.medium._113pathSum;

import com.cmm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caimingming02
 * @date 2020/10/26 8:42 AM
 * @desc Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret=new ArrayList<>();
        pathSum(root,sum,new ArrayList<>(),ret);
        return ret;
    }

    /**
     * 回溯
     * @param root
     * @param sum
     * @param solution
     * @param ret
     */
    private void pathSum(TreeNode root, int sum, List<Integer> solution,List<List<Integer>> ret) {
        if(root==null){
            return;
        }
        solution.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            ret.add(new ArrayList<Integer>(solution));
        } else {
            pathSum(root.left, sum - root.val, solution, ret);
            pathSum(root.right, sum - root.val, solution, ret);
        }
        // 回溯
        solution.remove(solution.size() - 1);
    }
}