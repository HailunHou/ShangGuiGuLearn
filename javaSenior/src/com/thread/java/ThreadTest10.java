/**
 * @author BOOM
 * @create 2022-11-05 20:12
 */
package com.thread.java;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author boom
 * @create 2022-11-05 20:12
 */
public class ThreadTest10 {
    public static void main(String[] args) {
        // 创建单线程-线程池，任务依次执行
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1,
                60, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(2),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            //创建任务
            Runnable runnable = () -> {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            };
//             将任务交给线程池管理
            threadPoolExecutor.execute(runnable);
        }
        threadPoolExecutor.shutdown();
    }
}
