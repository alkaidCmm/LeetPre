package com.cmm.leetcode.graph._133CloneGraph;

/**
 * Created by cmm on 2017/8/27.
 */

import java.util.*;

/**
 * Clone Graph
 */
public class Solution {


    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    /**
     * BFS
     *
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (null == node) {
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

        UndirectedGraphNode head = new UndirectedGraphNode(node.label);

        return null;
    }
}
