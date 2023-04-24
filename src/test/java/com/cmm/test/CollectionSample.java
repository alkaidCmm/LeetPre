package com.cmm.test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: cmm
 * @date: 2023/4/23
 **/
public class CollectionSample {

    public static void main(String[] args) {

        // 定义一个set，用guava
        Set set= ImmutableSet.of(1,2,3,4,5,6,7);
        List list= ImmutableList.of(1,2,3,4);
        Map map= ImmutableMap.of("cmm",1,"zyy",1,"jc",1);

        // java 17
        Set set2=Set.of(1,2,3,4,5);
        List list2=List.of(1,2,3);
        Map map2= Map.of("cmm",1,"zyy",1,"jc",1);


    }
}
