package com.prakritidev.verma.services.singletonpattern;

public class SingletonPatternMain {
    public static void main(String[] args) {
        SingletonObject singletonObject = SingletonObject.getInstance();
        singletonObject.getMessages();
    }
}
