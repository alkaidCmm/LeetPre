package com.cmm;

import java.util.*;

public class Test {

    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            digits[i]+=1;
            digits[i]=digits[i]%10;
            if(digits[i]!=0){
                return digits;
            }
        }

        digits= new int[digits.length+1];
        digits[0]=1;
        return digits;
    }

    public static void main(String[] args) {
        new Test().plusOne(new int[]{9,9,9});
    }


}
