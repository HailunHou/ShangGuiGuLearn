/**
 * @author BOOM
 * @create 2022-11-07 21:52
 */
package com.thread.java;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 @author boom
 @create 2022-11-07 21:52
 @description 线程池拒绝策略
 */
public class ThreadTest11 {
    public static void main(String[] args) {
        //不报异常，且可以正常执行完程序(丢弃任务，但是不抛出异常。)
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 10L, TimeUnit.SECONDS,
//                new ArrayBlockingQueue<Runnable>(1), new ThreadPoolExecutor.DiscardPolicy());
        //报异常RejectedExecutionException，且不能执行完程序(丢弃任务并抛出RejectedExecutionException异常。)
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 10L, TimeUnit.SECONDS,
//                new ArrayBlockingQueue<Runnable>(1), new ThreadPoolExecutor.AbortPolicy());
        //(丢弃队列最前面的任务，然后重新提交被拒绝的任务。)
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 10L, TimeUnit.SECONDS,
//                new ArrayBlockingQueue<Runnable>(1), new ThreadPoolExecutor.DiscardOldestPolicy());
        //多余的任务会在调用线程前排队，即都由调用线程执行(由调用线程（提交任务的线程）处理该任务。)
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 10L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 6; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    System.out.println("等待5秒钟...");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("程序即将结束...");
        threadPoolExecutor.shutdown();
    }
}
