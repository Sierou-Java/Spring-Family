package org.sierou.aop.common;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-13 下午9:06
 */
public class CglibTargetImpl implements CglibTarget{

    @Override
    public void hello() {
        System.out.println("hello world!");
    }
}
