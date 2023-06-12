package com.prakritidev.verma.JavaLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocalExample {

    public static void main(String[] args) {
        
        Lock lock = new ReentrantLock();

        lock.lock();
        
        lock.unlock();
    }
}
