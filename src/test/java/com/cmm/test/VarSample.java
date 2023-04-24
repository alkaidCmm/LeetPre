package com.cmm.test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description:
 * @author: cmm
 * @date: 2023/4/23
 **/
public class VarSample {
//    // // 类成员变量不允许使用
//    var user = "cmm";
//
//    /**
//     * 构造函数的参数定义不允许使用
//     */
//    public VarIncorrectUsage(var param) {
//    }
//
//    // catch里面不允许使用
//    try{
//    }  catch(var exception){
//    }
//
//    /**
//     * 返回类型不允许使用
//     */
//    public var returnMethod() {
//        return null;
//    }
//
//    /**
//     * 函数或者方法参数不允许使用
//     */
//    public Integer parameterMethod(var input) {
//        return null;
//    }
//
//    public String getA(){
//        //
//        val v1;
//        val v2=null;
//    }

    public static void main(String[] args) {
        var sum= IntStream.range(1,10).reduce(( x, y)->{
          return   x+y;
        });

        System.out.println(sum);

    }
}
