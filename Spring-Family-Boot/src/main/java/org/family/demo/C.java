package org.family.demo;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-09-01 下午6:29
 */
public class C  extends B{

    @Override
    public void parentTest() {
        System.out.println("this is C parentTest");
    }

    public void thisC(){
        System.out.println("this C");
    }
}
