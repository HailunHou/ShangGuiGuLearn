package com.thread.java;


/**
 * 多线程简单实现（继承Thread方式）
 */
class Thread02 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest02 {
    public static void main(String[] args) {
        Thread02 thread02 = new Thread02();
        thread02.start();
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
