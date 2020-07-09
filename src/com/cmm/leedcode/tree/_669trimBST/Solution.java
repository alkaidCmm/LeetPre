package com.cmm.leedcode.tree._669trimBST;

import com.cmm.leedcode.tree.TreeNode;

/**
 * @author cmm
 * @date 2020/7/9 9:46 AM
 * @desc Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.
 * <p>
 * Example 1:
 * Input:
 * 1
 * / \
 * 0   2
 * <p>
 * L = 1
 * R = 2
 * <p>
 * Output:
 * 1
 * \
 * 2
 * Example 2:
 * Input:
 * 3
 * / \
 * 0   4
 * \
 * 2
 * /
 * 1
 * <p>
 * L = 1
 * R = 3
 * <p>
 * Output:
 * 3
 * /
 * 2
 * /
 * 1
 */
public class Solution {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode l = new TreeNode(5);
        TreeNode r = new TreeNode(10);
        TreeNode ll = new TreeNode(3);
        TreeNode lr = new TreeNode(6);
        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(20);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.left = rl;
        r.right = rr;
        Solution s = new Solution();
        TreeNode ret=s.trimBST(root,4,15);
        System.out.println(ret);
    }
}
