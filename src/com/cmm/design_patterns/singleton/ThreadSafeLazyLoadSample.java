package com.cmm.design_patterns.singleton;

public class ThreadSafeLazyLoadSample {
    private volatile static ThreadSafeLazyLoadSample instance;

    private ThreadSafeLazyLoadSample() {
        if (instance != null) {
            throw new IllegalStateException("already init");
        }
    }

    public static synchronized ThreadSafeLazyLoadSample getInstance() {
        // 线程A和线程B同时看到singleton = null，如果不为null，则直接返回singleton
        if (instance == null) {
            // 线程A或线程B获得该锁进行初始化
            synchronized (ThreadSafeLazyLoadSample.class) {
                if (instance == null) {
                    // 其中一个线程进入该分支，另外一个线程则不会进入该分支
                    instance = new ThreadSafeLazyLoadSample();
                }
            }
        }

        return instance;
    }
}
