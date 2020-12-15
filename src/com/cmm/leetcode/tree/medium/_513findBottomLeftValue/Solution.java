package com.cmm.leetcode.tree.medium._513findBottomLeftValue;

import com.cmm.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author caimingming02
 * @date 2020/11/2 8:39 AM
 * @desc
 */
public class Solution {

    /**
     * 从右到左执行BFS意味着我们可以简单地返回最后一个节点的值，而不必跟踪当前行中的第一个节点，甚至根本不必关心行。
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            root=queue.poll();
            if(root.right!=null){
                queue.add(root.right);
            }
            if(root.left!=null){
                queue.add(root.left);
            }
        }

        return root.val;

    }


}
