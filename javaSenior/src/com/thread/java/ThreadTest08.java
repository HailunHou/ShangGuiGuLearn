/**
 * @author BOOM
 * @create 2022-11-05 18:28
 */
package com.thread.java;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 @author boom
 @create 2022-11-05 18:28
 @description 创建可定时执行的线程池
 */
public class ThreadTest08 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        for (int i = 0; i < 5; i++) {
            scheduledExecutorService.schedule(() -> {
                System.out.println(1);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }, 3, TimeUnit.SECONDS);
            try {
                Thread.sleep(2000);
                System.out.println("2秒过去了");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        scheduledExecutorService.shutdown();

    }
}
