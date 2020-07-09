package com.cmm.leedcode.tree._589preorder;

import com.cmm.leedcode.tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author cmm
 * @date 2020/7/9 8:01 PM
 * @desc https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 */
public class Solution {

    List<Integer> ret=new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root==null){
            return ret;
        }
        ret.add(root.val);
        for(Node node:root.children){
            preorder(node);
        }
        return  ret;
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node= stack.pop();
            result.add(node.val);
            // 栈数据先进后出
            for(int i=node.children.size()-1;i>=0;i--){
                stack.push(node.children.get(i));
            }
        }

        return result;
    }



}

