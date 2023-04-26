package com.cmm.jzOffer._22StackPushPopOrder;

import java.util.*;

/**
 * 栈的压入，弹出序列
 *
 * @author cmm 题目：输入两个整数序列，第一个列表示栈的压入顺序，判断第二个序列是否为栈的弹出序列
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("第一组测试数据：");
        int pushOrder[] = {1, 2, 3, 4, 5};
        int popOrder[] = {4, 5, 3, 2, 1};
        System.out.println(s.isPopOrder2(pushOrder, popOrder));

        System.out.println("第二组数据：");
        int pushOrder2[] = {1, 2, 3, 4, 5};
        int popOrder2[] = {4, 3, 5, 2, 1};
        System.out.println(s.isPopOrder(pushOrder2, popOrder2));

        System.out.println("第三组数据：");
        int pushOrder3[] = {1, 2, 3, 4, 5};
        int popOrder3[] = {4, 5, 3};
        System.out.println(s.isPopOrder(pushOrder3, popOrder3));
    }

    public boolean isPopOrder(int pushOrder[], int popOrder[]) {
        boolean flag = false;
        // 能够执行的条件是序列不为空，而且长度相等
        if (pushOrder.length > 0 && pushOrder.length == popOrder.length) {
            //
            Stack<Integer> stackHelp = new Stack<Integer>();
            int i = 0;
            int j = 0;
            // 保证入栈序列全进入栈
            while (i < pushOrder.length) {
                // 当栈非空时，若栈顶元素与出栈元素相同，则出栈
                if (stackHelp.size() > 0 && stackHelp.peek() == popOrder[j]) {
                    stackHelp.pop();
                    j++;// 这里j作为出栈元素扫描的下标，如果相等，下标香向后移动
                } else {// 若不同或者栈非空，则在入栈序列中继续添加
                    stackHelp.push(pushOrder[i]);
                    i++;
                }
                // 此时栈中还有元素需要与出栈序列对比,即比较完之后，入栈序列数组中元素已经全部入栈了一次
            }
            while (stackHelp.size() > 0) {
                if (stackHelp.peek() == popOrder[j]) {
                    stackHelp.pop();
                    j++;
                } else
                    break;
            }
            // 最终栈是空的，而且popOrder中的所有数都遍历了，则是出栈序列
            if (stackHelp.empty() && j == popOrder.length)
                flag = true;
        }
        return flag;

    }

    /**
     * 使用一个栈来模拟压入弹出操作。
     * 每次入栈一个元素后，都要判断一下栈顶元素是不是当前出栈序列 popSequence 的第一个元素，
     * 如果是的话则执行出栈操作并将 popSequence 往后移一位，继续进行判断。
     */
    public boolean isPopOrder2(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushSequence[pushIndex]);
            while (popIndex < n && !stack.isEmpty()
                    && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }


    public boolean isPopOrder3(int[] pushSequence, int[] popSequence) {

        int length = pushSequence.length;

        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < length; pushIndex++) {
            stack.push(pushSequence[pushIndex]);

            while (popIndex < length && !stack.isEmpty() && stack.peek() == popSequence[popIndex]) {
                popIndex++;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
