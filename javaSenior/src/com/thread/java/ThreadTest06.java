package com.thread.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description 使用线程池创建10万个线程，使用时间5秒
 */
public class ThreadTest06 {
    public static void main(String[] args) {
        //newCachedThreadPool():创建一个可以缓存的线程池，如果线程池长度超过处理需要，可以灵活回收空闲线程，没回收的话就新建线程。
//        ExecutorService executorService = Executors.newCachedThreadPool();
        //newFixedThreadPool():创建一个定长的线程池，可控制最大并发数，超出的线程进行队列等待。
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
//        executorService.execute(new RunnableThread01());
//        executorService.execute(new RunnableThread01());
//        executorService.execute(new RunnableThread01());
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            executorService.execute(() -> {
                System.out.print(1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("创建线程使用时间：" + (end - start));
        while (true) {
            System.out.println();

            int queueSize = threadPoolExecutor.getQueue().size();
            System.out.println("当前排队线程数：" + queueSize);

            int activeCount = threadPoolExecutor.getActiveCount();
            System.out.println("当前活动线程数：" + activeCount);

            long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
            System.out.println("执行完成线程数：" + completedTaskCount);

            long taskCount = threadPoolExecutor.getTaskCount();
            System.out.println("总线程数：" + taskCount);
            System.out.println("当前池大小：" + threadPoolExecutor.getPoolSize());

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//        executorService.shutdown();
    }
}

class RunnableThread01 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ":" + i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}