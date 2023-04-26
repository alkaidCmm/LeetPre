package com.cmm.leetcode.backtracking.medium._022generateParenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses. For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author cmm
 * 
 */
public class GenerateParenthesis {
	/**
	 * 方法一：类似栈的模拟方式，通过递归到最后一层 1. 如果左括号数还没有用完，那么我们能继续放置左括号
	 * 2.如果已经放置的左括号数大于已经放置的右括号数，那么我们可以放置右括号 （如果放置的右括号数大于放置的左括号数，会出现不合法组合）
	 * 所以，运用dfs在每一层递归中，如果满足条件先放置左括号，如果满足条件再放置右括号
	 * 
	 * @param n
	 * @return
	 */
	public List<String> generateParenthesis1(int n) {
		List<String> result = new ArrayList<String>();
		if (n == 0)
			return result;
		dfs(result, "", n, n);
		return result;
	}

	private void dfs(List<String> result, String temp, int left, int right) {
		if (left == 0 && right == 0) {
			result.add(temp);
			return;
		}
		if (left > 0)
			dfs(result, temp + "(", left - 1, right);
		if (left < right)
			dfs(result, temp + ")", left, right - 1);
	}


	public List<String> generateParenthesis2(int n) {
		List<String> res = new ArrayList<String>();
		getParenthesis2(n, 0, 0, "", res);
		return res;
	}
	/**
	 * 方法二：总括号之和不大于2*n,左括号个数多于右括号时才可以加入右括号，递归实现
	 */
	public static void getParenthesis2(int n, int left, int right, String bf,
			List<String> res) {
		if (left < right) {
			return;
		}
		if (left + right == 2 * n) {
			if (left == n)
				res.add(bf);
			return;
		}

		getParenthesis2(n, left + 1, right, bf + "(", res);
		// System.out.println("left=" + left);
		getParenthesis2(n, left, right + 1, bf + ")", res);
		// System.out.println("left=" + left);
	}

	/*
	 * 方法三：
	 */
	public List<String> generateParenthesis3(int n) {
		List<String> result = new ArrayList<String>();
		List<String> inner = new ArrayList<String>();
		List<String> outter = new ArrayList<String>();
		if (n == 0) {
			result.add("");
			return result;
		}
		if (n == 1) {
			result.add("()");
			return result;
		}
		for (int i = 0; i < n; i++) {
			inner = generateParenthesis3(i);
			outter = generateParenthesis3(n - i - 1);
			System.out.println(i + "。。。。inner.size=" + inner.size()
					+ ",outer.size=" + outter.size());
			for (int j = 0; j < inner.size(); j++) {
				for (int k = 0; k < outter.size(); k++) {
					result.add("(" + inner.get(j) + ")" + outter.get(k));
					System.out.println("(" + inner.get(j) + ")" + outter.get(k));
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("------------1--------");
		System.out.println(new GenerateParenthesis().generateParenthesis1(3));
		System.out.println("------------2--------");
		System.out.println(new GenerateParenthesis().generateParenthesis2(3));
		System.out.println("------------3--------");
		System.out.println(new GenerateParenthesis().generateParenthesis3(3));

	}
}
