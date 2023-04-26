package com.cmm.leetcode._412fuzzbuzz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cmm
 * @date 2020/6/20 10:49 AM
 * @desc Write a program that outputs the string representation of numbers from 1 to n.
 * <p>
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 * <p>
 * Example:
 * <p>
 * n = 15,
 * <p>
 * Return:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 */
public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ret=new ArrayList();
        for(int i=1;i<=n;i++){
            boolean isThreeRange = i%3==0;
            boolean isFiveRange = i%5==0;
            if(isThreeRange&&isFiveRange){
                ret.add("FizzBuzz");
            }else if(isThreeRange){
                ret.add("Fizz");
            }else if(isFiveRange){
                ret.add("Buzz");
            }else{
                ret.add(String.valueOf(i));
            }
        }
        return ret;
    }
}
