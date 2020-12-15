package com.cmm.leetcode.string._012integerToRoman;

import java.util.HashMap;
import java.util.Map;

/**
 * 【题目】
 * <p>
 * Given a roman numeral, convert it to an integer. Or, Given an integer,
 * convert it to a roman numeral. Input is guaranteed to be within the range
 * from 1 to 3999. 【罗马数字】
 * <p>
 * 1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
 * <p>
 * 10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
 * <p>
 * 100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
 * <p>
 * 1000~3000: {"M", "MM", "MMM"}.
 *
 * @author cmm
 */
public class IntegerAndRoman {
    public String integerToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] Romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
                "IX", "V", "IV", "I"};
        String sb = "";
        for (int i = 0; i < values.length; i++) {// i < values.length
            while (num >= values[i]) {
                num -= values[i];
                sb += Romans[i];
            }
        }
        return sb;
    }

    public int romanToInteger(String romanStr) {
        char[] roman = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] num = {1, 5, 10, 50, 100, 500, 1000};
        int result = 0;
        Map<Character, Integer> romToInt = new HashMap<Character, Integer>();
        for (int i = 0; i < roman.length ; i++) {
            romToInt.put(roman[i], num[i]);
        }
        //第一个字符对应的值
        result = romToInt.get(romanStr.charAt(0));

        for (int i = 1; i < romanStr.length(); i++) {
            int cur = romToInt.get(romanStr.charAt(i));
            //获取前一个字符的对应值
            int pre = romToInt.get(romanStr.charAt(i - 1));
            if (cur <= pre) {
                result += cur;
            } else {
                result += (cur - 2 * pre);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        IntegerAndRoman itr = new IntegerAndRoman();
//		System.out.println(itr.integerToRoman(1000));
        System.out.println(itr.romanToInteger("MCMXCIV"));
    }

}
