package com.cmm.leedcode.zigzagConversion006;

public class ZigZagConversion {

	/**
	 * 
	 * @param str
	 *            需要转换的字符串
	 * @param nRows
	 *            转换时的行数
	 * @return
	 */
	public String zigzagConversion(String str, int nRows) {
		int n = str.length();
		if (n <= 1 || nRows == 1)
			return str;
		char strArray[] = str.toCharArray();
		String result = "";
		int lag = 2 * nRows - 2;// 每一行循环最左边和最右边的字符的距离
		for (int i = 0; i < nRows; i++) {
			for (int j = i; j < n; j += lag) {
				// 首行跟尾行
				result += strArray[j];
				// 非首行和尾行
				if (i > 0 && i < nRows-1) {
					int t = j + lag - 2 * i;
					if (t < n)
						result += strArray[t];
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ZigZagConversion zzc = new ZigZagConversion();
		String s = zzc.zigzagConversion("0123456789", 4);
		System.out.println("s=" + s);

	}

}
