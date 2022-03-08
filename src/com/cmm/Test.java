package com.cmm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test {

    public static int removeElement(int[] nums, int val) {
        int ret=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[ret++]=nums[i];
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        removeElement(new int[]{0,1,2,2,3,0,4,2},2);
    }

    class MinStack {
        Stack<Integer> data;
        Stack<Integer> min;

        public MinStack() {
            data=new Stack<>();
            min=new Stack<>();
        }

        public void push(int val) {
            if(min.isEmpty()){
                min.push(val);
            }
            else if(min.peek()>val){
                min.push(val);
            }
            data.push(val);
        }

        public void pop() {
            if(data.isEmpty()){
                throw new RuntimeException("pop Your stack is empty.");
            }
            int value=data.pop();
            if(value==min.peek()){
                min.pop();
            }
        }
        // 实际栈顶数据
        public int top() {
            if(data.isEmpty()){
                throw new RuntimeException("top Your stack is empty.");
            }
            return data.peek();
        }

        // 最小栈顶数据
        public int getMin() {
            if(min.isEmpty()){
                throw new RuntimeException("getMin Your stack is empty.");
            }
            return min.peek();
        }
    }
}
