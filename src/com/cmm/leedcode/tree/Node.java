package com.cmm.leedcode.tree;

import java.util.List;

/**
 * @author cmm
 * @date 2020/7/9 8:02 PM
 * @desc
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
