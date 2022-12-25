package com.prakritidev.verma.services.proxypattern;

public class ServiceOneProxy extends ServiceOneImpl {

    @Override
    public void start() {
        // TODO Auto-generated method stub
        System.out.println("Delegating calls to actual service");
        super.start();
    }

    
    
    
    
}
