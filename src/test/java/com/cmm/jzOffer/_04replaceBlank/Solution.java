package com.cmm.jzOffer._04replaceBlank;

import java.util.Arrays;

/**
 * 实现一个函数把字符串中的空格替换成%20
 * 
 * @author cmm
 *
 */
public class Solution {
	/**
	 * 
	 * @param str
	 * @return
	 */
	public String replaceBlank(String str) {
		char[] strOld = str.toCharArray();
		char[] strNew = new char[100];// 新数组，保存数组信息
		for (int i = 0; i < strOld.length; i++)
			strNew[i] = strOld[i];

		int blank = 0;
		for (int i = 0; i < strNew.length - 1; i++) {
			if (strNew[i] == ' ')
				blank++;// 求出数组中的空格数量
		}
		int m = strOld.length - 1;// 两个指针，
		int n = strOld.length + 2 * blank - 1;// 新的数组长度
		// 从后往前替换
		while (m >= 0 && n >= 0) {
			if (strNew[m] != ' ')
				strNew[n--] = strNew[m];
			else {
				strNew[n--] = '0';
				strNew[n--] = '2';
				strNew[n--] = '%';
			}
			m--;
		}
		return new String(strNew).trim();
	}

	public String replaceBlank_v2(String str) {
		int blank=0;
		for(int i=0;i<str.length()-1;i++){
			if(' '==str.charAt(i)){
				blank++;
			}
		}

		int newLength=str.length()+blank*2-1;

		char[] newStr=new char[newLength];

		int oldIndex=0;
		int newIndex=0;
		while(oldIndex<str.length()-1&&newIndex<newLength){
			if(str.charAt(oldIndex)!=' '){
				newStr[newIndex++]=str.charAt(oldIndex);
			}else{
				newStr[newIndex++]='%';
				newStr[newIndex++]='2';
				newStr[newIndex++]='0';
			}
			oldIndex++;
		}

		return Arrays.toString(newStr);

	}

	public static void main(String[] args) {
		String str = "we are very happy.";
		System.out.println(new Solution().replaceBlank(str));
	}
}
