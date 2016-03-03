package com.cmm.leedcode.validParentheses020;

import java.util.Stack;

/**
 * 判定括号的有效性
 * 
 * @author cmm
 * 
 */
public class Valid_Parentheses {
	// 这里存在其他字符比如数字，字母照样可以使用
	public boolean isVaildParentheses(String str) {
		if (str.length() == 0)
			return true;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i <= str.length() - 1; i++) {
			// System.out.println("str["+i+"]="+str.charAt(i));
			if (str.charAt(i) == '(')
				stack.push('(');
			else if (str.charAt(i) == '[')
				stack.push('[');
			else if (str.charAt(i) == '{')
				stack.push('{');
			else {
				// System.out.println(stack.size());
				if (stack.empty())
					return false;
				else if (str.charAt(i) == ')' && stack.peek() == '(') {
					stack.pop();
					// System.out.println(i + ":(匹配");
				} else if (str.charAt(i) == ']' && stack.peek() == '[') {
					stack.pop();
					// System.out.println(i + ":[匹配");
				} else if (str.charAt(i) == '}' && stack.peek() == '{') {
					stack.pop();
					System.out.println(i + ":{匹配");
				}
			}
		}
		if (!stack.empty())
			return false;
		return true;
	}

	/**
	 * 这里的判断仅包含括号，不包含其他类型字符比如数字、字母的字符串的判断
	 * 
	 * @param str
	 * @return
	 */
	public boolean isVaild(String str) {
		if (str.length() == 0)
			return true;
		if (str.length() % 2 != 0)
			return false;
		System.out.println("111");
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '{')
				stack.push('}');
			else if (str.charAt(i) == '[')
				stack.push(']');
			else if (str.charAt(i) == '(')
				stack.push(')');
			else if (stack.empty() || stack.peek() != str.charAt(i))
				return false;
			else
				stack.pop();
		}
		return stack.empty();
	}

	public boolean isVaild2(String str) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < str.length(); i++) {
			int pos = "(){}[]".indexOf(str.substring(i, i + 1));
			System.out.println(pos);
			if (pos % 2 == 1) {
				if (stack.empty() || stack.pop() != pos - 1)
					return false;
			}else//将({[入栈
				stack.push(pos);
		}
		return stack.empty();
	}

	public static void main(String[] args) {
		// System.out.println(new Valid_Parentheses()
		// .isVaildParentheses("{[(8)]76}"));
		System.out.println(new Valid_Parentheses().isVaild2("{{}[]()}"));

	}

}
