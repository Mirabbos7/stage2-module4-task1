package com.mjc.stage2;

public class ThreadSafeSingleton {
    public static ThreadSafeSingleton instance = null;
    private ThreadSafeSingleton() {}
    public static ThreadSafeSingleton getInstance(){
        if(instance == null){
            synchronized (ThreadSafeSingleton.class){
                if(instance == null){
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
