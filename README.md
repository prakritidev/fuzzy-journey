# My Learning Journey


1. Play with REST APIs
2. Play with Data Structure
   1. Dynamic Programming
         1. 0-1 Knapsack problem 
         2. Coin change problem 
         3. Shortest common subsequence
         4. Longest common subsequence
         5. Longest increasing subsequence
         6. Matrix chain manipulation
         7. Partition problem
         8. Rod cutting
         9. Edit distance problem (Levenshtein)
         10. Word break problem
         11. Fibonacci Series problem
3. Play with Java internals 
4. Play with Spring Boot internals
5. Play with websocket
6. Play with WebRTC
7. Play with Elasticsearch
8. Play with Machine Learning
9. Play with Design Patterns

---

# Java Multithreading: Concepts & Code Examples

This project contains several practical examples of Java multithreading, thread pools, synchronization, and thread-local storage. Below is a comprehensive tutorial referencing the code in this repository.

## 1. Introduction to Multithreading in Java
Multithreading allows concurrent execution of two or more threads for maximum utilization of CPU. Java provides built-in support for multithreaded programming.

## 2. Basic Thread Usage
The simplest way to create a thread is by instantiating the `Thread` class. See [`LearnigSpringJavaDataStructuresApplication.java`](src/main/java/com/prakritidev/verma/LearnigSpringJavaDataStructuresApplication.java):

```java
Thread thread = new Thread();
thread.start();
```

This starts a new thread, but real work is usually done by passing a `Runnable` or `Callable`.

## 3. Custom Thread Pool Implementation
Thread pools manage a set of worker threads to execute tasks efficiently. See [`ThreadPool.java`](src/main/java/com/prakritidev/verma/ThreadPool/ThreadPool.java), [`ThreadPoolMain.java`](src/main/java/com/prakritidev/verma/ThreadPool/ThreadPoolMain.java), and [`PoolThreadRunnable.java`](src/main/java/com/prakritidev/verma/ThreadPool/PoolThreadRunnable.java):

- `ThreadPool` creates a pool of threads and a task queue.
- `PoolThreadRunnable` is the worker that takes tasks from the queue and runs them.
- `ThreadPoolMain` demonstrates submitting many tasks to the pool.

**Key snippet:**
```java
ThreadPool threadPool = new ThreadPool(1000, 100000000);
threadPool.execute(() -> {
    String message = Thread.currentThread().getName() + ": Task" + taskNo;
    System.out.println(message);
});
```

## 4. ExecutorService and Advanced Thread Pooling
Java's `ExecutorService` framework is a robust, production-ready thread pool implementation. See [`ExecutorServiceExample.java`](src/main/java/com/prakritidev/verma/executorService/ExecutorServiceExample.java) and [`ExecutorServiceExample2.java`](src/main/java/com/prakritidev/verma/executorService/ExecutorServiceExample2.java):

- Create a thread pool: `Executors.newFixedThreadPool(3)`
- Submit tasks with `execute()` or `submit()`
- Use `Future` to get results or check completion
- Use `invokeAny()` to get the result of the fastest task

**Key snippet:**
```java
ExecutorService executorService = Executors.newFixedThreadPool(3);
Future<?> future = executorService.submit(newCallable("Task submit callable: 1.1"));
String result = (String) future.get();
```

## 5. ThreadLocal for Thread Confinement
`ThreadLocal` provides variables that each thread has independently. See [`ThreadLocalBasicExample.java`](src/main/java/com/prakritidev/verma/ThreadLocal/ThreadLocalBasicExample.java) and [`ThreadLocalLaztInit.java`](src/main/java/com/prakritidev/verma/ThreadLocal/ThreadLocalLaztInit.java):

- Each thread gets its own value, avoiding synchronization.

**Key snippet:**
```java
ThreadLocal<String> threadLocal = new ThreadLocal<>();
threadLocal.set("Thread Local 1");
String fetch = threadLocal.get();
```

## 6. Synchronization and Locks
To avoid race conditions, Java provides `synchronized` and explicit locks.

- [`CounterSynchronized.java`](src/main/java/com/prakritidev/verma/JavaLock/CounterSynchronized.java): Uses `synchronized` methods.
- [`CounterLock.java`](src/main/java/com/prakritidev/verma/JavaLock/CounterLock.java): Uses `ReentrantLock` for explicit locking.
- [`LocalExample.java`](src/main/java/com/prakritidev/verma/JavaLock/LocalExample.java): Shows basic lock usage.
- [`JavaLock.md`](src/main/java/com/prakritidev/verma/JavaLock/JavaLock.md): Notes on lock types and fairness.

**Key snippet:**
```java
private Lock lock = new ReentrantLock();
lock.lock();
try {
    // critical section
} finally {
    lock.unlock();
}
```

## 7. Best Practices and Pitfalls
- Always shut down thread pools: `executorService.shutdown();`
- Avoid deadlocks by careful lock ordering
- Use `ThreadLocal` for thread-confined data
- Prefer `ExecutorService` over manual thread management for most use cases

## 8. Further Reading
- [Java Concurrency in Practice](https://jcip.net/)
- [Official Java Concurrency Tutorial](https://docs.oracle.com/javase/tutorial/essential/concurrency/)

---