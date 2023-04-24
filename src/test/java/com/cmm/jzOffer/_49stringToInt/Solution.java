package com.cmm.jzOffer._49stringToInt;

public class Solution {
	public static int StringToInt(String num) {
		if (num == null || num.length() == 0)
			throw new NumberFormatException(num);
		char first = num.charAt(0);
		if (first == '-')
			return parseString(num, 1, false);
		else if (first == '+')
			return parseString(num, 1, true);
		else if (first >= '0' && first <= '9')
			return parseString(num, 0, true);
		else
			throw new NumberFormatException(num);
	}

	/**
	 * 
	 * @param num
	 *            需要解析的字符串
	 * @param index
	 *            开始解析的位置
	 * @param positive
	 *            解析数据的正负性
	 * @return
	 */
	private static int parseString(String num, int index, boolean positive) {
		if (index >= num.length())
			throw new NumberFormatException(num);
		int result = 0;
		long tmp = 0;
		while (index < num.length() && isDigit(num.charAt(index))) {
			tmp = tmp * 10 + num.charAt(index) - '0';
			if (tmp > 0x8000_0000L)// 不等超过最大范围
				throw new NumberFormatException(num);
			index++;
		}
		if (positive) {
			if (tmp >= 0x8000_0000L) {
				throw new NumberFormatException(num);
			} else {
				result = (int) tmp;
			}
		} else {
			if (tmp == 0x8000_0000L) {
				result = 0x8000_0000;
			} else {
				result = (int)(-tmp);
			}
		}
		return result;
	}

	/**
	 * 判定是否是数字
	 * 
	 * @param c
	 *            输入的字符
	 * @return
	 */
	private static boolean isDigit(char c) {
		return c >= '1' && c <= '9';
	}
}
