/**
 * @author BOOM
 * @create 2022-11-05 18:52
 */
package com.thread.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 @author boom
 @create 2022-11-05 18:52
 @description 创建单线程的线程池——可以指定线程任务执行的顺序（FIFO，LIFO，优先级）
 */
public class ThreadTest09 {
    public static void main(String[] args)  {
        // 创建单线程-线程池，任务依次执行
        ExecutorService newScheduledThreadPool = Executors.newSingleThreadExecutor();
        //报java.lang.ClassCastException
//        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) newScheduledThreadPool;
        for (int i = 0; i < 5; i++) {
            //执行完shutdown()后，线程池状态从Running转换为Shutdown，不再接受任务提交，但仍然执行正在执行的任务和阻塞队列中的任务。
            if(i == 3){
                newScheduledThreadPool.shutdown();
                System.out.println("执行了shutdown()...");
            }
            //创建任务
            Runnable runnable = () -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
            // 将任务交给线程池管理
            newScheduledThreadPool.execute(runnable);
        }
//        System.out.println("线程池大小：" + threadPoolExecutor.getPoolSize());
        newScheduledThreadPool.shutdown();
    }
}
