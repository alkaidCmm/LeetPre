package com.cmm.leedcode.tree.easy._653findTarget;

import com.cmm.leedcode.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cmm
 * @date 2020/7/9 4:57 PM
 * @desc Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 9
 * <p>
 * Output: True
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 28
 * <p>
 * Output: False
 */
public class Solution {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> valSet = new HashSet<>();
        return dfs(root, k, valSet);
    }

    private boolean dfs(TreeNode root, int k, Set<Integer> valSet) {
        if (root == null) {
            return false;
        }
        if (valSet.contains(k - root.val)) {
            return true;
        }
        valSet.add(root.val);
        return dfs(root.left, k, valSet) || dfs(root.right, k, valSet);
    }
}
