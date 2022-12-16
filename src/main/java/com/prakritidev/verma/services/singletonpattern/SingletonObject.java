package com.prakritidev.verma.services.singletonpattern;

public class SingletonObject {
    
    private static SingletonObject instance = new SingletonObject();
    
    private SingletonObject() {
    }

    public static SingletonObject getInstance() {
        return instance;
    }

    public void getMessages() {
        System.out.println("YUP! SINGLETON HERE");
    }
}
