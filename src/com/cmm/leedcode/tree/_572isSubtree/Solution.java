package com.cmm.leedcode.tree._572isSubtree;

import com.cmm.leedcode.tree.TreeNode;

/**
 * @author cmm
 * @date 2020/7/9 8:31 PM
 * @desc 判断一个树是另一个树的子树，需数值和结构都相同
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 * <p>
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * Given tree t:
 * 4
 * / \
 * 1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 * <p>
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * Given tree t:
 * 4
 * / \
 * 1   2
 * Return false.
 */
public class Solution {


    public boolean isSubtree(TreeNode s, TreeNode t) {
//        if (s == null) {
//            return false;
//        }
        if (isSame(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }

        if (s.val != t.val) {
            return false;
        }
        return isSubtree(s.left, t.left) && isSubtree(s.right, t.right);
    }
}
