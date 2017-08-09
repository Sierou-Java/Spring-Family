package org.family.test;


import java.util.concurrent.CountDownLatch;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-07 下午5:43
 */
public class ThreadDemo {

    static final Integer SIZE = 100;

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(SIZE);

        Producer producer = new Producer(SIZE, countDownLatch);
        Consumer consumer = new Consumer(SIZE);

        Thread thread = new Thread(producer);
        Thread thread1 = new Thread(consumer);

        thread.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();

    }
}
