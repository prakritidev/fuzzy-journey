package com.prakritidev.verma.services.proxypattern;

public class ProxyMain {
    public static void main(String[] args) {
        Service serviceProxy = new ServiceOneProxy();
        serviceProxy.start();
    }
}
