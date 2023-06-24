package com.prakritidev.verma.executorService;

import java.nio.channels.CancelledKeyException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        try {
            executorService.awaitTermination(3000L, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ==== Example 1 ======
        Future future = executorService.submit(newCallable("Task 1.1"));
        System.out.println(future.isDone());

        boolean mayInterrupt = true;
        future.cancel(mayInterrupt);

        try {
            String result = (String) future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
        } catch (ExecutionException e){
        } catch (CancelledKeyException e) {
            String msg = "Cannot call future.get()";
            System.out.println(msg); 
        }

        System.out.println(future.isDone());
        System.out.println(future.isCancelled());

        

        executorService.shutdown();
        List<Runnable> runnables = executorService.shutdownNow();

    }

    private static Callable newCallable(String string) {
        return () -> {
            return Thread.currentThread().getName() + ":" + string;

        };
    }
}
