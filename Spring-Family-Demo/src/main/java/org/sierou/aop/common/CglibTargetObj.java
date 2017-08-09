package org.sierou.aop.common;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-09 上午11:02
 */
public class CglibTargetObj implements CglibTargetInterface{

    @Override
    public void execute() {
        System.out.println("CglibTargetObj.execute");
    }
}
