package com.cmm.leedcode.string._067addBinary;

/**
 * @author cmm
 * @date 2019/11/18 4:22 PM
 * @desc 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static String addBinary(String a, String b) {
        String ret = "";
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int aCur = i >= 0 ? a.charAt(i) - '0' : 0;
            int bCur = j >= 0 ? b.charAt(j) - '0' : 0;
            int tmp = aCur + bCur + carry;
            ret = tmp % 2 + ret;
            carry = tmp / 2;
            i--;
            j--;
        }
        if (carry == 1) {
            ret = "1" + ret;
        }
        return ret;
    }

    public static void main(String[] args) {
        String a = "111";
        String b = "11";
        String ret = addBinary(a, b);
        System.out.println(ret);
    }
}
