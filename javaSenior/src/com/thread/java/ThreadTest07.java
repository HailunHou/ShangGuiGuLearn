/**
 * @author BOOM
 * @create 2022-11-05 16:48
 */
package com.thread.java;

/**
 @author boom
 @create 2022-11-05 16:48
 @description 不使用线程池创建10万个线程，使用时间为40~60秒
 */
public class ThreadTest07 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i <100000; i++) {
            new Thread(() -> {
                System.out.print(1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("创建线程使用时间：" + (end - start));
    }

}
