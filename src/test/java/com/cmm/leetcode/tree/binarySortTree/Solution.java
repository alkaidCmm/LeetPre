package com.cmm.leetcode.tree.binarySortTree;

/**
 * 二叉排序树的查找、插入、删除
 * 
 * @author cmm（1）若左子树不空，则左子树上所有结点的值均小于它的根结点的值； （2）若右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 *         （3）左、右子树也分别为二叉排序树； （4）没有键值相等的节点。
 */
public class Solution {
	public BinaryTreeNode root;

	/**
	 * 1. 二叉排序树的查找过程： （1）若查找树为空，查找失败； （2）若查找树非空，将给定的值与查找树的根结点关键字比较；
	 * （3）若相等则查找成功，结束查找过程； （4）否则，当给定的值小于根结点关键字，在以左孩子为根的子树上继续进行查找；
	 * （5）当给定的值大于根结点关键字，在以右孩子为根的子树上继续进行查找；
	 * 
	 * @param target
	 * @return
	 */
	public boolean find(BinaryTreeNode root, int target) {
		boolean flag = false;
		if (root != null) {
			BinaryTreeNode temp = root;
			while (temp != null) {
				if (temp.getValue() == target)
					flag = true;
				if (temp.getValue() < target)
					temp = temp.getRightChild();
				else
					temp = temp.getLeftChild();
			}
		}
		return flag;
	}

	/**
	 * 二叉排序树的插入
	 * 
	 * @param root
	 * @param target
	 * @return
	 */
	public int insert(BinaryTreeNode root, int target) {
		if (root == null)// 表示由于根节点为空，未插入节点
			return 0;
		if (target < root.getValue()) {// 进入左子树
			if (null == root.getLeftChild()) {// 如果左子树为空
				BinaryTreeNode temp = new BinaryTreeNode(target);
				temp.setParent(root);
				root.setLeftChild(temp);
				return 1;// 表示比较完成，插入左子树
			} else
				return insert(root.getLeftChild(), target);// 进入左子树继续准备插入,进入迭代过程

		} else if (target > root.getValue()) {// 进入右子树
			if (null == root.getRightChild()) {
				BinaryTreeNode temp = new BinaryTreeNode(target);
				temp.setParent(root);
				root.setRightChild(temp);
				return 1;// 表示比较完成，插入右子树
			} else
				return insert(root.getRightChild(), target);// 进入右子树继续准备插入
		} else// 插入的节点与父节点相同
			return 0;
	}

	/**
	 * 3. 二叉排序树的删除 （1）如果要删除的结点是叶子结点，删除不会断开树，可以立即删除该结点；
	 * （2）如果要删除的结点只有一个孩子，可以绕过该结点，调整其父结点的链，使父结点直接链接它的孩子；
	 * （3）如果要删除的结点有两个孩子，采用的策略是：用在右子树中的最小项替换要删除的结点，然后删除掉该结点即可。
	 * 
	 * @param root
	 * @param target
	 */
	public void delete(BinaryTreeNode root, int target) {
		if (root != null) {// 根结点判空
			if (target < root.getValue())// 目标值小于根节点值
				delete(root.getLeftChild(), target);
			else if (target > root.getValue())
				delete(root.getRightChild(), target);
			else if (null != root.getLeftChild()
					&& null != root.getRightChild()) {// 要删除的节点有两个孩子，（节点找到了）
				BinaryTreeNode min = root.getRightChild();
				while (min.getLeftChild() != null)// 用在右子树中的最小项替换要删除的结点，然后删除掉该结点即可。
					min = min.getLeftChild();
				root.setValue(min.getValue());// 让右子树上的最小值节点去替换【当前】的根节点
				delete(root.getRightChild(), min.getValue());// 删除替换后的根节点，这个根几点在原来根节点右子树中
			} else {// 要删除的节点只有一个子节点（节点找到了）
				if (null == root.getLeftChild()
						&& null != root.getRightChild()) {// 左子树为空，右子树不为空

					root.getParent().setRightChild(root.getRightChild());
					root.getRightChild().setParent(root.getParent());
				} else if (null != root.getLeftChild()
						&& null == root.getRightChild()) {// 左子树不为空，右子树为空
					root.getParent().setLeftChild(root.getLeftChild());
					root.getLeftChild().setParent(root.getParent());
				} else {// 左右子树均为空
					BinaryTreeNode temp = root.getParent();
					if (null != temp.getLeftChild())
						temp.setLeftChild(null);
					else
						temp.setRightChild(null);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
