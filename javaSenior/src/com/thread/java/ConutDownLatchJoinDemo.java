package com.thread.java;


/**
 * join方法示例
 * 比如有三个人小红、小李、小王， 三个人相约一起去酒店吃饭，菜已经点好了， 三个人从不同的地方出发，只有三个人都到了酒店之后才会开始上菜；那么这三个人就分别代表三个线程，这三个线程执行完之后才会执行 “上菜” 的代码逻辑，
 */
public class ConutDownLatchJoinDemo implements Runnable {


    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "开始出发了");
        try {
            if(Thread.currentThread().getName().equals("小李")){
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "到酒店了");


    }
}

// 酒店线程
class Hotel2 implements  Runnable{

    Thread thread;

    public Hotel2 ( Thread thread){
        this.thread = thread;
    }
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() +"正在等待大家的到来.....");
        try {
            // 待其他线程执行完成后在执行下面的代码
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("人齐了，"+Thread.currentThread().getName() +"服务员开始上菜");
    }
}
class Main2 {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new ConutDownLatchJoinDemo(), "小红");
        Thread t2 = new Thread(new ConutDownLatchJoinDemo(), "小王");
        Thread t3 = new Thread(new ConutDownLatchJoinDemo(), "小李");

        // 三个人同时出发
        t1.start();
        t2.start();
        t3.start();

        // 酒店也开始着手准备好将要上的菜
        new Thread(new Hotel2(t2),"酒店").start();


    }
}