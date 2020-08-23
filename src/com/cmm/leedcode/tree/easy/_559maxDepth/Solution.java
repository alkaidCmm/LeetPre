package com.cmm.leedcode.tree.easy._559maxDepth;

import com.cmm.leedcode.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cmm
 * @date 2020/7/10 2:14 PM
 * @desc https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 */
public class Solution {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;

        for (Node node : root.children) {
            maxDepth = Math.max(maxDepth, maxDepth(node));
        }
        return maxDepth + 1;
    }

    public int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<Node> queue = new LinkedList();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size=queue.size();
            for(int i=0;i<size;i++){
                Node node = queue.poll();
                for (Node n : node.children) {
                    queue.add(n);
                }
            }
            depth += 1;
        }
        return depth;
    }
}
