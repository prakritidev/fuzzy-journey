package com.prakritidev.verma.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {

  private BlockingQueue<Runnable> taskQueue = null;
  private List<PoolThreadRunnable> runnables = new ArrayList();
  private Boolean isStopped = false;

  public ThreadPool(int noOfThread, int maxNoOfTasks) {
    this.taskQueue = new ArrayBlockingQueue(maxNoOfTasks);
    
    for(int i = 0; i <noOfThread; i++){
        PoolThreadRunnable poolThreadRunnable = new PoolThreadRunnable(taskQueue);
        this.runnables.add(poolThreadRunnable);
    }
    for(PoolThreadRunnable runnable: runnables){
        new Thread(runnable).start();
    }
  }

  public synchronized void execute(Runnable runnable) throws Exception{
    if(this.isStopped) throw
        new IllegalStateException("ThreadPool is Stopped");
    this.taskQueue.offer(runnable);
  }

  public synchronized void stop(){
    this.isStopped = true;
    for(PoolThreadRunnable runnable : runnables){
        runnable.doStop();
    }
  }

  public synchronized void waitUntillAllTasksFinished(){
    while(this.taskQueue.size() > 0){
        try {
            Thread.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  }
}
