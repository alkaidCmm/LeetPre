package com.cmm.leetcode.tree.traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	private Node<Integer> root;

	public Node<Integer> createBinaryTree(int arr[]) {
		return null;
	}

	/**
	 * 递归获得二叉树深度
	 * 
	 * @param node
	 * @return
	 */
	public int getDepthRecursion(Node<Integer> node) {
		if (node == null)
			return 0;
		int leftLen = getDepthRecursion(node.getLeft());
		int rightLen = getDepthRecursion(node.getRight());
		int maxLen = Math.max(leftLen, rightLen);
		return maxLen + 1;// 每跳出一层加1
	}

	/**
	 * 非递归，利用队列层序遍历
	 * 
	 * @return
	 */
	public List<Integer> layerOrder() {
		Queue<Node<Integer>> q = new LinkedList<Node<Integer>>();
		List<Integer> list = new ArrayList<Integer>();// 保存遍历结果
		q.add(root);
		while (!q.isEmpty()) {
			Node<Integer> current = q.remove();// 删除队列头部
			list.add(current.getValue());
			// System.out.println(current.getValue());
			if (current.getLeft() != null)
				q.add(current.getLeft());
			if (current.getRight() != null)
				q.add(current.getRight());
		}
		return list;
	}

	/**
	 * 递归前序遍历
	 * 
	 * @param node
	 */
	public void preOrder(Node<Integer> node) {
		if (null != node)
			System.out.print(node.getValue() + ",");
		if (null != node.getLeft())
			preOrder(node.getLeft());
		if (null != node.getRight())
			preOrder(node.getRight());
	}

	/**
	 * 递归中序遍历
	 * 
	 * @param node
	 */
	public void inOrder(Node<Integer> node) {
		if (null != node.getLeft())
			inOrder(node.getLeft());
		if (null != node)
			System.out.print(node.getValue() + ",");
		if (null != node.getRight())
			inOrder(node.getRight());
	}

	/**
	 * 递归后序遍历
	 * 
	 * @param node
	 */
	public void postOrder(Node<Integer> node) {
		if (null != node.getLeft())
			postOrder(node.getLeft());
		if (null != node.getRight())
			postOrder(node.getRight());
		if (null != node)
			System.out.print(node.getValue() + ",");
	}

	/**
	 * 非递归前序遍历
	 * 
	 * @param node
	 */
	public List<Integer> preOrderNoRecursion(Node<Integer> node) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<Node<Integer>> Stack = new Stack<Node<Integer>>();
		if (node != null) {
			Stack.push(node);// 通过栈来模拟
			Node<Integer> current = null;
			while (!Stack.isEmpty()) {
				current = Stack.pop();
				list.add(current.getValue());
				System.out.print(current.getValue() + ",");
				if (current.getRight() != null)// 先把根节点的右子节点放入，
					Stack.push(current.getRight());
				if (current.getLeft() != null)// 再放左子节点
					Stack.push(current.getLeft());
			}
		}
		return list;
	}

	/**
	 * 非递归中序遍历
	 * 
	 * @param node
	 * @return
	 */
	public List<Integer> inOrderNoRecursion(Node<Integer> node) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		Node<Integer> current = node;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);// 非空时入栈
				current = current.getLeft();
			}
			if (!stack.isEmpty()) {
				current = stack.pop();
				list.add(current.getValue());
				System.out.print(current.getValue() + ",");
				current = current.getRight();
			}
		}
		return list;
	}

	/**
	 * 非递归后序遍历：当上一个访问的结点是右孩子或者当前结点没有右孩子则访问当前结点
	 * 
	 * @param node
	 * @return
	 */
	protected void postOrderNoRecursion(Node<Integer> p) {
		Node<Integer> q = p;
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		while (p != null) {
			// 左子树入栈
			for (; p.getLeft() != null; p = p.getLeft())
				stack.push(p);
			// 当前节点无右子或右子已经输出（右子树为空，或者已经访问过了）
			while (p != null && (p.getRight() == null || p.getRight() == q)) {
				System.out.print(p.getValue() + ",");
				q = p;// 记录上一个已输出节点
				if (stack.empty())
					return;
				p = stack.pop();
			}
			// 处理右子
			stack.push(p);
			p = p.getRight();
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.root = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(2);
		Node<Integer> n3 = new Node<Integer>(3);
		Node<Integer> n4 = new Node<Integer>(4);
		Node<Integer> n5 = new Node<Integer>(5);
		Node<Integer> n6 = new Node<Integer>(6);
		Node<Integer> n7 = new Node<Integer>(7);
		Node<Integer> n8 = new Node<Integer>(8);
		Node<Integer> n9 = new Node<Integer>(9);
		Node<Integer> n10 = new Node<Integer>(10);
		s.root.setLeft(n2);
		s.root.setRight(n3);
		n2.setLeft(n4);
		n2.setRight(n5);
		n3.setLeft(n6);
		n3.setRight(n7);
		n4.setLeft(n8);
		n4.setRight(n9);
		n5.setRight(n10);

		System.out.println("树的深度：" + s.getDepthRecursion(s.root));
		System.out.println("树的层序遍历：" + s.layerOrder());
		System.out.print("树的前序递归遍历：");
		s.preOrder(s.root);
		System.out.println();
		System.out.print("树的中序递归遍历：");
		s.inOrder(s.root);
		System.out.println();
		System.out.print("树的后序递归遍历：");
		s.postOrder(s.root);
		System.out.println();
		System.out.print("树的前序非递归遍历：");
		s.preOrderNoRecursion(s.root);
		System.out.println();
		System.out.print("树的中序非递归遍历：");
		s.inOrderNoRecursion(s.root);
		System.out.println();
		System.out.print("树的后序非递归遍历：");
		s.postOrderNoRecursion(s.root);

	}

	public static void pre(Node<Integer> p) {
		if (p != null) {
			Stack<Node<Integer>> s = new Stack<Node<Integer>>();
			s.push(p);
			Node<Integer> cur = null;
			while (!s.isEmpty()) {
				cur = s.pop();
				System.out.println(cur.getValue());
				if (cur.getRight() != null)
					s.push(cur.getRight());
				if (cur.getLeft() != null)
					s.push(cur.getLeft());
			}
		}
	}

	public static void in(Node<Integer> p) {
		if (p != null) {
			Node<Integer> cur = p;
			Stack<Node<Integer>> s = new Stack<Node<Integer>>();
			while (cur != null || !s.isEmpty()) {
				while (cur != null) {
					s.push(cur);
					cur = cur.getLeft();
				}
				if (!s.isEmpty()) {
					cur = s.pop();
					System.out.println(cur.getValue());
					cur = cur.getRight();
				}
			}
		}
	}

	public static void post(Node<Integer> p) {
		if (p != null) {
			Node<Integer> q = p;
			Stack<Node<Integer>> s = new Stack<Node<Integer>>();
			while (p != null) {
				for (; p.getLeft() != null; p = p.getLeft())
					s.push(p).getLeft();
				while (p != null
						&& (p.getRight() == null || p.getRight() == q)) {
					System.out.println(p.getValue());
					q = p;
					if (s.isEmpty())
						return;
					p = s.pop();
				}
				s.push(p);
				p = p.getRight();
			}
		}
	}
	private void testHahsMap() {
		HashMap map=new HashMap<>();

	}
}
