package com.cmm.leedcode.tree.traversal;

import java.util.ArrayList;
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
		List<Integer> list = new ArrayList<Integer>();
		q.add(root);
		while (!q.isEmpty()) {
			Node<Integer> current = q.remove();// 删除对头
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
				if (current.getRight() != null)
					Stack.push(current.getRight());
				if (current.getLeft() != null)
					Stack.push(current.getLeft());
			}
		}
		return list;
	}

	/**
	 * 非递归前序遍历2
	 * 
	 * @param node
	 */
	public List<Integer> preOrderNoRecursion2(Node<Integer> node) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		// Node node = node;
		while (node != null || stack.size() > 0) {
			while (node != null) {// 压入所有的左节点，压入前访问它
				System.out.print(node.getValue() + ",");
				stack.push(node);
				node = node.getLeft();
			}
			if (stack.size() > 0) {//
				node = stack.pop();
				node = node.getRight();
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
	 * 非递归中序遍历2
	 * 
	 * @param node
	 * @return
	 */
	public List<Integer> inOrderNoRecursion2(Node<Integer> node) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<Node> stack = new Stack<Node>();
		while (node != null) {
			while (node != null) {
				if (node.getRight() != null)
					stack.push(node.getRight());// 当前节点右子入栈
				stack.push(node);// 当前节点入栈
				node = node.getLeft();
			}
			node = stack.pop();
			while (!stack.empty() && node.getRight() == null) {
				System.out.println(node.getValue());
				node = stack.pop();
			}
			System.out.println(node.getValue());
			if (!stack.empty())
				node = stack.pop();
			else
				node = null;
		}
		return null;// 暂时的
	}

	/**
	 * 非递归后序遍历：当上一个访问的结点是右孩子或者当前结点没有右孩子则访问当前结点
	 * 
	 * @param node
	 * @return
	 */
	public List<Integer> postOrderNoRecursion(Node<Integer> node) {
		List<Integer> list = new ArrayList<Integer>();
		Node<Integer> rNode = null;
		Node<Integer> current = node;
		LinkedList<Node<Integer>> stack = new LinkedList<Node<Integer>>();
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.getLeft();
			}
			current = stack.pop();
			while (current != null && (current.getRight() == null
					|| current.getRight() == rNode)) {
				System.out.print(current.getValue() + ",");
				list.add(current.getValue());
				rNode = current;
				if (stack.isEmpty()) {
					System.out.println();
					return null;
				}
				current = stack.pop();
			}
			stack.push(current);
			current = current.getRight();
		}
		return list;
	}

	/** 非递归实现后序遍历 */
	protected static void iterativePostorder(Node p) {
		Node q = p;
		Stack<Node> stack = new Stack<Node>();
		while (p != null) {
			// 左子树入栈
			for (; p.getLeft() != null; p = p.getLeft())
				stack.push(p);
			// 当前节点无右子或右子已经输出
			while (p != null && (p.getRight() == null || p.getRight() == q)) {
				System.out.println(p.getValue());
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

	/** 非递归实现后序遍历 双栈法 */
	protected static void iterativePostorder2(Node p) {
		Stack<Node> lstack = new Stack<Node>();
		Stack<Node> rstack = new Stack<Node>();
		Node node = p, right;
		do {
			while (node != null) {
				right = node.getRight();
				lstack.push(node);
				rstack.push(right);
				node = node.getLeft();
			}
			node = lstack.pop();
			right = rstack.pop();
			if (right == null) {
				System.out.println(p.getValue());
			} else {
				lstack.push(node);
				rstack.push(null);
			}
			node = right;
		} while (lstack.size() > 0 || rstack.size() > 0);
	}

	/** 非递归实现后序遍历 单栈法 */
	protected static void iterativePostorder3(Node p) {
		Stack<Node> stack = new Stack<Node>();
		Node node = p, prev = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				stack.push(node);
				node = node.getLeft();
			}
			if (stack.size() > 0) {
				Node temp = stack.peek().getRight();
				if (temp == null || temp == prev) {
					node = stack.pop();
					System.out.println(p.getValue());
					prev = node;
					node = null;
				} else {
					node = temp;
				}
			}

		}
	}

	/** 非递归实现后序遍历4 双栈法 */
	protected static void iterativePostorder4(Node p) {
		Stack<Node> stack = new Stack<Node>();
		Stack<Node> temp = new Stack<Node>();
		Node node = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				temp.push(node);
				stack.push(node);
				node = node.getRight();
			}
			if (stack.size() > 0) {
				node = stack.pop();
				node = node.getLeft();
			}
		}
		while (temp.size() > 0) {
			node = temp.pop();
			System.out.println(p.getValue());
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.root = new Node(1);
		Node<Integer> n2 = new Node<Integer>(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
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
		System.out.print("树的前序递归遍历：");
		s.preOrderNoRecursion(s.root);
		System.out.println();
		System.out.print("树的中序递归遍历：");
		s.inOrderNoRecursion(s.root);
		System.out.println();
		System.out.print("树的后序递归遍历：");
		s.postOrderNoRecursion(s.root);
	}

}
