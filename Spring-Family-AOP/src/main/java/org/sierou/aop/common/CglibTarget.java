package org.sierou.aop.common;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-09 上午10:45
 */
public class CglibTarget {

    public String execute(){
        System.out.println("CglibTarget.execute");
        return "Cglib execute";
    }
}
