package com.prakritidev.verma.ThreadPool;

public class ThreadPoolMain {
     
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(1000,100000000);

        for(int i = 0; i < 100000000; i++){
            int taskNo = i;
            try {
                threadPool.execute(() -> {
                    String message = Thread.currentThread().getName() + ": Task" + taskNo;
                    System.out.println(message);
                    });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        threadPool.waitUntillAllTasksFinished();
        threadPool.stop();

    }
}
