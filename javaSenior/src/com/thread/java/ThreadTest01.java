package com.thread.java;

/**
 * 多线程简单实现（实现Runnable方式）
 */
class Thread01 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest01 {
    public static void main(String[] args) {
        Thread01 thread01 = new Thread01();
        new Thread(thread01).start();
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
