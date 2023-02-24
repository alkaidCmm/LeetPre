package com.cmm.jzOffer._06constructBinaryTree;

/**
 * 通过前序和中序确定后序
 * 
 * @author cmm
 *
 */
public class Solution {
	public BinaryTreeNode constructBinaryTree(int preOrder[], int inOrder[]) {
		BinaryTreeNode root = new BinaryTreeNode(preOrder[0]);
		root.setLeft(null);
		root.setRight(null);
		int leftNum = 0;// 左子树的节点个数
		for (int i = 0; i < inOrder.length - 1; i++) {// 找到根结点
			if (inOrder[i] == root.getValue())
				break;
			else
				leftNum++;
		}
		int rightNum = inOrder.length - 1 - leftNum;// 右子树的节点个数

		// 左子树不为空，
		if (leftNum > 0) {
			int leftPreOrder[] = new int[leftNum];
			int leftInOrder[] = new int[leftNum];
			for (int i = 0; i < leftNum; i++) {
				leftPreOrder[i] = preOrder[i + 1];
				leftInOrder[i] = inOrder[i];
			}
			BinaryTreeNode leftRoot = constructBinaryTree(leftPreOrder,
					leftInOrder);
			root.setLeft(leftRoot);
		}
		if (rightNum > 0) {
			int rightPreOrder[] = new int[rightNum];
			int rightInOrder[] = new int[rightNum];
			for (int i = 0; i < rightNum; i++) {
				rightPreOrder[i] = preOrder[i + 1 + leftNum];
				rightInOrder[i] = inOrder[i + 1 + leftNum];
			}
			BinaryTreeNode rightRoot = constructBinaryTree(rightPreOrder,
					rightInOrder);
			root.setRight(rightRoot);
		}
		return root;
	}

	public BinaryTreeNode constructBinaryTree_v2(int preOrder[], int inOrder[]){
		BinaryTreeNode root=new BinaryTreeNode(preOrder[0]);

		int numLeft=0;
		for(int i=0;i<inOrder.length-1;i++){
			if(inOrder[i]==root.getValue()){
				break;
			}
			numLeft++;
		}
		int numRight= inOrder.length-numLeft-1;

		if(numLeft>0){
			int[] leftPreOrder=new int[numLeft];
			int[] leftInOrder=new int[numLeft];
			for(int i=0;i<numLeft-1;i++){
				leftPreOrder[i]=preOrder[i+1];
				leftInOrder[i]=inOrder[i];
			}

			BinaryTreeNode leftRoot=constructBinaryTree_v2(leftPreOrder,leftInOrder);
			root.setLeft(leftRoot);
		}

		if(numRight>0){
			int[] rightPreOrder=new int[numRight];
			int[] rightInOrder=new int[numRight];
			for(int i=0;i<numRight-1;i++){
				rightPreOrder[i]=preOrder[i+numLeft+1];
				rightInOrder[i]=inOrder[i+numLeft+1];
			}

			BinaryTreeNode rightRoot=constructBinaryTree_v2(rightPreOrder,rightInOrder);
			root.setLeft(rightRoot);
		}

		return root;
	}

	/**
	 * 后序遍历
	 * 
	 * @param root
	 */
	public void printPostOrder(BinaryTreeNode root) {
		if (root != null) {
			printPostOrder(root.getLeft());
			printPostOrder(root.getRight());
			System.out.println(root.getValue());
		}
	}

	public static void main(String[] args) {
		int preOrder[] = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int inOrder[] = { 4, 7, 2, 1, 5, 3, 8, 5 };
		Solution s = new Solution();
		BinaryTreeNode root = s.constructBinaryTree(preOrder, inOrder);
		s.printPostOrder(root);
	}
}
