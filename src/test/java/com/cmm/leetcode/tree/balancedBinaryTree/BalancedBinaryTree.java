package com.cmm.leetcode.tree.balancedBinaryTree;

/**
 * 平衡二叉树
 *
 * @author cmm
 */
public class BalancedBinaryTree {
    private BinaryTreeNode root;
    private String buildType = "";

    /**
     * 只是插入节点，暂时不对平衡性进行处理
     *
     * @param node  根节点
     * @param value 需要添加节点的值
     * @return 插入的节点
     */
    public BinaryTreeNode addNode(BinaryTreeNode node, int value) {
        BinaryTreeNode subNode = null;
        if (node.getValue() > value) {
            if (node.getLeftNode() == null) {
                subNode = new BinaryTreeNode(value);
                node.setLeftNode(subNode);
            } else {
                subNode = addNode(node.getLeftNode(), value);
            }
        }
        if (node.getValue() < value) {
            if (node.getRightNode() == null) {
                subNode = new BinaryTreeNode(value);
                node.setRightNode(subNode);
            } else {
                subNode = addNode(node.getRightNode(), value);
            }
        }
        return subNode;
    }

    /**
     * 对二叉树平衡性进行处理
     *
     * @param node
     */
    public void reBuild(BinaryTreeNode node) {

    }

    private BinaryTreeNode findTempRootNode(BinaryTreeNode node) {
        BinaryTreeNode noB = getNoBalance(node);//获取node最相近的根节点，他是第一个使是不平衡的根节点
        if (noB == null) {
            return null;
        }
        if (isTypeLL(noB)) {
            buildType = "ll";
        } else if (isTypeRR(noB)) {
            buildType = "rr";
        } else if (isTypeLR(noB)) {
            buildType = "lr";
        } else if (isTypeRL(noB)) {
            buildType = "rl";
        }
        return noB;
    }

    //左左类型
    private boolean isTypeLL(BinaryTreeNode noB) {
        try {
            if (noB.getRightNode() == null && noB.getLeftNode().getRightNode() == null && !noB.getLeftNode().getLeftNode().hasSubNode()) {
                return true;
            }
            if (noB.getRightNode() != null && noB.getLeftNode().getRightNode() != null && noB.getLeftNode().getLeftNode().hasSubNode()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    //右右类型
    private boolean isTypeRR(BinaryTreeNode noB) {
        try {
            if (noB.getLeftNode() == null && noB.getRightNode().getLeftNode() == null && !noB.getRightNode().getRightNode().hasSubNode()) {
                return true;
            }
            if (noB.getLeftNode() != null && noB.getRightNode().getLeftNode() != null && noB.getRightNode().getRightNode().hasSubNode()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    //左右类型
    private boolean isTypeLR(BinaryTreeNode noB) {
        try {
            if (noB.getRightNode() == null && noB.getLeftNode().getLeftNode() == null && !noB.getLeftNode().getRightNode().hasSubNode()) {
                return true;
            }
            if (noB.getRightNode() != null && noB.getLeftNode().getLeftNode() != null && noB.getLeftNode().getRightNode().hasSubNode()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    //右左类型
    private boolean isTypeRL(BinaryTreeNode noB) {
        try {
            if (noB.getLeftNode() == null && noB.getRightNode().getRightNode() == null && !noB.getRightNode().getLeftNode().hasSubNode()) {
                return true;
            }
            if (noB.getLeftNode() != null && noB.getRightNode().getRightNode() != null && noB.getRightNode().getLeftNode().hasSubNode()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * 求【当前根节点】的深度
     *
     * @param node
     * @return
     */
    public static int depth(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int ld = depth(node.getLeftNode());
            int rd = depth(node.getRightNode());
            return 1 + (ld > rd ? ld : rd);
        }
    }

    /**
     * 判定【当前根节点】的平衡性
     *
     * @param node
     * @return
     */
    public static boolean isBalance(BinaryTreeNode node) {
        if (node == null)// 如果根节点为空，肯定平衡
            return true;
        int dis = depth(node.getLeftNode()) - depth(node.getRightNode());// 求node下左右子树的深度之差
        if (dis > 1 || dis < -1)
            return false;
        else// 如果满足要求，继续求左子树的左子树。。。的平衡性和右子树的右子树。。。的平衡性
            return isBalance(node.getLeftNode())
                    && isBalance(node.getRightNode());
    }

    /**
     * 获取不平衡的【最相近的根节点】
     *
     * @param node
     * @return
     */
    private BinaryTreeNode getNoBalance(BinaryTreeNode node) {
        if (node.getParentNode() == null) {
            return null;
        } else {
            if (!isBalance(node.getParentNode())) {
                return node.getParentNode();
            } else {
                return getNoBalance(node.getParentNode());
            }
        }
    }
}
