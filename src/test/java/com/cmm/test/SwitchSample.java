package com.cmm.test;

/**
 * @description:
 * @author: cmm
 * @date: 2023/4/23
 **/
public class SwitchSample {
    /**
     * 在JDK8中获取switch返回值方式
     */
    public static String getWeek(int i) {
        String res;

        switch (i) {
            case 1:
                res = "1";
                break;
            case 2:
                res = "2";
                break;
            case 3:
                res = "3";
                break;
            case 4:
                res = "4";
                break;
            case 5:
                res = "5";
                break;
            default:
                res = "0";
                break;
        }

        return res;
    }


    /**
     * 在JDK17中获取switch返回值
     */
    public static String getWeek2(Integer i) {
        return switch (i) {
//            case null->"99";
            case 1 -> "1";
            case 2 -> "2";
            case 3 -> {
                yield "3";
            }
            case 4 -> "4";
            case 5 -> "5";
            default -> "0";
        };
    }
}
