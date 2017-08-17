package org.sierou.aop.staticproxy;

import org.sierou.aop.common.Target;

/**
 * 静态代理
 *
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-13 下午8:11
 */
public class Proxy {

    private Target target;

    public Proxy(Target target) {
        this.target = target;
    }

    public void say(){
        System.out.println("before ....");
        target.say();
        System.out.println("end ......");
    }
}
