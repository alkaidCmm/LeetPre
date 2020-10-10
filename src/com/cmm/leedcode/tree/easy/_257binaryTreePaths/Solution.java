package com.cmm.leedcode.tree.easy._257binaryTreePaths;

import com.cmm.leedcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caimingming02
 * @date 2020/9/28 11:51 AM
 * @desc
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) {
            searchBT(root, "", answer);
        }
        return answer;
    }

    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) {
            answer.add(path + root.val);
        }
        if (root.left != null) {
            searchBT(root.left, path + root.val + "->", answer);
        }
        if (root.right != null) {
            searchBT(root.right, path + root.val + "->", answer);
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode l=new TreeNode(2);
        TreeNode r=new TreeNode(3);
        TreeNode lr=new TreeNode(5);
        root.left=l;
        root.right=r;
        l.right=lr;
        new Solution().binaryTreePaths(root);
    }
}
