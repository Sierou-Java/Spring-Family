package org.sierou.aop.common;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-09 上午9:45
 */
public class TargetImpl implements Target{

    @Override
    public String execute() {
        System.out.println("TargetImpl.execute");
        return "TargetImpl.execute";
    }
}
