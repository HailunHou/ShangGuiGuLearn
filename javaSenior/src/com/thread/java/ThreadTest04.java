package com.thread.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest04 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        FutureTask futureTask1 = new FutureTask(new Thread41());
        FutureTask futureTask2 = new FutureTask(new Thread42());
        FutureTask futureTask3 = new FutureTask(new Thread43());
        FutureTask futureTask4 = new FutureTask(new Thread44());
        Thread thread1 = new Thread(futureTask1);
        Thread thread2 = new Thread(futureTask2);
        Thread thread3 = new Thread(futureTask3);
        Thread thread4 = new Thread(futureTask4);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int sum4 = 0;

        try {
            sum1 = (Integer) futureTask1.get();
            sum2 = (Integer) futureTask2.get();
            sum3 = (Integer) futureTask3.get();
            sum4 = (Integer) futureTask4.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sum1 + sum2 + sum3 + sum4);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}

class Thread41 implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 30; i++) {
            Thread.sleep(100);
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + ": 运行结束");
        return sum;
    }
}

class Thread42 implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 30; i < 60; i++) {
            Thread.sleep(100);
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + ": 运行结束");
        return sum;
    }
}

class Thread43 implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 60; i < 90; i++) {
            Thread.sleep(100);
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + ": 运行结束");
        return sum;
    }
}

class Thread44 implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 90; i <= 100; i++) {
            Thread.sleep(100);
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + ": 运行结束");
        return sum;
    }
}