package org.sierou.aop.common;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-13 下午8:12
 */
public class TargetImpl implements Target{

    @Override
    public void say() {
        System.out.println("target impl say hello world!");
    }
}
