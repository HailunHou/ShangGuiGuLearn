package com.thread.java;

class Clerk {
    private int count = 0;

    //    public synchronized void produce() {
    public void produce() {
        synchronized (this){
            if (count < 20) {
                count++;
                System.out.println(Thread.currentThread().getName() + "生产第" + count + "个产品");
                notify();
            }else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //    public synchronized void sale(){
    public void sale() {
        synchronized (this) {
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + "购买第" + count + "个产品");
                count--;
                notify();
            }else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}

class Customer implements Runnable {
    private Clerk clerk = null;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("消费者开始购买商品...");
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.sale();
        }
    }
}

class Producer extends Thread {
    private Clerk clerk = null;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产商品...");
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.produce();
        }
    }
}


public class ThreadTest03 {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        Producer p2 = new Producer(clerk);
        Producer p3 = new Producer(clerk);
        Customer c1 = new Customer(clerk);
        p1.start();
        p2.start();
        p3.start();
        new Thread(c1).start();

    }
}


//class Clerk{
//
//    private int productCount = 0;
//    //生产产品
//    public synchronized void produceProduct() {
//
//        if(productCount < 20){
//            productCount++;
//            System.out.println(Thread.currentThread().getName() + ":开始生产第" + productCount + "个产品");
//
//            notify();
//
//        }else{
//            //等待
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//    //消费产品
//    public synchronized void consumeProduct() {
//        if(productCount > 0){
//            System.out.println(Thread.currentThread().getName() + ":开始消费第" + productCount + "个产品");
//            productCount--;
//
//            notify();
//        }else{
//            //等待
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//}
//
//class Producer extends Thread{//生产者
//
//    private Clerk clerk;
//
//    public Producer(Clerk clerk) {
//        this.clerk = clerk;
//    }
//
//    @Override
//    public void run() {
//        System.out.println(getName() + ":开始生产产品.....");
//
//        while(true){
//
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            clerk.produceProduct();
//        }
//
//    }
//}
//
//class Consumer extends Thread{//消费者
//    private Clerk clerk;
//
//    public Consumer(Clerk clerk) {
//        this.clerk = clerk;
//    }
//
//    @Override
//    public void run() {
//        System.out.println(getName() + ":开始消费产品.....");
//
//        while(true){
//
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            clerk.consumeProduct();
//        }
//    }
//}
//
//public class ThreadTest03 {
//
//    public static void main(String[] args) {
//        Clerk clerk = new Clerk();
//
//        Producer p1 = new Producer(clerk);
//        p1.setName("生产者1");
//
//        Consumer c1 = new Consumer(clerk);
//        c1.setName("消费者1");
//        Consumer c2 = new Consumer(clerk);
//        c2.setName("消费者2");
//
//        p1.start();
//        c1.start();
//        c2.start();
//
//    }
//}

