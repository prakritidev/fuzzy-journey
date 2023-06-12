package com.prakritidev.verma.JavaLock;

public class CounterSynchronized {
    
    private long count;

    public synchronized void inc() {
        this.count++;
    }

    public synchronized long getCount() {
        return this.count;
    }
}
