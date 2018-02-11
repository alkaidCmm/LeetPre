package com.cmm.leedcode.array.palindromeNumber009;

/**
 * Determine whether an integer is a palindrome. Do this without extra space
 * 判断整数是否回文
 *
 * @author cmm
 */
public class PalindromeNumber {
    public boolean isPalindromeNumber(int num) {
        if (num < 0) {
            return false;
        } // 对于负数，不会出现回文
        // 计算整数位数
        int x = 1;
        while (num / x > 10) {
            x *= 10;
        }
        /**
         * 即只剩下一位时，跳出循环
         */
        while (x != 1) {
            int left = num / x;
            int right = num % 10;
            if (left != right) {
                return false;
            }
            // 去掉首位回文的数字，比如78987  去掉之后我898
            num = (num % x) / 10;
            x /= 100;
        }
        return true;
    }


    public boolean isPalindromeNumber2(int num) {
        long n = num;
        long new_n = 0;
        while (n != 0) {
            new_n = new_n * 10 + n % 10;
            n /= 10;
        }
        return new_n == num;
    }

    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println(pn.isPalindromeNumber2(78987));

    }

}
