package com.prakritidev.verma.ThreadLocal;

public class ThreadLocalBasicExample {

  public static void main(String[] args) {
    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    Thread thread1 = new Thread(() -> {
      threadLocal.set("Thread Local 1");
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        e.printStackTrace();
      }

      String fetch = threadLocal.get();
      System.out.println(fetch);
    });

    Thread thread2 = new Thread(() -> {
      threadLocal.set("Thread Local 2");
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        e.printStackTrace();
      }

      String fetch = threadLocal.get();
      System.out.println(fetch);
    });

    thread1.start();
    thread2.start();

  }
}
