package org.family.test;

import java.util.concurrent.CountDownLatch;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-07 下午5:39
 */
public class Producer implements Runnable{

    private Integer count;
    private CountDownLatch countDownLatch;

    public Producer(Integer count, CountDownLatch countDownLatch) {
        this.count = count;
        this.countDownLatch = countDownLatch;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < count; i ++) {
            System.out.println("count = " + countDownLatch.getCount());
            System.out.println("生产了" + i + "个手机");
            countDownLatch.countDown();
        }
    }
}
