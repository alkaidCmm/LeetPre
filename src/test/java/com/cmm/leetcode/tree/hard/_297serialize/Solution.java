package com.cmm.leetcode.tree.hard._297serialize;

import com.cmm.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "[]";
        }
        StringBuilder sb= new StringBuilder();
        sb.append("[");
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode cur= q.poll();
            if(cur!=null){
                q.add(cur.left);
                q.add(cur.right);
                sb.append(cur.val).append(",");
            }else{
                sb.append("null,");
            }
        }
        // 删除最后一个,
        sb.deleteCharAt(sb.length()-1);

        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0 ||data.equals("[]")){
            return null;
        }
        // 截取 数字部分，并基于“,”进行split
        String[] res=data.substring(1,data.length()-1).split(",");
        TreeNode root=new TreeNode(Integer.parseInt(res[0]));
        Queue<TreeNode> q= new LinkedList();
        q.add(root);
        int index=1;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(!res[index].equals("null")){
                cur.left= new TreeNode(Integer.parseInt(res[index]));
                q.add(cur.left);
            }
            index++;
            if(!res[index].equals("null")){
                cur.right=new TreeNode(Integer.parseInt(res[index]));
                q.add(cur.right);
            }
            index++;

        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        System.out.println(new Solution().serialize(n1));;
        System.out.println();
        TreeNode ret = new Solution().deserialize("[1,2,3,4,5,6,7]") ;

        int[] nums=new int[]{1,2,3,4,5,6,7};
        System.out.println(ret);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

