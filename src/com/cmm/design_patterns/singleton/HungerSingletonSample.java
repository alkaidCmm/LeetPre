package com.cmm.design_patterns.singleton;

public class HungerSingletonSample {

    private static HungerSingletonSample instance =new HungerSingletonSample();

    private HungerSingletonSample(){

    }

    public static HungerSingletonSample getInstance(){
        return instance;
    }
}
