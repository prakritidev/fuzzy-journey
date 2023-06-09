package com.prakritidev.verma.ThreadLocal;

public class ThreadLocalLaztInit {
    
    public static void main(String[] args) {
        
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        String value = threadLocal.get();

        if(value==null){
            threadLocal.set("Lazy Set");
            value = threadLocal.get();
        }

        System.out.println(value);
    }
}
