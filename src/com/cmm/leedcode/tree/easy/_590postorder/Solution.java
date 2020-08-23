package com.cmm.leedcode.tree.easy._590postorder;

import com.cmm.leedcode.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cmm
 * @date 2020/7/9 7:09 PM
 * @desc https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 */
public class Solution {

    List<Integer> ret = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return ret;
        }
        for (Node child : root.children) {
            postorder(child);
        }
        ret.add(root.val);
        return ret;
    }
}
