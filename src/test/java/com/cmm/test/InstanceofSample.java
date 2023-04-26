package com.cmm.test;

/**
 * @description:
 * @author: cmm
 * @date: 2023/4/23
 **/
public class InstanceofSample {

    public static void test(Object value) {
        // 转换并申请了一个新的变量，极大地方便了代码的编写
        if (value instanceof String v) {
            System.out.println("遇到一个String类型" + v.toUpperCase());
        } else if (value instanceof Integer v) {
            System.out.println("遇到一个整型类型" + v.longValue());
        }
        // 旧式写法
        if (value instanceof String) {
            String v = (String) value;
            System.out.println("遇到一个String类型" + v.toUpperCase());
        } else if (value instanceof Integer) {
            Integer v = (Integer) value;
            System.out.println("遇到一个整型类型" + v.longValue());
        }
    }
}
