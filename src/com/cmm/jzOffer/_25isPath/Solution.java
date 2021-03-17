package com.cmm.jzOffer._25isPath;

import com.cmm.jzOffer._19mirrorofBinaryTree.BinaryTreeNode;

import java.util.Stack;

/**
 * 二叉树中和为某一值得路径: 从树的根节点开始往下一直到叶结点所经过的结点形成的路径（根到叶子）
 *
 * @author cmm
 * 思路：首先要想到的是通过遍历可以找到所有路径，按照先序遍历的思路，先将经过的左节点入栈，如果是进的是叶子节点，则判断和是否符合要求，
 * 遍历到右节点时，先回到根节点，出栈，再进栈，判断叶子节点。
 */
public class Solution {
    public void isPath(BinaryTreeNode root, int expectSum, int currentSum,
                       Stack<Integer> stack) {// 这里stack是一个工具
        if (root == null)
            return;
        stack.push(root.getValue());
        currentSum += root.getValue();
        if (root.getLeft() == null && root.getRight() == null && currentSum == expectSum)
            for (Integer e : stack)
                System.out.println(e + ",");
        if (root.getLeft() != null)
            isPath(root.getLeft(), expectSum, currentSum, stack);
        if (root.getRight() != null)
            isPath(root.getRight(), expectSum, currentSum, stack);
        stack.pop();
    }

    public static void main(String[] args) {
        BinaryTreeNode b1 = new BinaryTreeNode(8);
        BinaryTreeNode b2 = new BinaryTreeNode(6);
        BinaryTreeNode b3 = new BinaryTreeNode(10);
        BinaryTreeNode b4 = new BinaryTreeNode(5);
        BinaryTreeNode b5 = new BinaryTreeNode(7);
        BinaryTreeNode b6 = new BinaryTreeNode(9);
        BinaryTreeNode b7 = new BinaryTreeNode(11);
        b1.setLeft(b2);
        b1.setRight(b3);
        b2.setLeft(b4);
        b2.setRight(b5);
        b3.setLeft(b6);
        b3.setRight(b7);
        Solution s = new Solution();
        Stack<Integer> stack = new Stack<Integer>();
        s.isPath(b1, 21, 0, stack);
        System.out.println("over!");
    }

}
