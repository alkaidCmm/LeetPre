package com.cmm.jzOffer._42reverseSentence;

public class Solution {
	// 将字节数组自定区间的字符作翻转
	public static void reverse(char[] data, int start, int end) {
		while (start < end) {
			char tmp = data[start];
			data[start] = data[end];
			data[end] = tmp;
			start++;
			end--;
		}
	}

	/**
	 * 第一题：对字符串进行倒转 Cmm is gad ,换成gad is Cmm
	 * 
	 * @param data
	 * @return
	 */
	public static char[] reverseSentence(char[] data) {
		if (data == null || data.length < 1) {
			return data;
		}
		reverse(data, 0, data.length - 1);
		int start = 0;
		int end = 0;
		while (start < data.length) {
			if (data[start] == ' ') {// 开始碰到空格
				start++;
				end++;
			} else if (end == data.length || data[end] == ' ') {
				reverse(data, start, end - 1);
				end++;
				start = end;
			} else {
				end++;
			}
		}
		return data;
	}

	public String reverseSentence(String str) {
		int n = str.length();
		char[] chars = str.toCharArray();
		int start = 0, end = 0;
		// 1.子串先反转
		while (end <= n) {
			if (end == n || chars[end] == ' ') {
				reverse(chars, start, end - 1);
				start = end + 1;
			}
			end++;
		}
		// 2 整体再反转
		reverse(chars, 0, n - 1);
		return new String(chars);
	}

	public String reverseSentence_v2(String str){
		int start=0;
		int end=0;
		char[] data=str.toCharArray();

		for(;end<str.length()-1;end++){
			if(end==str.length()-1||data[end]==' '){
				reverse(data,start,end-1);
				start=end+1;
			}
		}

		reverse(data,0,str.length()-1);

		return new String(data);
	}


	/**
	 * 题目二：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。 请定义一个函数实现字符串左旋转操作的功能。
	 * 
	 * @param data
	 * @param n
	 * @return
	 */
	public static char[] leftRotateString(char[] data, int n) {
		if (data == null || n < 0 || n > data.length) {
			return data;
		}
		reverse(data, 0, data.length - 1);
		reverse(data, 0, data.length - n - 1);
		reverse(data, data.length - n, data.length - 1);
		return data;
	}

	public static void main(String[] args) {
		String  str="I am a student.";
		new Solution().reverseSentence(str);
	}

}
