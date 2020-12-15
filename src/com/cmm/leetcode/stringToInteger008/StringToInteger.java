package com.cmm.leetcode.stringToInteger008;

/**
 * 
 * @author cmm
 * 
 */
public class StringToInteger {
	/*
	 * 字符串转换成整形，比如“-1234567890”
	 */
	public int stringToInteger(String str) {
		if (str == null || str.length() < 1)
			return 0;
		str = str.trim();// 去掉字符串前缀和后缀的空白
		char flag = '+';// 默认字符串第一位是+,即为正整数
		int i = 0;// 字符串数组下标值
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+')
			i++;
		double result = 0;// 保存转换为整形的结果
		while (str.length() > i && str.charAt(i) > '0' && str.charAt(i) < '9') {
			//注意，，这里如果直接使用str.chat(i),而不减去'0'，系统默认使用对应的ascii值，减'0'会作十进制减法
			result = result * 10 + (str.charAt(i)-'0');
			i++;
		}
		if (flag == '-')
			result = -result;
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		return (int) result;
	}

	public static void main(String[] args) {
		StringToInteger sti = new StringToInteger();
		System.out.println(sti.stringToInteger("-12"));
		char c='1';
		int b=c;
		System.out.println(b);
	}
}
