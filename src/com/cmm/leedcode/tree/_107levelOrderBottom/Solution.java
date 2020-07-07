package com.cmm.leedcode.tree._107levelOrderBottom;

import com.cmm.leedcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cmm
 * @date 2020/6/27 8:15 PM
 * @desc Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 *
 * 层序遍历并存入list
 */
public class Solution {

    // todo
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        return ret;
    }

    public void addLevel(TreeNode root, List<List<Integer>> ret, int level) {
        if (root == null) {
            return;
        }
        if (ret.size() > level) {
            ret.add(0,new ArrayList<>());
        }



    }
}

