package com.cmm.design_patterns.singleton;

public class ThreadSafeDoubleCheckLockSample {

    private volatile static ThreadSafeDoubleCheckLockSample instance;

    private ThreadSafeDoubleCheckLockSample(){
        if(instance !=null){
            throw new IllegalStateException("already init");
        }
    }

    public static ThreadSafeDoubleCheckLockSample getInstance(){
        var result=instance;
        if(result == null){
            synchronized (ThreadSafeDoubleCheckLockSample.class){
                result =instance;
                if(result == null){
                    result = instance = new ThreadSafeDoubleCheckLockSample();
                }
            }
        }

        return  result;
    }
}
