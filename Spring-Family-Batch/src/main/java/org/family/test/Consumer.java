package org.family.test;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-07 下午5:41
 */
public class Consumer implements Runnable{
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Consumer(Integer count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < count ; i++) {
            System.out.println("消费了" + i + "个手机");
        }
    }
}
