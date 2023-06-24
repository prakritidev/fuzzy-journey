package com.prakritidev.verma.executorService;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.prakritidev.verma.ThreadPool.ThreadPool;

public class ExecutorServiceExample {
    
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(newRunnable("Task 1"));
        executorService.execute(newRunnable("Task 2"));
        executorService.execute(newRunnable("Task 2"));

        

        // Example 1
        int corePoolSize = 1;
        int maxPoolSize = 10;
        long keepAlive = 2000;
        ExecutorService threadPoolExecutor =  new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAlive, TimeUnit.SECONDS, new ArrayBlockingQueue<>(128));

        threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(56);
        threadPoolExecutor.execute(newRunnable("Task 1.1"));
        threadPoolExecutor.execute(newRunnable("Task 1.2"));
        threadPoolExecutor.execute(newRunnable("Task 1.3"));

        // example 2: sumbit method 
        System.out.println("Example 2: " + "\n");
        Future<?> future = executorService.submit(newCallable("Task submit callable: 1.1"));

        System.out.println(future.isDone());
        try {
            String result = (String) future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        }

        // examle 3: Collection of task, whenever any one is executed successfully all ther tasks will be terminated. 
        // use case: fetch and find, calling multiple services and the fastest response will be considered. 

        System.out.println("Example 3: " + "\n");
        List<Callable<String>> callableList = new ArrayList<>();

        callableList.add(newCallable("Task 10"));
        callableList.add(newCallable("Task 20"));
        callableList.add(newCallable("Task 30"));

        try {
            String result = (String) executorService.invokeAny(callableList);
            System.out.println(result);
        } catch (Exception e) {   
        }

        executorService.shutdown();
    }

    private static Callable newCallable(String string) {
        return () -> {
        String processName = Thread.currentThread().getName() + ":" + string;
        return processName;
    };
        
    }

    private static Runnable newRunnable(String string) {

        return new Runnable() {

            @Override
            public void run() {

                String processName = Thread.currentThread().getName() + ":" + string; 
                System.out.println(processName);
            }
            
        };
    }

     
}
