package com.cmm.design_patterns.singleton;

public class SingletonSample {

    private static volatile SingletonSample instance;

    private SingletonSample(){

    }

    public SingletonSample getInstance(){
        if(instance==null){
            synchronized (instance){
                if(instance==null){
                    instance= new SingletonSample();
                }
            }
        }

        return instance;
    }
}
